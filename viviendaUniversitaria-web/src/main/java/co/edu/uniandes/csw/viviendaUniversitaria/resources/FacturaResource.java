/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.FacturaDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.HospedajeDetaillDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.FacturaLogic;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
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
     List<FacturaEntity> factura=facturaLogic.getFacturas();
     if (factura == null) {
            throw new WebApplicationException("No existan facturas", 404);
        }
    return facturaListEntity2DetailDTO(factura);
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
    
    @GET
    @Path("{id: \\d+}/hospedaje")
    public HospedajeDetaillDTO getHospedaje( @PathParam("id") Long id) throws BusinessLogicException {
    FacturaEntity  entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso " + id + " no existe.", 404);
        }
        return new HospedajeDetaillDTO(entity.getHospedaje());
    }
    @GET
    @Path("{id: \\d+}/estudiante")
    public EstudianteDetailDTO getEstudiante( @PathParam("id") Long id) throws BusinessLogicException {
    FacturaEntity  entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso " + id + " no existe.", 404);
        }
        return new EstudianteDetailDTO(entity.getEstudiante());
    }
    @POST
    @Path("{idEstudiante: \\d+}/{idHospedaje: \\d+}")
    public FacturaDetailDTO createFactura(@PathParam("idEstudiante")Long idEstudiante,@PathParam("idHospedaje") Long idHospedaje, FacturaDetailDTO factura) throws BusinessLogicException {
        FacturaEntity facturaEntity=facturaLogic.createFactura(factura.toEntity());
        facturaLogic.asociateFacturaConHospedajeYEstudiante(idHospedaje, idEstudiante, facturaEntity);
        return factura;
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
    @Path("{idF: \\d+}")
    public void deleteFactura(@PathParam("idF") Long id) throws BusinessLogicException {
        System.out.println("-----ENTRÓ---------------------------------");
        FacturaEntity entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Facturas/" + id + " no existe.", 404);
        }
        facturaLogic.deleteFactura(id);
    }
    
    @Path("{id: \\d+}/detallereserva")
    public Class<DetalleReservaResource> getDetalleReservaResource(@PathParam("id") Long id) {
        FacturaEntity entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + id + "/reviews no existe.", 404);
        }
        return DetalleReservaResource.class;
    }
    @Path("{id: \\d+}/detalleServicio")
    public Class<DetalleServicioResourse> getDetalleServicioResource(@PathParam("id") Long id) {
        FacturaEntity entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso no existe.", 404);
        }
        return DetalleServicioResourse.class;
    }
}