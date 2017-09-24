/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ArrendadorPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author kk.penaranda
 */
@Stateless
public class ArrendadorLogic {
    private static final Logger LOGGER = Logger.getLogger(ArrendadorLogic.class.getName());

    @Inject
    private ArrendadorPersistence persistence; 
    
    
    public ArrendadorEntity createArrendador(ArrendadorEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de arrendador");
        if (persistence.find(entity.getId())!= null)
            throw new BusinessLogicException("Ya existe un Arrendador con el id \"" + entity.getId()+"\"");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de un arrendador");
        return entity;
    }
    
        public List<ArrendadorEntity> getArrendadores() {
        LOGGER.info("Inicia proceso de consultar todos los arrendadores");
        List<ArrendadorEntity> arrendadores = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los arrendadores");
        return arrendadores;
    }
        
        public ArrendadorEntity getArrendador(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar arrendador con id={0}", id);
        ArrendadorEntity arrendador = persistence.find(id);
        if (arrendador == null) {
            LOGGER.log(Level.SEVERE, "El arrendador con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar arrendador con id={0}", id);
        return arrendador;
    }

    public ArrendadorEntity updateArrendador(Long id, ArrendadorEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar arrendador con id={0}", id);
        ArrendadorEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar arrendador con id={0}", entity.getId());
        return newEntity;
    }
    
    public void deleteArrendador(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar arrendador con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar arrendador con id={0}", id);
    }
}
