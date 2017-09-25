/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.LugaresInteresDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.LugaresInteresLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
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
public class LugaresInteresResource {
    
    @Inject
    LugaresInteresLogic logic;
    
    @GET
    @Path("{id: \\d+}")
    public LugaresInteresDTO getServicio(@PathParam("idHospedaje") long idHospedaje, @PathParam("id") long id) throws BusinessLogicException {
        return new LugaresInteresDTO(logic.findIdLugarInteres(id));
    }

    @POST
    public LugaresInteresDTO createServicio(@PathParam("idHospedaje") long idHospedaje, LugaresInteresDTO nuevolugar) throws BusinessLogicException {
        LugaresInteresEntity entity = nuevolugar.toEntity();
        LugaresInteresEntity nuevoEntity = logic.createLugarInteres(entity);
        return new LugaresInteresDTO(nuevoEntity);
    }

    @PUT
    @Path("{id: \\d+}")
    public LugaresInteresDTO updateServicio(@PathParam("id") Long id, LugaresInteresDTO lugarAtualizado) throws BusinessLogicException {
        LugaresInteresEntity entity = lugarAtualizado.toEntity();
        LugaresInteresEntity nuevoEntity = logic.updateLugarInteres(entity);
        return new LugaresInteresDTO(nuevoEntity);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteServicio(@PathParam("id") Long id) throws BusinessLogicException {
        logic.delete(id);
    }
}
