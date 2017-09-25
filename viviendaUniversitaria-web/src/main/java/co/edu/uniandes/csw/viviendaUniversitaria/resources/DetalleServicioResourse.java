/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.DetalleServicioDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.DetalleServicioLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;
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
@Path("detalleServicio")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class DetalleServicioResourse {
    
    @Inject
    private DetalleServicioLogic logic;
    
    @POST
    public DetalleServicioDTO post(DetalleServicioDTO entidad) throws WebApplicationException, BusinessLogicException
    {
        return new DetalleServicioDTO(logic.create(entidad.toEntity()));
    }
    
    @GET
    public List<DetalleServicioDTO> getAll() throws WebApplicationException, BusinessLogicException
    {
        return construir(logic.findAll());
    }
    
    @GET
    @Path("{id: [0-9][0-9]*}")
    public DetalleServicioDTO get(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        return new DetalleServicioDTO(logic.find(id));
    }
    
    @PUT
    @Path("{id: [0-9][0-9]*}")
    public DetalleServicioDTO put(@PathParam("id") Long id, DetalleServicioDTO dto) throws WebApplicationException, BusinessLogicException
    {
        dto.setId(id);
        return new DetalleServicioDTO(logic.update(dto.toEntity()));
    }
    
    @DELETE
    @Path("{id: [0-9][0-9]*}")
    public void delete(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        logic.delete(id);
    }
    
    private List<DetalleServicioDTO> construir(List<DetalleServicioEntity> list)
    {
        List<DetalleServicioDTO> ret = new ArrayList<>();
        for(DetalleServicioEntity r : list) ret.add(new DetalleServicioDTO(r));
        return ret;
    }
    
}
