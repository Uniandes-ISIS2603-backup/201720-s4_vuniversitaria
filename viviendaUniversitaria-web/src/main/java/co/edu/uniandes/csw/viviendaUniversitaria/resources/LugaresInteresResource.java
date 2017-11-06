/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.LugaresInteresDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.LugaresInteresDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.UbicacionDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.LugaresInteresLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.UbicacionLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
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
 * @author jc.sanguino10
 */
@Path("lugaresInteres")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class LugaresInteresResource {

    @Inject
    LugaresInteresLogic logic;
    @Inject
    UbicacionLogic logicUbicacion;

    @GET
    public List<LugaresInteresDetailDTO> getList() throws WebApplicationException {
        try {
            List<LugaresInteresEntity> list = logic.findAll();
            List<LugaresInteresDetailDTO> respuesta = new ArrayList<LugaresInteresDetailDTO>();
            for (LugaresInteresEntity lugaresInteresEntity : list) {
                respuesta.add(new LugaresInteresDetailDTO(lugaresInteresEntity));
                System.err.println(lugaresInteresEntity);
            }
            return respuesta;
        } catch (WebApplicationException e) {
            throw e;
        }

    }

    @GET
    @Path("{id: \\d+}")
    public LugaresInteresDetailDTO getLugares(@PathParam("id") long id) throws WebApplicationException, BusinessLogicException {
        try {
            LugaresInteresDetailDTO respuesta = new LugaresInteresDetailDTO(logic.find(id));
            return respuesta;

        } catch (WebApplicationException e) {
            throw e;
        }

    }

    @POST
    @Path("{idUbicacion: \\d+}")
    public LugaresInteresDetailDTO createLugar(@PathParam("idUbicacion") Long idUbicacion, LugaresInteresDetailDTO nuevolugar) throws WebApplicationException, BusinessLogicException {

        UbicacionDTO ubicacion = new UbicacionDTO(logicUbicacion.find(idUbicacion));
        nuevolugar.setUbicacion(ubicacion);
        try {
            return new LugaresInteresDetailDTO(logic.create(nuevolugar.toEntity()));
        } catch (WebApplicationException ex) {
            throw ex;
        }
    }

    @PUT
    @Path("{id: \\d+}")
    public LugaresInteresDTO updateLugar(@PathParam("id") Long id, LugaresInteresDTO lugarAtualizado) throws WebApplicationException {
        try {
            lugarAtualizado.setId(id);
            return new LugaresInteresDTO(logic.update(lugarAtualizado.toEntity(), id));
        } catch (WebApplicationException e) {
            throw e;
        }

    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteLugar(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException {
        try {
            logic.delete(id);
        } catch (WebApplicationException e) {
            throw e;

        }
    }
}
