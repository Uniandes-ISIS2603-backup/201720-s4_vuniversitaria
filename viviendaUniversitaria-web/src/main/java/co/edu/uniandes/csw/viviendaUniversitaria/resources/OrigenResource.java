/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.OrigenDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.OrigenLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
 * @author a.eslava
 */
@Produces("application/json")
@Consumes("application/json")
public class OrigenResource {

    @Inject
    OrigenLogic origenLogic;

    @POST
    public OrigenDTO createOrigen(@PathParam("idOrigen") Long id, OrigenDTO review) throws BusinessLogicException {
        return new OrigenDTO(origenLogic.createOrigen(id, review.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteOrigen(@PathParam("cedula") Long estuCed, @PathParam("id") Long id) throws BusinessLogicException {
        OrigenEntity entity = origenLogic.getOrigenEstudiante(estuCed);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + id + "/origen/" + id + " no existe.", 404);
        }
        origenLogic.deleteOrigen(id);
    }

    @GET
    @Path("{id: \\d+}")
    public OrigenDTO getOrigen(@PathParam("cedula") Long cedula, @PathParam("id") Long id) throws BusinessLogicException {
        OrigenEntity entity = origenLogic.getOrigenEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + "/origen/" + id + " no existe.", 404);
        }
        return new OrigenDTO(entity);
    }
    
      @PUT
    @Path("{id: \\d+}")
    public OrigenDTO updateReview(@PathParam("cedula") Long cedula, @PathParam("id") Long id, OrigenDTO origendto) throws BusinessLogicException {
        origendto.setId(id);
        OrigenEntity entity = origenLogic.getOrigenEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + "/origen/" + id + " no existe.", 404);
        }
        return new OrigenDTO(origenLogic.updateOrigen(cedula, origendto.toEntity()));

    }
}
