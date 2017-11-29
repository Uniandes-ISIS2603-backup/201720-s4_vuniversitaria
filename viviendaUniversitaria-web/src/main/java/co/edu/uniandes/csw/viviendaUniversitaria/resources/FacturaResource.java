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

/**
 *
 * @author je.bejarano10
 */
@Path("facturas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class FacturaResource {

    @Inject
    private FacturaLogic facturaLogic;

    @GET
    public List<FacturaDetailDTO> getFacturas() {
        List<FacturaEntity> factura = facturaLogic.getFacturas();
        List<FacturaDetailDTO> respuesta = new ArrayList<>();
        if (factura.isEmpty()) {
            throw new WebApplicationException("No existan facturas", 404);
        }
        for (FacturaEntity facturaEntity : factura) {
            respuesta.add(new FacturaDetailDTO(facturaEntity));
        }
        return respuesta;
    }
    @GET
    @Path("{id: \\d+}")
    public FacturaDetailDTO getFactura(@PathParam("id") Long id) throws BusinessLogicException {
        FacturaEntity entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso " + id + " no existe.", 404);
        }
        return new FacturaDetailDTO(entity);
    }
    @GET
    @Path("/estudiante/{id: \\d+}")
    public List<FacturaDetailDTO> getFacturasIdEstudiante(@PathParam("id") Long idEstudiante) {
        List<FacturaEntity> factura = facturaLogic.getFacturasIdEstudiante(idEstudiante);
        List<FacturaDetailDTO> respuesta = new ArrayList<>();
        if (factura.isEmpty()) {
            throw new WebApplicationException("No existan facturas del estudiante con id "+ idEstudiante, 404);
        }
        for (FacturaEntity facturaEntity : factura) {
            respuesta.add(new FacturaDetailDTO(facturaEntity));
        }
        return respuesta;
    }
    @GET
    @Path("/hospedaje/{id: \\d+}")
    public List<FacturaDetailDTO> getFacturasIdHospedaje(@PathParam("id") Long idHospedaje) {
        List<FacturaEntity> factura = facturaLogic.getFacturasIdHospedaje(idHospedaje);
        List<FacturaDetailDTO> respuesta = new ArrayList<>();
        if (factura.isEmpty()) {
            throw new WebApplicationException("No existan facturas del hospedaje con id "+ idHospedaje, 404);
        }
        for (FacturaEntity facturaEntity : factura) {
            respuesta.add(new FacturaDetailDTO(facturaEntity));
        }
        return respuesta;
    }
    
    @POST
    @Path("{idEstudiante: \\d+}/{idHospedaje: \\d+}")
    public FacturaDetailDTO createFactura(@PathParam("idEstudiante") Long idEstudiante, @PathParam("idHospedaje") Long idHospedaje, FacturaDetailDTO factura) throws BusinessLogicException {
        FacturaEntity facturaEntity = facturaLogic.createFactura(factura.toEntity(),idHospedaje,idEstudiante);
        return new FacturaDetailDTO(facturaEntity);
    }
    @PUT
    @Path("{id: \\d+}")
    public FacturaDetailDTO updateFactura(@PathParam("id") Long id, FacturaDetailDTO factura) throws BusinessLogicException {        
        return new FacturaDetailDTO(facturaLogic.updateFactura(id, factura.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteFactura(@PathParam("id") Long id) throws BusinessLogicException {
        System.out.println("-----ENTRÓ---------------------------------");
        FacturaEntity entity = facturaLogic.getFactura(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Facturas/" + id + " no existe.", 404);
        }
        facturaLogic.deleteFactura(id);
    }
}
