/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;


import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
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
 * Logica de la clase Calificacion
 * @author kk.penaranda
 */
@Stateless
public class CalificacionLogic {
    /**
     * Logger para los mensajes
     */
    private static final Logger LOGGER = Logger.getLogger(CalificacionLogic.class.getName());

    /**
     *  Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
     */
    private  CalificacionPersistence persistence; 
    
    /**
     * Logica de la clase hospedaje
     */
    private  HospedajePersistence hospedajeLogic;
    
    /**
     * Logica del estudiante que realice la calificacion
     */
    private EstudiantePersistence estudianteLogic;
    
    /**
     * Constructor por defecto
     */
    public CalificacionLogic(){
        //Constructor por defecto
    }
    
    /**
     * Constructor de la logica de la calificacion
     * @param hospedajeLogic
     * @param estudianteLogic
     * @param persistence 
     */
    @Inject
    public CalificacionLogic(HospedajePersistence hospedajeLogic, EstudiantePersistence estudianteLogic, CalificacionPersistence persistence){
        this.estudianteLogic= estudianteLogic;
        this.hospedajeLogic= hospedajeLogic;
        this.persistence = persistence;
    }

    /**
     * Metodo para crear las calificaciones
     * @param entity de la calificacion
     * @return Entidad de la calificacion
     * @throws BusinessLogicException 
     */
    public CalificacionEntity createCalificacion(CalificacionEntity entity) throws BusinessLogicException {
        if (persistence.find(entity.getId())!= null)
            throw new BusinessLogicException("Ya existe una Calificacion con el id \"" + entity.getId()+ "\"");
        persistence.create(entity);
        return entity;
    }
            
    /**
     * Obtiene una calificacion dada por parametro
     * @param id
     * @return calificacion buscada
     */
    public CalificacionEntity getCalificacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar calificacion con id={0}", id);
        CalificacionEntity calificacion = persistence.find(id);
        if (calificacion == null) {
            LOGGER.log(Level.SEVERE, "La calificacion con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar calificacion con id={0}", id);
        return calificacion;
    }
    
    /**
     * Lista de calificaciones de un hospedaje
     * @param idHospedaje
     * @return lista de entidades de calificacion
     * @throws BusinessLogicException 
     */
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
    
    /**
     * Dar una calificacion asociada a un estudiante
     * @param idEstudiante
     * @param id de la calificacion
     * @return calificacion del estudiante
     * @throws BusinessLogicException 
     */
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
    
    /**
     * Dar la calificacion de un estudiante
     * @param idHospedaje
     * @param id de la calificacion
     * @return entidad de la calificacion
     * @throws BusinessLogicException 
     */
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
        
    /**
     * Crea una nueva calificacion para un hospedaje
     * @param idHospedaje hospedaje al que se calificara
     * @param entity calificacion
     * @return entidad de la calificacion
     * @throws BusinessLogicException 
     */    
    public CalificacionEntity create(Long idHospedaje, CalificacionEntity entity) throws BusinessLogicException {
        
        HospedajeEntity hospedaje= hospedajeLogic.find(idHospedaje);
        
        if(hospedaje==null)
            throw new BusinessLogicException("El hospedaje no existe.");
        
        entity.setHospedaje(hospedaje);
        return createCalificacion(entity);
    }
 
    /**
     * Elimina una calificacion de un hospedaje
     * @param idUsuario hospedaje 
     * @param id de la calificacion
     * @throws BusinessLogicException 
     */
    public void remove(long idUsuario,long id) throws BusinessLogicException {
        CalificacionEntity ent= getCalificacionHospedaje(idUsuario,id);
        HospedajeEntity estudiante= hospedajeLogic.find(idUsuario);
        if(estudiante== null)
            throw new BusinessLogicException("El hospedaje no esta registrado.");
                    
        estudiante.getCalificaciones().remove(ent);
        persistence.delete(id);
    }


}
