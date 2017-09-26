/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.FacturaDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.FacturaLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author je.bejarano10
 */
@Path ("facturas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class FacturaResource {
     @Inject     
     private FacturaLogic facturaLogic;
     
     private List<FacturaDetailDTO> facturaListEntity2DetailDTO(List<FacturaEntity> entityList){
        List<FacturaDetailDTO> list = new ArrayList();
        for(FacturaEntity entity : entityList){
            list.add(new FacturaDetailDTO(entity));
        }
        return list;
     }
       
    @GET
    public List <FacturaDetailDTO> getFacturas(){
        System.out.println("----------------------------------------------HOLA-------");
    return facturaListEntity2DetailDTO(facturaLogic.getFacturas());
    }

    @GET 
    @Path("{id: \\d+}")
    public FacturaDetailDTO getFactura(@PathParam("id") Long id) throws BusinessLogicException {
       FacturaEntity  entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso " + id + " no existe.", 404);
        }
        return new FacturaDetailDTO(entity);
    }
    @POST
    public FacturaDetailDTO createFactura(FacturaDetailDTO factura) throws BusinessLogicException {
        return new FacturaDetailDTO(facturaLogic.createFactura(factura.toEntity()));
    }
    @PUT
    @Path("{id: \\d+}")
    public FacturaDetailDTO updateFactura (@PathParam("id") Long id, FacturaDetailDTO factura) throws BusinessLogicException {
        factura.setId(id);
        FacturaEntity entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + id + " no existe.", 404);
        }
        return new FacturaDetailDTO(facturaLogic.updateFactura(id, factura.toEntity()));
    }
    
    @DELETE
    @Path("(id: \\d+}")
    public void deleteFactura(@PathParam("id") Long id) throws BusinessLogicException {
        FacturaEntity entity = facturaLogic.getFactura(id);
        System.out.println("--------------------------TODO BIEN--------------------------");
        if (entity == null) {
            throw new WebApplicationException("El recurso /Facturas/" + id + " no existe.", 404);
        }
        facturaLogic.deleteFactura(id);
    }
    
}
