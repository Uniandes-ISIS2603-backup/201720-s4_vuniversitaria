/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ArrendadorDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ArrendadorLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ArrendadorPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
@Path("viviendaUniversitaria")
@Produces("application/json")
@Stateless
public class ArrendadorResource {
    @Inject
    ArrendadorLogic arrendadorLogic; // Variable para acceder a la lógica de la aplicación. 

    private static final Logger LOGGER = Logger.getLogger(ArrendadorPersistence.class.getName());
    
    @POST
    public ArrendadorDTO createArrendador(ArrendadorDTO arrendador) throws BusinessLogicException {
        ArrendadorEntity arrendadorEntity = arrendador.toEntity();
        ArrendadorEntity nuevoArrendador = arrendadorLogic.createArrendador(arrendadorEntity);
        return new ArrendadorDTO(nuevoArrendador);
    }

    @GET
    public List<ArrendadorDTO> getArrendadores() throws BusinessLogicException {
        return listEntity2DetailDTO(arrendadorLogic.getArrendadores());
    }

    @GET
    @Path("{id: \\d+}")
    public ArrendadorDTO getArrendador(@PathParam("id") Long id) throws BusinessLogicException {
        ArrendadorEntity entity = arrendadorLogic.getArrendador(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /arrendador/" + id + " no existe.", 404);
        }
        return new ArrendadorDTO(arrendadorLogic.getArrendador(id));
    }

    
    @PUT
    @Path("{id: \\d+}")
    public ArrendadorDTO updateArrendador(@PathParam("id") Long id, ArrendadorDTO arrendador) throws BusinessLogicException {
        arrendador.setId(id);
        ArrendadorEntity entity = arrendadorLogic.getArrendador(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /arrendador/" + id + " no existe.", 404);
        }
        return new ArrendadorDTO(arrendadorLogic.updateArrendador(id, arrendador.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteArrendador(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un arrendador con id {0}", id);
        ArrendadorEntity entity = arrendadorLogic.getArrendador(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /arrendador/" + id + " no existe.", 404);
        }
        arrendadorLogic.deleteArrendador(id);
    }
    private List<ArrendadorDTO> listEntity2DetailDTO(List<ArrendadorEntity> entityList) {
        List<ArrendadorDTO> list = new ArrayList<>();
        for (ArrendadorEntity entity : entityList) {
            list.add(new ArrendadorDTO(entity));
        }
        return list;
    }
}
