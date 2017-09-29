/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.EstudiantePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ISIS2603
 */
@Stateless
public class EstudianteLogic {

    private static final Logger LOGGER = Logger.getLogger(EstudianteLogic.class.getName());

    @Inject
    private EstudiantePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private CalificacionLogic calificacionLogic;

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public EstudianteEntity createEstudiante(EstudianteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de estudiante");
        // Invoca la persistencia para crear la Default
        if (entity.getCedula() == null) {
            throw new BusinessLogicException("la cedula no puede estar vacia");
        }
        if (getEstudiante(entity.getCedula()) != null) {
            throw new BusinessLogicException("la cedula no estar repetida");
        }
        LOGGER.info("Termina proceso de creación de estudiante");
        persistence.create(entity);

        return entity;
    }

    /**
     *
     * Obtener todas las Defaultes existentes en la base de datos.
     *
     * @return una lista de Defaultes.
     */
    public List<EstudianteEntity> getEstudiantes() {
        LOGGER.info("Inicia proceso de consultar todos los estudiantes");
        List<EstudianteEntity> estudiante = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los estudiantes");
        return estudiante;
    }

    /**
     * Obtiene los datos de una instancia de Estudiante a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de EstudianteEntity con los datos del Estudiante
     * consultado.
     * @generated
     */
    public EstudianteEntity getEstudiante(Long cedula) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un estudiante con id = {0}", cedula);
        EstudianteEntity estudiante = persistence.find(cedula);
        if (cedula == null) {
            LOGGER.log(Level.SEVERE, "El estudiante con el id {0} no existe", cedula);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar estudiante con id={0}", cedula);
        return estudiante;
    }
    public OrigenEntity getOrigen(Long cedula) {
        return getEstudiante(cedula).getOrigen();
    }
    /**
     * Actualiza la información de una instancia de Estudiante.
     *
     * @param entity Instancia de EstudianteEntity con los nuevos datos.
     * @return Instancia de EstudianteEntity con los datos actualizados.
     * @generated
     */
    public EstudianteEntity updateEstudiante(EstudianteEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un estudiante ");
        if (entity.getCedula() == null) {
            throw new BusinessLogicException("no existe estudiante");
        }
        EstudianteEntity rta = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar estudiante", entity.getCedula());
        return rta;
    }

    /**
     * Elimina una instancia de Estudiante de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteEstudiante(Long cedula) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un estudiante ");
        if (cedula == null) {
            throw new BusinessLogicException("la cedula es invalida para buscar un estudiante");
        }
        persistence.delete(cedula);
    }

    public CalificacionEntity addCalificacion(Long idCalificacion, Long idEstudiante) throws BusinessLogicException {
        EstudianteEntity estudianteEntity = getEstudiante(idEstudiante);
        CalificacionEntity calificacionEntity = calificacionLogic.getCalificacion(idCalificacion);
        if (calificacionEntity == null) {
            throw new BusinessLogicException("no existe la calificacion");
        }
        calificacionEntity.setEstudiante(estudianteEntity);
        return calificacionEntity;
    }

    public CalificacionEntity getCalificacion(Long estudianteId, Long idCalificacion) throws BusinessLogicException {
        List<CalificacionEntity> calificaciones = getEstudiante(estudianteId).getCalificaciones();
        CalificacionEntity calificacion = calificacionLogic.getCalificacion(idCalificacion);
        int index = calificaciones.indexOf(calificacion);
        if (index >= 0) {
            return calificaciones.get(index);
        }
        throw new BusinessLogicException("la calificacion no está asociada al estudiante");

    }

    public List<CalificacionEntity> getCalificaciones(Long idCalificacion) throws BusinessLogicException {
        return getEstudiante(idCalificacion).getCalificaciones();
    }

    public List<CalificacionEntity> listCalificaciones(Long cedula) {
        return getEstudiante(cedula).getCalificaciones();
    }

    public void removeCalificaciones(Long idCalificacion, Long cedula) throws BusinessLogicException {
        CalificacionEntity calificacionEntity = new CalificacionEntity();
        calificacionEntity.setId(idCalificacion);
        List<CalificacionEntity> list = getEstudiante(cedula).getCalificaciones();
        int i = list.indexOf(calificacionEntity);
        if (i < 0) {
            throw new BusinessLogicException("El recurso /origen/" + idCalificacion + "/Estudiante no existe.");
        }
        list.remove(calificacionEntity);
    }
}
