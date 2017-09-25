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

/**
 *
 * @author ws.duarte
 */
@Path("hospedaje")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class HospedajeResource {
    
    
    @Inject
    private HospedajeLogic logic;
    
    @POST
    public HospedajeDTO post(HospedajeDTO entidad) throws WebApplicationException, BusinessLogicException
    {
        return new HospedajeDTO(logic.create(entidad.toEntity()));
    }
    
    @GET
    public List<HospedajeDTO> getAll() throws WebApplicationException, BusinessLogicException
    {
        return construir(logic.findAll());
    }
    
    @GET
    @Path("{id: [0-9][0-9]*}")
    public HospedajeDTO get(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        return new HospedajeDTO(logic.find(id));
    }
    
    @PUT
    @Path("{id: [0-9][0-9]*}")
    public HospedajeDTO put(@PathParam("id") Long id, HospedajeDTO dto) throws WebApplicationException, BusinessLogicException
    {
        dto.setId(id);
        return new HospedajeDTO(logic.update(dto.toEntity()));
    }
    
    @DELETE
    @Path("{id: [0-9][0-9]*}")
    public void delete(@PathParam("id") Long id) throws WebApplicationException, BusinessLogicException
    {
        logic.delete(id);
    }
    
    private List<HospedajeDTO> construir(List<HospedajeEntity> list)
    {
        List<HospedajeDTO> ret = new ArrayList<>();
        for(HospedajeEntity r : list) ret.add(new HospedajeDTO(r));
        return ret;
    }
    @Path("{idHospedaje: \\d+}/servicios")
    public ServiciosResourse getServicios()
    {
        return new ServiciosResourse();
    }
    @Path("{idHospedaje: \\d+}/lugaresInteres")
    public LugaresInteresResource getLugaresInteres()
    {
        return new LugaresInteresResource();
    }
    
}
