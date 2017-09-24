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


import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
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

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public EstudianteEntity createEstudiante(EstudianteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Default");
        // Invoca la persistencia para crear la Default
        if(validate(entity.getCedula())!=false){
            throw new BusinessLogicException("el id es invalido para crear un estudiante");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Default");
        return entity;
    }

    /**
     * 
     * Obtener todas las Defaultes existentes en la base de datos.
     *
     * @return una lista de Defaultes.
     */
    public List<EstudianteEntity> getEstudiantes() {
        LOGGER.info("Inicia proceso de consultar todas las Defaultes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        
        List<EstudianteEntity> Default = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Defaultes");
        return Default;
    }
 /**
     * Obtiene los datos de una instancia de Estudiante a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de EstudianteEntity con los datos del Estudiante consultado.
     * @generated
     */
    public EstudianteEntity getEstudiante(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un estudiante con id = {0}", id);
        if(validate(id)==false){
            throw new BusinessLogicException("el id es invalido para buscar un estudiante");
        }
        return persistence.find(id);
    }
 /**
     * Actualiza la información de una instancia de Estudiante.
     *
     * @param entity Instancia de EstudianteEntity con los nuevos datos.
     * @return Instancia de EstudianteEntity con los datos actualizados.
     * @generated
     */
    public EstudianteEntity updateEstudiante(EstudianteEntity entity) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un estudiante ");
         if(validate(entity.getCedula())==false){
            throw new BusinessLogicException("el id es invalido para update un estudiante");
        }
        return persistence.update(entity);
    }
    
        /**
     * Elimina una instancia de Estudiante de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteEstudiante(Long id) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un estudiante ");
         if(validate(id)==false){
            throw new BusinessLogicException("el id es invalido para buscar un estudiante");
        }
        persistence.delete(id);
    }

     private boolean validate(Long id) {
        if (id == null) {
            return false;
        }
        return true;
    }
}
