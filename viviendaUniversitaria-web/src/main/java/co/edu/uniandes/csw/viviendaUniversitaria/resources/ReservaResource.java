/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ReservaDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ReservaDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ReservaLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReservaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author je.bejarano10
 */
@Path ("reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ReservaResource {
    @Inject 
    private ReservaLogic reservaLogic;
    
    /*private List<DetalleReservaDetailDTO> detalleReservaListEntity2DTO(List<DetalleReservaEntity> entityList){
        *  List<DetalleReservaDetailDTO> list = new ArrayList();
        * for(DetalleReservaEntity entity : entityList){
        *    list.add(new DetalleReservaDetailDTO(entity));
        *}
        *return list;
    *}
**/
    private List<ReservaDetailDTO> reservaListEntity2DetailDTO(List<ReservaEntity> entityList){
        List<ReservaDetailDTO> list = new ArrayList();
        for(ReservaEntity entity : entityList){
            list.add(new ReservaDetailDTO(entity));
        }
        return list;
    }
       
    @GET
    public List <ReservaDetailDTO> getReservas(){
    return reservaListEntity2DetailDTO(reservaLogic.getReservas());
    }
    
    @GET 
    @Path("{id: \\d+}")
    public ReservaDetailDTO getReserva(@PathParam("id") Long id) throws BusinessLogicException {
       ReservaEntity  entity = reservaLogic.getReserva(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + id + " no existe.", 404);
        }
        return new ReservaDetailDTO(entity);
    }
    @POST
    public ReservaDetailDTO createReserva(ReservaDetailDTO reserva) throws BusinessLogicException {
        return new ReservaDetailDTO(reservaLogic.createReserva(reserva.toEntity()));
    }
    @PUT
    @Path("{id: \\d+}")
    public ReservaDetailDTO updateBook(@PathParam("id") Long id, ReservaDetailDTO reserva) throws BusinessLogicException {
        reserva.setId(id);
        ReservaEntity entity = reservaLogic.getReserva(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + id + " no existe.", 404);
        }
        return new ReservaDetailDTO(reservaLogic.updateReserva(id, reserva.toEntity()));
    }
    
}
