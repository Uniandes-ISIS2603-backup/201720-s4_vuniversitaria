/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.CalificacionDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.CalificacionLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.CalificacionPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author kk.penaranda
 */
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionResource {
    @Inject
    private CalificacionLogic calificacionLogic; // Variable para acceder a la lógica de la aplicación.     
    

    private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());
    
    @POST
    public CalificacionDetailDTO createCalificacion(@PathParam("idEstudiante") Long idEstudiante, @PathParam("idHospedaje") Long idHospedaje, CalificacionDetailDTO calificacion) throws BusinessLogicException {
        
        CalificacionEntity nuevo= calificacionLogic.createCalificacionHospedajeEstudiante(calificacion.toEntity(), idHospedaje, idEstudiante);
        return new CalificacionDetailDTO(nuevo);
    }

    @GET
    public List<CalificacionDetailDTO> getCalificacionesHospedaje(@PathParam("idHospedaje") Long idHospedaje) throws BusinessLogicException {
        if(listEntity2DetailDTO(calificacionLogic.getCalificacionesHospedajeDado(idHospedaje)).isEmpty())
            throw new WebApplicationException("La lista de calificaciones del hospedaje esta vacía", 404);
        return listEntity2DetailDTO(calificacionLogic.getCalificacionesHospedajeDado(idHospedaje));
    }
    
    @GET
    public List<CalificacionDetailDTO> getCalificacionesEstudiante(@PathParam("idEstudiante") Long idEstudiante) throws BusinessLogicException {
        if(listEntity2DetailDTO(calificacionLogic.getCalificacionesEstudiante(idEstudiante)).isEmpty())
            throw new WebApplicationException("La lista de calificaciones del estudiante esta vacía", 404);
        return listEntity2DetailDTO(calificacionLogic.getCalificacionesEstudiante(idEstudiante));
    }

    @GET
    @Path("{id: [0-9][0-9]*}")
    public CalificacionDetailDTO getCalificacionEspecificaHospedaje( @PathParam("idHospedaje") Long idHospedaje, @PathParam("id") Long id) throws BusinessLogicException {
        CalificacionEntity entity = calificacionLogic.getCalificacionesHospedaje(idHospedaje, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/ " + id + " no existe.", 404);
        }
        return new CalificacionDetailDTO(entity);
    }
    
    @GET
    @Path("{id: [0-9][0-9]*}")
    public CalificacionDetailDTO getCalificacionEspecificaEstudiante( @PathParam("idEstudiante") Long idEstudiante, @PathParam("id") Long id) throws BusinessLogicException {
        CalificacionEntity entity = calificacionLogic.getCalificacionesEstudiante(idEstudiante, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/ " + id + " no existe.", 404);
        }
        return new CalificacionDetailDTO(entity);
    }

    
    @PUT
    @Path("{id: [0-9][0-9]*}")
    public CalificacionDetailDTO updateCalificacion(@PathParam("idEstudiante") Long idEstudiante, @PathParam("id") Long id, CalificacionDTO calificacion) throws BusinessLogicException {
        calificacion.setId(id);
        CalificacionEntity entity = calificacionLogic.getCalificacionesEstudiante(idEstudiante, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/" + id + "/estudiante/"+idEstudiante+ "no existe.", 404);
        }
        return new CalificacionDetailDTO(calificacionLogic.updateCalificacionHospedajeEstudiante(idEstudiante, calificacion.toEntity()));
    }

    @DELETE
    @Path("{id: [0-9][0-9]*}")
    public void deleteCalificacion(@PathParam("idEstudiante") Long idEstudiante, @PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una calificacion de un estudiante con id {0}", id);
        CalificacionEntity entity = calificacionLogic.getCalificacionesEstudiante(idEstudiante, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/ del estudiante" + id + " no existe.", 404);
        }
        calificacionLogic.deleteCalificacionEstudiante(idEstudiante, id);
    }
    private List<CalificacionDetailDTO> listEntity2DetailDTO(List<CalificacionEntity> entityList) {
        List<CalificacionDetailDTO> list = new ArrayList<>();
        for (CalificacionEntity entity : entityList) {
            list.add(new CalificacionDetailDTO(entity));
        }
        return list;
    }
}
