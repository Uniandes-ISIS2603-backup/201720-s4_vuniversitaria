/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ReglaDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ReglaLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReglaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ws.duarte
 */
@Path("regla")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ReglaResource 
{
    private static final Logger LOGGER = Logger.getLogger(ReglaResource.class.getName());
    
    @Inject
    private ReglaLogic logic;
    
    @POST
    public ReglaDTO post(ReglaDTO entidad) throws WebApplicationException, BusinessLogicException
    {
        return new ReglaDTO(logic.create(entidad.toEntity()));
    }
    
    @GET
    public List<ReglaDTO> getAll() throws WebApplicationException, BusinessLogicException
    {
        return construir(logic.findAll());
    }
    
    @GET
    @Path("{id: [0-9][0-9]*}")
    public ReglaDTO get(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        return new ReglaDTO(logic.find(id));
    }
    
    @PUT
    @Path("{id: [0-9][0-9]*}")
    public ReglaDTO put(@PathParam("id") Long id, ReglaDTO dto) throws WebApplicationException, BusinessLogicException
    {
        dto.setId(id);
        return new ReglaDTO(logic.update(dto.toEntity()));
    }
    
    @DELETE
    @Path("{id: [0-9][0-9]*}")
    public void delete(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        logic.delete(id);
    }
    
    private List<ReglaDTO> construir(List<ReglaEntity> list)
    {
        List<ReglaDTO> ret = new ArrayList<>();
        for(ReglaEntity r : list) ret.add(new ReglaDTO(r));
        return ret;
    }
    
}
