/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;


import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.CalificacionPersistence;
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
public class CalificacionLogic {
    private static final Logger LOGGER = Logger.getLogger(CalificacionLogic.class.getName());

    @Inject
    private CalificacionPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

  
    public CalificacionEntity createCalificacion(CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de city");
        if (persistence.find(entity.getId())!= null)
            throw new BusinessLogicException("Ya existe una Calificacion con el id \"" + entity.getId()+ "\"");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de la calificacion");
        return entity;
    }
    
        public List<CalificacionEntity> getCalificacion() {
        LOGGER.info("Inicia proceso de consultar todas las calificaciones");
        List<CalificacionEntity> calificaciones = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las calificaciones");
        return calificaciones;
    }
        
        public CalificacionEntity getCalificacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar calificacion con id={0}", id);
        CalificacionEntity calificacion = persistence.find(id);
        if (calificacion == null) {
            LOGGER.log(Level.SEVERE, "La calificacion con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar calificacion con id={0}", id);
        return calificacion;
    }

    public CalificacionEntity updateCalificacion(Long id, CalificacionEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar calificacion con id={0}", id);
        CalificacionEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar calificacion con id={0}", entity.getId());
        return newEntity;
    }
    
    public void deleteCalificacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar calificacion con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar calificacion con id={0}", id);
    }
}
