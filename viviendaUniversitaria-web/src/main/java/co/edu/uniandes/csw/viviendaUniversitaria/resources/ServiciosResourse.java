/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ServiciosDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ServiciosLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jc.sanguino10
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class ServiciosResourse {

    @Inject
    ServiciosLogic logic;

    @GET
    @Path("{id: \\d+}")
    public ServiciosDetailDTO getServicio(@PathParam("idHospedaje") long idHospedaje, @PathParam("id") long id) throws BusinessLogicException {
        return new ServiciosDetailDTO(logic.findServicio(id));
    }

    @POST
    public ServiciosDetailDTO createServicio(@PathParam("idHospedaje") long idHospedaje, ServiciosDetailDTO nuevoServicio) throws BusinessLogicException {
        ServiciosEntity entity = nuevoServicio.toEntity();
        ServiciosEntity nuevoEntity = logic.createServicio(entity);
        return new ServiciosDetailDTO(nuevoEntity);
    }

    @PUT
    @Path("{id: \\d+}")
    public ServiciosDetailDTO updateServicio(@PathParam("id") Long id, ServiciosDetailDTO servicioAtualizado) throws BusinessLogicException {
        ServiciosEntity entity = servicioAtualizado.toEntity();
        ServiciosEntity nuevoEntity = logic.updateServicio(entity);
        return new ServiciosDetailDTO(nuevoEntity);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteServicio(@PathParam("id") Long id) throws BusinessLogicException {
        logic.delete(id);
    }

}
