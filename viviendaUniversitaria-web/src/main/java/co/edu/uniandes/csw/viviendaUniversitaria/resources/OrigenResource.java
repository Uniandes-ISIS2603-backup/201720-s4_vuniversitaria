/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.OrigenDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.OrigenDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.OrigenLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.OrigenPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("origenes")
@Produces("application/json")
@Consumes("application/json")
public class OrigenResource {
@Inject
    OrigenLogic OrigenLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(OrigenPersistence.class.getName());

    @POST
    public OrigenDetailDTO createOrigen(OrigenDetailDTO Origen) throws BusinessLogicException {
        OrigenEntity OrigenEntity = Origen.toEntity();
        OrigenEntity nuevoOrigen = OrigenLogic.createOrigen(OrigenEntity);
        return new OrigenDetailDTO(nuevoOrigen);
    }

    @GET
    public List<OrigenDetailDTO> getOrigens() throws BusinessLogicException {
        return listEntity2DetailDTO(OrigenLogic.getOrigenes());
    }
    
    @GET
    @Path("{id: \\d+}")
    public OrigenDetailDTO getOrigen(@PathParam("id") Long id) throws BusinessLogicException {
        OrigenEntity entity = OrigenLogic.getOrigen(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Origens/" + id + " no existe.", 404);
        }
        return new OrigenDetailDTO(OrigenLogic.getOrigen(id));
    }

    @PUT
    @Path("{id: \\d+}")
    public OrigenDetailDTO updateOrigen(@PathParam("id") Long id, OrigenDetailDTO Origen) throws BusinessLogicException {
        Origen.setId(id);
        OrigenEntity entity = OrigenLogic.getOrigen(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Origens/" + id + " no existe.", 404);
        }
        return new OrigenDetailDTO(OrigenLogic.updateOrigen(id, Origen.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteOrigen(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una Origen con id {0}", id);
        OrigenEntity entity = OrigenLogic.getOrigen(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Origens/" + id + " no existe.", 404);
        }
        OrigenLogic.deleteOrigen(id);

    }

    @Path("{OrigensId: \\d+}/estudiantes")
    public Class<OrigenEstudianteResource> getOrigenEstudiantesResource(@PathParam("OrigensId") Long OrigensId) throws BusinessLogicException {
        OrigenEntity entity = OrigenLogic.getOrigen(OrigensId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Origens/" + OrigensId + " no existe.", 404);
        }
        return OrigenEstudianteResource.class;
    }

    private List<OrigenDetailDTO> listEntity2DetailDTO(List<OrigenEntity> entityList) {
        List<OrigenDetailDTO> list = new ArrayList<>();
        for (OrigenEntity entity : entityList) {
            list.add(new OrigenDetailDTO(entity));
        }
        return list;
    }
}
