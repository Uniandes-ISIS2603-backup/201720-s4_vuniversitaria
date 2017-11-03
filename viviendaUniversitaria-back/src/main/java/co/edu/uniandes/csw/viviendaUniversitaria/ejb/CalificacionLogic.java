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
        if (persistence.find(entity.getId())!= null)
            throw new BusinessLogicException("Ya existe una Calificacion con el id \"" + entity.getId()+ "\"");
        persistence.create(entity);
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
    
    public List<CalificacionEntity> getCalificacionesHospedaje(Long idHospedaje) throws BusinessLogicException {
        
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if (hospedaje.getCalificaciones() == null) {
            throw new BusinessLogicException("El hospedaje que consulta aún no tiene calificaciones");
        }
        if (hospedaje.getCalificaciones().isEmpty()) {
            throw new BusinessLogicException("El hospedaje que consulta aún no tiene calificaciones");
        }
        return hospedaje.getCalificaciones();
    }
    
    
    public CalificacionEntity getCalificacionEstudiante(Long idEstudiante, Long id) throws BusinessLogicException {
        CalificacionEntity calificacion= new CalificacionEntity();
        calificacion.setId(id);
        List<CalificacionEntity> calificaciones= estudianteLogic.find(idEstudiante).getCalificaciones();
        if(calificaciones.isEmpty())
            throw new BusinessLogicException("El estudiante no tiene calificaciones");
        
        int ind=calificaciones.indexOf(calificacion);
        if(ind<0)
            throw new BusinessLogicException("No se encuentra la calificacion");
        
        return calificaciones.get(ind);
    }
    
    public CalificacionEntity getCalificacionHospedaje(Long idHospedaje, Long id) throws BusinessLogicException {
        CalificacionEntity calificacion= new CalificacionEntity();
        calificacion.setId(id);
        List<CalificacionEntity> calificaciones= hospedajeLogic.find(idHospedaje).getCalificaciones();
        if(calificaciones.isEmpty())
            throw new BusinessLogicException("El hospedaje no tiene calificaciones");
        
        int ind=calificaciones.indexOf(calificacion);
        if(ind<0)
            throw new BusinessLogicException("No se encuentra la calificacion");
        
        return calificaciones.get(ind);
    }
            
    public CalificacionEntity create(long idEstudiante, Long idHospedaje, CalificacionEntity entity) throws BusinessLogicException {
        EstudianteEntity usuario=estudianteLogic.find(idEstudiante);
        HospedajeEntity hospedaje= hospedajeLogic.find(idHospedaje);
        
        if(usuario== null || hospedaje==null)
            throw new BusinessLogicException("El estudiante o el hospedaje no existe.");
        
        entity.setEstudiante(usuario);
        
        entity.setHospedaje(hospedaje);
        return createCalificacion(entity);
    }

    public void remove(long idUsuario,long id) throws BusinessLogicException {
        CalificacionEntity ent=getCalificacionEstudiante(idUsuario,id);
        EstudianteEntity estudiante= estudianteLogic.find(idUsuario);
        if(estudiante== null)
            throw new BusinessLogicException("El estudiante no esta registrado.");
                    
        estudiante.getCalificaciones().remove(ent);
        persistence.delete(id);
    }


}
