/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.HospedajeLugarDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.HospedajeLugarLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
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
 * @author ws.duarte
 */
@Path("hospedajeLugar")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class HospedajeLugarResourse {
    
    
    @Inject
    private HospedajeLugarLogic logic;
    
    @POST
    public HospedajeLugarDTO post(HospedajeLugarDTO entidad) throws WebApplicationException, BusinessLogicException
    {
        return new HospedajeLugarDTO(logic.create(entidad.toEntity()));
    }
    
    @GET
    public List<HospedajeLugarDTO> getAll() throws WebApplicationException, BusinessLogicException
    {
        return construir(logic.findAll());
    }
    
    @GET
    @Path("{id: [0-9][0-9]*}")
    public HospedajeLugarDTO get(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        return new HospedajeLugarDTO(logic.find(id));
    }
    
    @PUT
    @Path("{id: [0-9][0-9]*}")
    public HospedajeLugarDTO put(@PathParam("id") Long id, HospedajeLugarDTO dto) throws WebApplicationException, BusinessLogicException
    {
        dto.setId(id);
        return new HospedajeLugarDTO(logic.update(dto.toEntity(),id));
    }
    
    @DELETE
    @Path("{id: [0-9][0-9]*}")
    public void delete(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        logic.delete(id);
    }
    
    private List<HospedajeLugarDTO> construir(List<HospedajeLugarEntity> list)
    {
        List<HospedajeLugarDTO> ret = new ArrayList<>();
        for(HospedajeLugarEntity r : list) ret.add(new HospedajeLugarDTO(r));
        return ret;
    }
}
