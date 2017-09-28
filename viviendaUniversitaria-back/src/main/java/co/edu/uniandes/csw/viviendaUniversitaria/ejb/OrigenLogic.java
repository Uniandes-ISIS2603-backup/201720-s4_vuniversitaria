/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.OrigenPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.eslava
 */
@Stateless
public class OrigenLogic {

    private static final Logger LOGGER = Logger.getLogger(OrigenLogic.class.getName());

    @Inject
    private OrigenPersistence persistence;
    @Inject
    private EstudianteLogic estudianteLogic;

    public EstudianteEntity addEstudiante(Long cedula, Long idOrigen) {
        OrigenEntity origenEntity = getOrigen(idOrigen);
        EstudianteEntity estudianteEntity = estudianteLogic.getEstudiante(cedula);
        estudianteEntity.setOrigen(origenEntity);
        return estudianteEntity;
    }

    /**
     *
     * @param entity
     * @return nuevo origenEntity
     * @throws BusinessLogicException
     */
    public OrigenEntity createOrigen(OrigenEntity entity) throws BusinessLogicException {
        LOGGER.info("Termina proceso de creación de editorial");
        return persistence.create(entity);
    }

    public EstudianteEntity getEstudiante(Long origenId, Long cedula) throws BusinessLogicException {
        List<EstudianteEntity> estudiantes = getOrigen(origenId).getEstudiante();
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(cedula);
        int index = estudiantes.indexOf(estudiante);
        if (index >= 0) {
            return estudiantes.get(index);
        }
        throw new BusinessLogicException("El estudiante no está asociado al origen");

    }

    public List<EstudianteEntity> getEstudiantes(Long cedula) throws BusinessLogicException {
        return getOrigen(cedula).getEstudiante();
    }

    /**
     *
     * Obtener todas los origenes existentes en la base de datos.
     *
     * @return una lista de origenes.
     */
    public List<OrigenEntity> getOrigenes() {
        LOGGER.info("Inicia proceso de consultar todas los origenes");
        List<OrigenEntity> origenes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas los origenes");
        return origenes;
    }

    public List<EstudianteEntity> listEstudiantes(Long idOrigen) {
        return getOrigen(idOrigen).getEstudiante();
    }

    public void removeEstudiante(Long cedula, Long idOrigen) {
        OrigenEntity origenEntity = getOrigen(idOrigen);
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(cedula);
        estudiante.setOrigen(null);
        origenEntity.getEstudiante().remove(estudiante);
    }

    public OrigenEntity updateEditorial(Long id, OrigenEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar origen con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        OrigenEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar origen con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Obtiene los datos de una instancia de Origen a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de OrigenEntity con los datos del Origen consultado.
     * @generated
     */
    public OrigenEntity getOrigen(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar origen con id={0}", id);
        OrigenEntity origen = persistence.find(id);
        if (origen == null) {
            LOGGER.log(Level.SEVERE, "La origen con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar origen con id={0}", id);
        return origen;
    }

    /**
     * Actualiza la información de una instancia de Origen.
     *
     * @param entity Instancia de OrigenEntity con los nuevos datos.
     * @return Instancia de OrigenEntity con los datos actualizados.
     * @generated
     */
    public OrigenEntity updateOrigen(Long id,OrigenEntity entity) throws BusinessLogicException {
        entity.setId(id);
        OrigenEntity old=getOrigen(id);
        if(old==null)
            throw new BusinessLogicException("no existe un origen con id:"+id);
        entity.setEstudiante(old.getEstudiante());
        return persistence.update(entity);
    }
    /**
     * Elimina una instancia de Origen de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteOrigen(Long id) {
        persistence.delete(id);
    }

    private boolean validate(Long id) {
        if (id == null) {
            return false;
        }
        return true;
    }
}
