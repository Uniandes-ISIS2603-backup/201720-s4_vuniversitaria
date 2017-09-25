/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.UniversidadDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.UniversidadLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
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
 * @author c.santacruza
 */
@Path("universidades")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class UniversidadResource {
    
    @Inject
    UniversidadLogic logic;
    

    @GET
    public List<UniversidadDetailDTO> getUniversidades() throws BusinessLogicException{
        return listEntity2DetailDTO(logic.getUniversidades());
    }
    
    private List<UniversidadDetailDTO> listEntity2DetailDTO(List<UniversidadEntity> entityList) {
        List<UniversidadDetailDTO> list = new ArrayList<>();
        for(UniversidadEntity entity : entityList) {
            list.add(new UniversidadDetailDTO(entity));
        }
        return list;
    }
    
    @GET
    @Path("{id: \\+d}")
    public UniversidadDetailDTO getUniversidad(@PathParam("id") Long id) throws BusinessLogicException{
        if(logic.getUniversidad(id)!= null){
            UniversidadEntity entity = logic.getUniversidad(id);
            return new UniversidadDetailDTO (entity);
        }else{
            throw new WebApplicationException("La universidad con ese id no existe");
        }
    }
    @POST
    public UniversidadDetailDTO createUniversidad(UniversidadDetailDTO ubi) throws BusinessLogicException{
        UniversidadEntity entity = ubi.toEntity();
        UniversidadEntity newEntity = logic.createUniversidad(entity);
        return new UniversidadDetailDTO(newEntity);
    }
    @PUT
    @Path("id: \\+d")
    public UniversidadDetailDTO updateUniversidad(@PathParam("id") Long id,UniversidadDetailDTO ubi) throws BusinessLogicException{
        if(logic.getUniversidad(id)!= null && id.equals(ubi.getId())){
            UniversidadEntity entity = logic.updateUniversidad(id,ubi.toEntity());
            return new UniversidadDetailDTO (entity);
        }else{
            throw new WebApplicationException("La universidad con ese id no existe");
        }
    }
    @DELETE
    @Path("id: \\+d")
    public void deleteUniversidad(@PathParam("id")Long id) throws BusinessLogicException{
        if(logic.getUniversidad(id)!= null){
            logic.deleteUniversidad(id);
        }else{
            throw new WebApplicationException("La universidad con ese id no existe");
        }    
    } 
}
