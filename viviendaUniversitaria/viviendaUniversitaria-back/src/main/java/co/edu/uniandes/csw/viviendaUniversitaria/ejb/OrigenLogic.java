/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.OrigenPersistence;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.OrigenPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author a.eslava
 */
public class OrigenLogic {
    
         private static final Logger LOGGER = Logger.getLogger(OrigenLogic.class.getName());

        @Inject
        private OrigenPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    public OrigenEntity createOrigen(OrigenEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Default");
        // Invoca la persistencia para crear la Default
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
    public List<OrigenEntity> getOrigens() {
        LOGGER.info("Inicia proceso de consultar todas las Defaultes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<OrigenEntity> Default = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Defaultes");
        return Default;
    }
 /**
     * Obtiene los datos de una instancia de Origen a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de OrigenEntity con los datos del Origen consultado.
     * @generated
     */
    public OrigenEntity getOrigen(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un Origen con id = {0}", id);
        return persistence.find(id);
    }
 /**
     * Actualiza la información de una instancia de Origen.
     *
     * @param entity Instancia de OrigenEntity con los nuevos datos.
     * @return Instancia de OrigenEntity con los datos actualizados.
     * @generated
     */
    public OrigenEntity updateOrigen(OrigenEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un Origen ");
        return persistence.update(entity);
    }
    
        /**
     * Elimina una instancia de Origen de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteOrigen(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un Origen ");
        persistence.delete(id);
    }

}
