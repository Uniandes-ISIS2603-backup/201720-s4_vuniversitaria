/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;


import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
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
    
    @Inject
    private HospedajeLogic hospedajeLogic;
    
    @Inject
    private EstudianteLogic estudianteLogic;

  
    public CalificacionEntity createCalificacion(CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de calificacion");
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

    public CalificacionEntity createCalificacionHospedajeEstudiante(CalificacionEntity entity, Long idHospedaje, Long idEstudiante) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de calificacion");
        if (persistence.find(entity.getId())!= null)
            throw new BusinessLogicException("Ya existe una Calificacion con el id \"" + entity.getId()+ "\"");
        
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        entity.setHospedaje(hospedaje);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de la calificacion");
        return entity;    }

    public List<CalificacionEntity> getCalificacionesHospedajeDado(Long idHospedaje) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todas las calificaciones de un hospedaje");
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if (hospedaje.getCalificaciones() == null) {
            throw new BusinessLogicException("El hospedaje que consulta aún no tiene calificaciones");
        }
        if (hospedaje.getCalificaciones().isEmpty()) {
            throw new BusinessLogicException("El libro que consulta aún no tiene reviews");
        }
        return hospedaje.getCalificaciones();
    }

    public List<CalificacionEntity> getCalificacionesEstudiante(Long idEstudiante) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todas las calificaciones de un estudiante");
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(idEstudiante);
        if (estudiante.getCalificaciones() == null) {
            throw new BusinessLogicException("El estudiante que consulta aún no tiene calificaciones");
        }
        if (estudiante.getCalificaciones().isEmpty()) {
            throw new BusinessLogicException("El estudiante que consulta aún no tiene reviews");
        }
        return estudiante.getCalificaciones();   
    }

    public CalificacionEntity getCalificacionesHospedaje(Long idHospedaje, Long id) {
        return persistence.getListaCalificacionesHospedaje(idHospedaje, id);
    }

    public CalificacionEntity getCalificacionesEstudiante(Long idEstudiante, Long id) {
        return persistence.getListaCalificacionesEstudiante(idEstudiante, id);
    }

    public CalificacionEntity updateCalificacionHospedajeEstudiante(Long idEstudiante, CalificacionEntity entity) {
        LOGGER.info("Inicia proceso de actualizar una calificacion");
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(idEstudiante);
        entity.setEstudiante(estudiante);
        return persistence.update(entity);
    }

    public void deleteCalificacionEstudiante(Long idEstudiante, Long id) {
        LOGGER.info("Inicia proceso de borrar calificaciones");
        CalificacionEntity old = getCalificacionesEstudiante(idEstudiante, id);
        persistence.delete(old.getId());    
    }
}
