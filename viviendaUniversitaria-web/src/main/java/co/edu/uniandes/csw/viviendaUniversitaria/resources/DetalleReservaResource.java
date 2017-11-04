/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.DetalleReservaDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.DetalleReservaLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleReservaEntity;
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
@Path("detalleReserva")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class DetalleReservaResource {
    
    @Inject
    private DetalleReservaLogic logic;
    
    @POST
    public DetalleReservaDTO post(DetalleReservaDTO entidad) throws WebApplicationException, BusinessLogicException
    {
        return new DetalleReservaDTO(logic.create(entidad.toEntity()));
    }
    
    @GET
    public List<DetalleReservaDTO> getAll() throws WebApplicationException, BusinessLogicException
    {
        return construir(logic.findAll());
    }
    
    @GET
    @Path("{id: [0-9][0-9]*}")
    public DetalleReservaDTO get(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        return new DetalleReservaDTO(logic.find(id));
    }
    
    @PUT
    @Path("{id: [0-9][0-9]*}")
    public DetalleReservaDTO put(@PathParam("id") Long id, DetalleReservaDTO dto) throws WebApplicationException, BusinessLogicException
    {
        dto.setId(id);
        return new DetalleReservaDTO(logic.update(dto.toEntity(),id));
    }
    
    @DELETE
    @Path("{id: [0-9][0-9]*}")
    public void delete(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        logic.delete(id);
    }
    
    private List<DetalleReservaDTO> construir(List<DetalleReservaEntity> list)
    {
        List<DetalleReservaDTO> ret = new ArrayList<>();
        for(DetalleReservaEntity r : list) ret.add(new DetalleReservaDTO(r));
        return ret;
    }
    
}
