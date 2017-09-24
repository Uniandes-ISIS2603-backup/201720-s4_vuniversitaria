/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.UniversidadPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author c.santacruza
 */
@Stateless
public class UniversidadLogic {

    private static final Logger LOGGER = Logger.getLogger(UniversidadLogic.class.getName());

    @Inject
    private UniversidadPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public UniversidadEntity createUniversidad(UniversidadEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Universidad");
        // Invoca la persistencia para crear la Universidad
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Universidad");
        return entity;
    }

    /**
     * 
     * Obtener todas las Universidades existentes en la base de datos.
     *
     * @return una lista de Universidades.
     */
    public List<UniversidadEntity> getUniversidades() {
        LOGGER.info("Inicia proceso de consultar todas las Universidades");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<UniversidadEntity> Universidad = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Universidades");
        return Universidad;
    }
 /**
     * Modificar una universidad dado un id.
     * @param entity, contiene la nueva información de la universidad
     * @Return UniversidadEntity
     */
    public UniversidadEntity updateUniversidad(UniversidadEntity entity){
        UniversidadEntity aModificar =  persistence.update(entity);
        return aModificar;
    }
    /**
     * Elimina una universidad dado un id
     * @param id, el id de la universidad a eliminar
     */
    public void deleteUniversidad(Long id){
        persistence.delete(id);
    }
}