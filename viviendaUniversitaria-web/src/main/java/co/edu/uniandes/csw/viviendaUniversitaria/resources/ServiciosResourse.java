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
@Path("servicio")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ServiciosResourse {

    @Inject
    ServiciosLogic logic;

    @GET
    public List<ServiciosDetailDTO> getList() throws WebApplicationException{

        try {
           List<ServiciosEntity> list = logic.findAll();
        if (list.isEmpty()) {
            throw new WebApplicationException("la lista de servicios se encuentra vacia", 404);
        }
        List<ServiciosDetailDTO> respuesta = new ArrayList<ServiciosDetailDTO>();
        for (ServiciosEntity lugaresInteresEntity : list) {
            respuesta.add(new ServiciosDetailDTO(lugaresInteresEntity));
        }
        return respuesta; 
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
        
    }

    @GET
    @Path("{id: \\d+}")
    public ServiciosDetailDTO getServicio(@PathParam("idHospedaje") long idHospedaje, @PathParam("id") long id) throws WebApplicationException {
        try {
            if (logic.findServicio(id) == null) {
            throw new WebApplicationException("no existe algun servicios con el id: " + id, 404);
        }
        return new ServiciosDetailDTO(logic.findServicio(id));
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
        
    }

    @POST
    public ServiciosDetailDTO createServicio(@PathParam("idHospedaje") long idHospedaje, ServiciosDetailDTO nuevoServicio) throws WebApplicationException {
        if(nuevoServicio ==null)
        {
            throw new WebApplicationException("el nuevo servicio a crear esta vacio", 404);
        }
        try {
             ServiciosEntity entity = nuevoServicio.toEntity();
        ServiciosEntity nuevoEntity = logic.createServicio(entity);
        return new ServiciosDetailDTO(nuevoEntity);
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
       
    }

    @PUT
    @Path("{id: \\d+}")
    public ServiciosDetailDTO updateServicio(@PathParam("id") Long id, ServiciosDetailDTO servicioAtualizado) throws WebApplicationException {
        try {
            ServiciosEntity entity = logic.findServicio(id);
        if (entity == null) {
            throw new WebApplicationException("El servicios con id:" + id + " no existe.", 404);
        } else {
            ServiciosEntity entity2 = servicioAtualizado.toEntity();
            ServiciosEntity nuevoEntity = logic.updateServicio(entity2);
            return new ServiciosDetailDTO(nuevoEntity);
        }
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
        
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteServicio(@PathParam("id") Long id) throws WebApplicationException {
        try {
            ServiciosEntity entity = logic.findServicio(id);
        logic.delete(id);
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
        
    }

}
