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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kk.penaranda
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalificacionResource {    
    @Inject
    private CalificacionLogic calificacionLogic; // Variable para acceder a la lógica de la aplicación.  
 
               
    @POST
    public CalificacionDetailDTO createCalificacion(@PathParam("idHospedaje") Long idHospedaje, CalificacionDTO calificacionDetail) throws BusinessLogicException {
        return new CalificacionDetailDTO(calificacionLogic.create(idHospedaje, calificacionDetail.toEntity()));
    }
    
    private List<CalificacionDetailDTO> getListaCalificacionesHospedaje(List<CalificacionEntity> entityList){
        List<CalificacionDetailDTO> lista = new ArrayList<>();
        for (CalificacionEntity entity : entityList) {
            lista.add(new CalificacionDetailDTO(entity));
        }
        return lista;
    }   
    
    
    @GET
    public List<CalificacionDetailDTO> getCalificacionesHospedaje(@PathParam("idHospedaje") Long idHospedaje){
        try {
            return getListaCalificacionesHospedaje(calificacionLogic.getCalificacionesHospedaje(idHospedaje));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(CalificacionResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    @GET
    @Path("{id: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("idHospedaje") Long idHospedaje, @PathParam("id") Long id) {
        try {
            CalificacionEntity calificacion= calificacionLogic.getCalificacionHospedaje(idHospedaje, id);
            if(calificacion== null)
                throw new BusinessLogicException("No existe la calificacion");
            return new CalificacionDTO(calificacion); 
            
        } catch (BusinessLogicException ex) {
            Logger.getLogger(CalificacionResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacion(@PathParam("idHospedaje") Long idHospedaje, @PathParam("id") Long id) throws BusinessLogicException {
        CalificacionEntity entity = calificacionLogic.getCalificacionHospedaje(idHospedaje, id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /hospedajes/" + idHospedaje + "/calificaciones/" + id + " no existe.", 404);
        }
        calificacionLogic.remove(idHospedaje, id);
    }    
}