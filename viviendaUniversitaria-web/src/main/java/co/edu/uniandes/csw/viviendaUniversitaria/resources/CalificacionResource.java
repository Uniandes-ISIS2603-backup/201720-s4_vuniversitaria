/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.HospedajeDetaillDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.CalificacionLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
@Path("calificaciones")
@Consumes("application/json")
@Produces("application/json")
@RequestScoped
public class CalificacionResource {    
    @Inject
    private CalificacionLogic calificacionLogic; // Variable para acceder a la lógica de la aplicación.  
 
    @GET
    public List<CalificacionDetailDTO> getCalificaciones(){
        List<CalificacionEntity> calificaciones= calificacionLogic.getCalificaciones();
        if(calificaciones.isEmpty()){
            throw new WebApplicationException("No existen calificaciones.", 404);
        }
        return listEntity2DetailDTO(calificaciones);
    }
        
    @GET
    @Path("{id: \\d+}")
    public CalificacionDetailDTO getCalificacion(@PathParam("id") Long id) throws BusinessLogicException{
        CalificacionEntity calificacion= calificacionLogic.getCalificacion(id);
        if(calificacion== null)
            throw new WebApplicationException("La calificacion con el identificador dado no existe", 404);
        
        return new CalificacionDetailDTO(calificacion);        
    }
        
    @GET
    @Path("{id: \\d+}/hospedaje")
    public HospedajeDetaillDTO getHospedaje(@PathParam("id") Long id) throws BusinessLogicException{
        CalificacionEntity calificacion = calificacionLogic.getCalificacion(id);
        if(calificacion == null)
            throw new WebApplicationException("La calificacion con el identificador dado no existe", 404);
        
        return new HospedajeDetaillDTO(calificacion.getHospedaje());
    }
    
    @GET
    @Path("{id: \\d+}/estudiante")
    public EstudianteDetailDTO getEstudiante(@PathParam("id") Long id) throws BusinessLogicException{
        CalificacionEntity calificacion= calificacionLogic.getCalificacion(id);
        if(calificacion==null)
            throw new WebApplicationException("La calificacion con el identificador dado no existe", 404);
        
        return new EstudianteDetailDTO(calificacion.getEstudiante());
    }
    
    @POST
    @Path("{idEstudiante: \\d+}/{idHospedaje: \\d+}")
    public CalificacionDetailDTO createCalificacion(@PathParam("idEstudiante")Long idEstudiante,@PathParam("idHospedaje") Long idHospedaje, CalificacionDetailDTO calificacionDetail) throws BusinessLogicException {
        CalificacionEntity calificacion= calificacionLogic.createCalificacion(calificacionDetail.toEntity());
        calificacionLogic.asociarCalificacionAEstudianteHospedaje(idHospedaje, idEstudiante, calificacion);
        return calificacionDetail;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDetailDTO updateCalificacion (@PathParam("id") Long id, CalificacionDetailDTO calificacionDetail) throws BusinessLogicException {
        calificacionDetail.setId(id);
        CalificacionEntity calificacion = calificacionLogic.getCalificacion(id);
        if (calificacion == null) {
            throw new WebApplicationException("El recurso /calificaciones/" + id + " no existe.", 404);
        }
        return new CalificacionDetailDTO(calificacionLogic.updateCalificacion(id, calificacion));
    }
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacion(@PathParam("id") Long id) throws BusinessLogicException {
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificaciones/" + id + " no existe.", 404);
        }
        calificacionLogic.deleteCalificacion(id);
    }
    
    private List<CalificacionDetailDTO> listEntity2DetailDTO(List<CalificacionEntity> entityList) {
        List<CalificacionDetailDTO> list = new ArrayList<>();
        for (CalificacionEntity entity : entityList) {
            list.add(new CalificacionDetailDTO(entity));
        }
        return list;
    }
}
