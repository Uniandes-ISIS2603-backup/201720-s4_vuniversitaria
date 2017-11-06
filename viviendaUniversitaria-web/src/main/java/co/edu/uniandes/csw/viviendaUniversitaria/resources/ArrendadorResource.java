/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ArrendadorDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ArrendadorLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ArrendadorPersistence;
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
@Path("arrendadores")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ArrendadorResource {
    @Inject
    ArrendadorLogic arrendadorLogic; // Variable para acceder a la lógica de la aplicación. 

    private static final Logger LOGGER = Logger.getLogger(ArrendadorPersistence.class.getName());
    
    @POST
    public ArrendadorDetailDTO createArrendador(ArrendadorDetailDTO arrendador) throws BusinessLogicException {
        ArrendadorEntity arrendadorEntity = arrendador.toEntity();
        ArrendadorEntity nuevoArrendador = arrendadorLogic.createArrendador(arrendadorEntity);
        return new ArrendadorDetailDTO(nuevoArrendador);
    }

    @GET
    public List<ArrendadorDetailDTO> getArrendadores() throws BusinessLogicException {
         if(listEntity2DetailDTO(arrendadorLogic.getArrendadores()).isEmpty())
            throw new WebApplicationException("La lista de arrendadores esta vacía", 404);
        return listEntity2DetailDTO(arrendadorLogic.getArrendadores());
    }

    @GET
    @Path("{id: [0-9][0-9]*}")
    public ArrendadorDetailDTO getArrendador(@PathParam("id") Long id) throws BusinessLogicException {
        ArrendadorEntity entity = arrendadorLogic.getArrendador(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /arrendador/" + id + " no existe.", 404);
        }
        return new ArrendadorDetailDTO(arrendadorLogic.getArrendador(id));
    }
    
    @PUT
    @Path("{id: [0-9][0-9]*}")
    public ArrendadorDetailDTO updateArrendador(@PathParam("id") Long id, ArrendadorDetailDTO arrendador) throws BusinessLogicException {
        ArrendadorEntity entity = arrendador.toEntity();
        entity.setId(id);
        ArrendadorEntity oldEntity = arrendadorLogic.getArrendador(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El arrendador no existe", 404);
        }
        
        entity.setHospedajes(oldEntity.getHospedajes());
        return new ArrendadorDetailDTO(arrendadorLogic.updateArrendador(id, entity));
    }

    @DELETE
    @Path("{id: [0-9][0-9]*}")
    public void deleteArrendador(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un arrendador con id {0}", id);
        ArrendadorEntity entity = arrendadorLogic.getArrendador(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /arrendador/" + id + " no existe.", 404);
        }
        arrendadorLogic.deleteArrendador(id);
    }
    private List<ArrendadorDetailDTO> listEntity2DetailDTO(List<ArrendadorEntity> entityList) {
        List<ArrendadorDetailDTO> list = new ArrayList<>();
        for (ArrendadorEntity entity : entityList) {
            list.add(new ArrendadorDetailDTO(entity));
        }
        return list;
    }
    
    @Path("{id: [0-9][0-9]*}/hospedajes")
    public Class<ArrendadorHospedajeResource> getHospedajesArrendador(@PathParam("id") Long id) throws BusinessLogicException {
        ArrendadorEntity entity = arrendadorLogic.getArrendador(id);
        if (entity == null) {
            throw new WebApplicationException("El arrendador no existe", 404);
        }
        return ArrendadorHospedajeResource.class;
    }
}
