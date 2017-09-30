/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.LugaresInteresDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.LugaresInteresDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.LugaresInteresLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
import javax.ws.rs.WebApplicationException;


/**
 *
 * @author jc.sanguino10
 */
@Path("lugaresInteres")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class LugaresInteresResource {

    @Inject
    LugaresInteresLogic logic;
 

    @GET
    public List<LugaresInteresDetailDTO> getList() throws WebApplicationException {
        try {
            List<LugaresInteresEntity> list = logic.findAll();
            List<LugaresInteresDetailDTO> respuesta = new ArrayList<LugaresInteresDetailDTO>();
            for (LugaresInteresEntity lugaresInteresEntity : list) {
                respuesta.add(new LugaresInteresDetailDTO(lugaresInteresEntity));
            }
            return respuesta;
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }

    }

    @GET
    @Path("{id: \\d+}")
    public LugaresInteresDetailDTO getLugares(@PathParam("id") long id) throws WebApplicationException {
        try {
            LugaresInteresDetailDTO respuesta =new LugaresInteresDetailDTO(logic.findIdLugarInteres(id));
            System.err.println(respuesta.getUbicacion()+"=======================================================================================");
            return respuesta;
            
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }

    }

    @POST
    @Path("{id: \\d+}")
    public LugaresInteresDetailDTO createLugar(LugaresInteresDTO nuevolugar, @PathParam("id") Long id) throws WebApplicationException {

        if (nuevolugar == null) {
            throw new WebApplicationException("el nuevo lugar a crear esta vacio", 404);
        }
        try {
            LugaresInteresEntity entity = nuevolugar.toEntity();
            LugaresInteresEntity nuevoEntity = logic.createLugarInteres(entity, id);            
            LugaresInteresDetailDTO respuesta = new LugaresInteresDetailDTO(nuevoEntity);
                                
            return new LugaresInteresDetailDTO(nuevoEntity);
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }

    }

    @PUT
    @Path("{id: \\d+}")
    public LugaresInteresDTO updateLugar(@PathParam("id") Long id, LugaresInteresDTO lugarAtualizado) throws WebApplicationException {
        try {
            LugaresInteresEntity entity = lugarAtualizado.toEntity();
            LugaresInteresEntity nuevoEntity = logic.updateLugarInteres(entity);
            return new LugaresInteresDTO(nuevoEntity);
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }

    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteLugar(@PathParam("id") Long id) throws WebApplicationException {
        try {
            logic.delete(id);
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);

        }
    }
}
