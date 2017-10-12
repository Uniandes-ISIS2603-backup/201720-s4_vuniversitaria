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
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.EstudiantePersistence;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajePersistence;
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

    private  CalificacionPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    
    private  HospedajePersistence hospedajeLogic;
    
    private EstudiantePersistence estudianteLogic;
    
    public CalificacionLogic(){
        //Constructor por defecto
    }
    
    @Inject
    public CalificacionLogic(HospedajePersistence hospedajeLogic, EstudiantePersistence estudianteLogic, CalificacionPersistence persistence){
        this.estudianteLogic= estudianteLogic;
        this.hospedajeLogic= hospedajeLogic;
        this.persistence = persistence;
    }

  
    public CalificacionEntity createCalificacion(CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de calificacion");
        if (persistence.find(entity.getId())!= null)
            throw new BusinessLogicException("Ya existe una Calificacion con el id \"" + entity.getId()+ "\"");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de la calificacion");
        return entity;
    }
    
        public List<CalificacionEntity> getCalificaciones() {
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
    
    
    public HospedajeEntity getHospedaje(Long idCalificacion) throws BusinessLogicException{
      CalificacionEntity calificacion=persistence.find(idCalificacion);
      if (calificacion==null){
          throw new BusinessLogicException("No se pudo encontrar una calificacion con ese id");
      }
      return calificacion.getHospedaje();
  }
    
    public HospedajeEntity setHospedaje(Long idCalificacion, HospedajeEntity hospedaje) throws BusinessLogicException{
        CalificacionEntity calificacion = persistence.find(idCalificacion);
        if(calificacion == null){
            throw new BusinessLogicException("No se pudo encontrar una calificacion con ese id");
        }
        calificacion.setHospedaje(hospedaje);
        persistence.update(calificacion);
        return hospedaje;
    }   
    
    public EstudianteEntity getEstudiante(Long idCalificacion) throws BusinessLogicException{
        CalificacionEntity calificacion = persistence.find(idCalificacion);
        if(calificacion== null){
            throw new BusinessLogicException("No existe una calificacion con el id ingresado");
        }
        return calificacion.getEstudiante();
    }
    
    public EstudianteEntity setEstudiante(Long idCalificacion, EstudianteEntity estudiante) throws BusinessLogicException{
        CalificacionEntity calificacion= persistence.find(idCalificacion);
        if(calificacion== null){
            throw new BusinessLogicException("No existe una calificcaion con el id ingresado");
        }
        calificacion.setEstudiante(estudiante);
        persistence.update(calificacion);
        return estudiante;
    }
    
    public void asociarCalificacionAEstudianteHospedaje(Long idHospedaje, Long idEstudiante, CalificacionEntity calificacion) throws BusinessLogicException{
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        EstudianteEntity estudiante = estudianteLogic.find(idEstudiante);
        
        if(hospedaje== null || estudiante== null)
            throw new BusinessLogicException("No existe alguna de las entidades buscadas");
        
        calificacion.setHospedaje(hospedaje);
        calificacion.setEstudiante(estudiante);
        persistence.update(calificacion);
    }    
}
