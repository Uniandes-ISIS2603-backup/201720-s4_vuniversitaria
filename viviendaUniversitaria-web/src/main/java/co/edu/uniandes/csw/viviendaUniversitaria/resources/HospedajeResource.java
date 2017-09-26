/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.*;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.*;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.*;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ws.duarte
 */
@Path("/hospedajes")
//@Produces("application/json")
//@Consumes("application/json")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class HospedajeResource {
    
    
    @Inject
    private HospedajeLogic hospedajeLogic;
    
    @POST
    public HospedajeDetaillDTO post(HospedajeDetaillDTO entidad) throws WebApplicationException, BusinessLogicException
    {
        return new HospedajeDetaillDTO(hospedajeLogic.create(entidad.toEntity()));
    }
    
    @GET
    public List<HospedajeDetaillDTO> getAll() throws WebApplicationException, BusinessLogicException
    {
        return construir(hospedajeLogic.findAll());
    }
    
    @GET
    @Path("{idHospedaje: [0-9][0-9]*}")
    public HospedajeDetaillDTO get(@PathParam("idHospedaje") Long id) throws WebApplicationException, BusinessLogicException
    {
        return new HospedajeDetaillDTO(hospedajeLogic.find(id));
    }
    
    @PUT
    @Path("{idHospedaje: [0-9][0-9]*}")
    public HospedajeDetaillDTO put(@PathParam("idHospedaje") Long id, HospedajeDetaillDTO dto) throws WebApplicationException, BusinessLogicException
    {
        dto.setId(id);
        return new HospedajeDetaillDTO(hospedajeLogic.update(dto.toEntity()));
    }
    
    @DELETE
    @Path("{idHospedaje: [0-9][0-9]*}")
    public void delete(@PathParam("idHospedaje") Long id) throws WebApplicationException, BusinessLogicException
    {
        hospedajeLogic.delete(id);
    }
    
    @Path("{idHospedaje: [0-9][0-9]*}/reglas")
    public Class<ReglaResource> getRegla(@PathParam("idHospedaje") Long idHospedaje ) throws WebApplicationException, BusinessLogicException
    {
        hospedajeLogic.find(idHospedaje);
        return ReglaResource.class;
    }
    
    private List<HospedajeDetaillDTO> construir(List<HospedajeEntity> list)
    {
        List<HospedajeDetaillDTO> ret = new ArrayList<>();
        for(HospedajeEntity r : list) ret.add(new HospedajeDetaillDTO(r));
        return ret;
    }
    
}
