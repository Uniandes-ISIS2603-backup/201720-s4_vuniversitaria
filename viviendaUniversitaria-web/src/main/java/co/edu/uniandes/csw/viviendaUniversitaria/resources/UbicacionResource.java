/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.UbicacionDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.UbicacionDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.UbicacionLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
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
 * @author c.santacruza
 */
@Path("ubicaciones")
@Produces("application/json")
@Consumes("application/json")
//@RequestScoped ----- Indica que va a iniciar una transacción antes de cada metodo de la clase
@Stateless
public class UbicacionResource {
    @Inject 
    UbicacionLogic logic;
    
    @GET
    public List<UbicacionDetailDTO> getUbicaciones(){
        return listEntity2DetailDTO(logic.getUbicaciones());
    }
    
    private List<UbicacionDetailDTO> listEntity2DetailDTO(List<UbicacionEntity> entityList) {
        List<UbicacionDetailDTO> list = new ArrayList<>();
        for (UbicacionEntity entity : entityList) {
            list.add(new UbicacionDetailDTO(entity));
        }
        return list;
    }
    
    @GET
    @Path("{id: \\+d}")
    public UbicacionDetailDTO getUbicacion(@PathParam("id") Long id) throws BusinessLogicException{
        if(logic.getUbicacion(id)!= null){
            UbicacionEntity entity = logic.getUbicacion(id);
            return new UbicacionDetailDTO (entity);
        }else{
            throw new WebApplicationException("La ubicacion con ese id no existe");
        }
    }
    @POST
    public UbicacionDetailDTO createUbicacion(UbicacionDetailDTO ubi) throws BusinessLogicException{
        UbicacionEntity entity = ubi.toEntity();
        UbicacionEntity newEntity = logic.createUbicacion(entity);
        return new UbicacionDetailDTO(newEntity);
    }
    @PUT
    @Path("id: \\+d")
    public UbicacionDetailDTO updateUbicacion(@PathParam("id") Long id,UbicacionDetailDTO ubi) throws BusinessLogicException{
        if(logic.getUbicacion(id)!= null && id.equals(ubi.getId())){
            UbicacionEntity entity = logic.updateUbicacion(id,ubi.toEntity());
            return new UbicacionDetailDTO (entity);
        }else{
            throw new WebApplicationException("La ubicacion con ese id no existe");
        }
    }
    @DELETE
    @Path("id: \\+d")
    public void deleteUbicacion(@PathParam("id")Long id) throws BusinessLogicException{
        if(logic.getUbicacion(id)!= null){
            logic.deleteUbicacion(id);
        }else{
            throw new WebApplicationException("La ubicacion con ese id no existe");
        }
        
    }
    
    
    
}
