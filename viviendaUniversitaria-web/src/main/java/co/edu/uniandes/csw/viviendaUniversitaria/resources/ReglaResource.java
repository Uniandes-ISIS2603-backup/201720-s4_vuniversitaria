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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ws.duarte
 */
//@Path("regla")
//@Produces("application/json")
//@Consumes("application/json")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@RequestScoped
public class ReglaResource 
{
   
    
    @Inject
    private ReglaLogic logic;
    
//    @POST
//    public ReglaDTO post(@PathParam("idHospedaje") Long idHospedaje,ReglaDTO entidad) throws WebApplicationException, BusinessLogicException
//    {
//        return new ReglaDTO(logic.create(idHospedaje,entidad.toEntity()));
//    }
//    
//    @GET
//    public List<ReglaDTO> getAll(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException, BusinessLogicException
//    {
//        return construir(logic.findAll(idHospedaje));
//    }
//    
//    @GET
//    @Path("{idRegla: [0-9][0-9]*}")
//    public ReglaDTO get(@PathParam("idHospedaje") Long idHospedaje,@PathParam("idRegla") Long id) throws WebApplicationException, BusinessLogicException
//    {
//        ReglaEntity regla = logic.find(idHospedaje, id);
//        if(regla == null) throw new WebApplicationException("Consulta id: La entidad no existe",405);
//        return new ReglaDTO(regla);
//    }
//    
//    @PUT
//    @Path("{idRegla: [0-9][0-9]*}")
//    public ReglaDTO put(@PathParam("idHospedaje") Long idHospedaje,@PathParam("idRegla") Long idRegla, ReglaDTO dto) throws WebApplicationException, BusinessLogicException
//    {
//        dto.setId(idRegla);
//        ReglaEntity regla = logic.find(idHospedaje, idRegla);
//        if(regla == null) throw new WebApplicationException("Consulta id: La entidad no existe",405);
//        return new ReglaDTO(logic.update(idHospedaje,dto.toEntity()));
//    }
//    
//    @DELETE
//    @Path("{idRegla: [0-9][0-9]*}")
//    public void delete(@PathParam("idHospedaje") Long idHospedaje,@PathParam("idRegla") Long idRegla) throws WebApplicationException, BusinessLogicException
//    {
//        ReglaEntity regla = logic.find(idHospedaje, idRegla);
//        if(regla == null) throw new WebApplicationException("Consulta id: La entidad no existe",405);
//        logic.delete(idHospedaje, idRegla);
//    }
//    
//    private List<ReglaDTO> construir(List<ReglaEntity> list)
//    {
//        List<ReglaDTO> ret = new ArrayList<>();
//        for(ReglaEntity r : list) ret.add(new ReglaDTO(r));
//        return ret;
//    }
//    
}
