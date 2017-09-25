/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.CalificacionDTO;
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
@Path("calificacion")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionResource {
    @Inject
    CalificacionLogic calificacionLogic; // Variable para acceder a la lógica de la aplicación. 

    private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());
    
    @POST
    public CalificacionDTO createCalificacion(CalificacionDTO calificacion) throws BusinessLogicException {
        CalificacionEntity calificacionEntity = calificacion.toEntity();
        CalificacionEntity nuevo= calificacionLogic.createCalificacion(calificacionEntity);
        return new CalificacionDTO(nuevo);
    }

    @GET
    public List<CalificacionDTO> getCalificaciones() throws BusinessLogicException {
        return listEntity2DetailDTO(calificacionLogic.getCalificacion());
    }

    @GET
    @Path("{id: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("id") Long id) throws BusinessLogicException {
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/" + id + " no existe.", 404);
        }
        return new CalificacionDTO(calificacionLogic.getCalificacion(id));
    }

    
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDTO updateCalificacion(@PathParam("id") Long id, CalificacionDTO calificacion) throws BusinessLogicException {
        calificacion.setId(id);
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/" + id + " no existe.", 404);
        }
        return new CalificacionDTO(calificacionLogic.updateCalificacion(id, calificacion.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacion(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una calificacion con id {0}", id);
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/" + id + " no existe.", 404);
        }
        calificacionLogic.deleteCalificacion(id);
    }
    private List<CalificacionDTO> listEntity2DetailDTO(List<CalificacionEntity> entityList) {
        List<CalificacionDTO> list = new ArrayList<>();
        for (CalificacionEntity entity : entityList) {
            list.add(new CalificacionDTO(entity));
        }
        return list;
    }
}
