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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ws.duarte
 */
@Path("/hospedajes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class HospedajeResource {
    
    
    @Inject
    private HospedajeLogic hospedajeLogic;
    
    @POST
    public HospedajeDetaillDTO post(HospedajeDetaillDTO entidad) throws WebApplicationException, BusinessLogicException
    {
        return new HospedajeDetaillDTO(hospedajeLogic.create(entidad.toEntity()));
    }
    
    @GET
    public List<HospedajeDetaillDTO> getAll() throws WebApplicationException, BusinessLogicException
    {
        return construir(hospedajeLogic.findAll());
    }
    
    @GET
    @Path("{idHospedaje: [0-9][0-9]*}")
    public HospedajeDetaillDTO get(@PathParam("idHospedaje") Long id) throws WebApplicationException, BusinessLogicException
    {
        return new HospedajeDetaillDTO(hospedajeLogic.find(id));
    }
    
    @PUT
    @Path("{idHospedaje: [0-9][0-9]*}")
    public HospedajeDetaillDTO put(@PathParam("idHospedaje") Long id, HospedajeDetaillDTO dto) throws WebApplicationException, BusinessLogicException
    {
        dto.setId(id);
        return new HospedajeDetaillDTO(hospedajeLogic.update(dto.toEntity()));
    }
    
    @DELETE
    @Path("{idHospedaje: [0-9][0-9]*}")
    public void delete(@PathParam("idHospedaje") Long id) throws WebApplicationException, BusinessLogicException
    {
        hospedajeLogic.delete(id);
    }
    
    @POST
    @Path("{idHospedaje: [0-9][0-9]*}/ubicacion/{idUbicacion: [0-9][0-9]*}")
    public HospedajeDetaillDTO agreagrUbicacion(@PathParam("idHospedaje") Long idHospedaje, @PathParam("idUbicacion") Long idUbicacion)
    {
        return new HospedajeDetaillDTO(hospedajeLogic.agregarUbicacacion(idHospedaje, idUbicacion));
    }
    
    @Path("{idHospedaje: [0-9][0-9]*}/reglas")
    public Class<ReglaResource> getRegla(@PathParam("idHospedaje") Long idHospedaje ) throws WebApplicationException, BusinessLogicException
    {
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if(hospedaje == null) throw new WebApplicationException("Acceso: La entidad no existe", 405);
        return ReglaResource.class;
    }
    
    private List<HospedajeDetaillDTO> construir(List<HospedajeEntity> list)
    {
        List<HospedajeDetaillDTO> ret = new ArrayList<>();
        for(HospedajeEntity r : list) ret.add(new HospedajeDetaillDTO(r));
        return ret;
    }
    
    @Path("{idHospedaje: [0-9][0-9]*}/servicios")
    public Class<ServiciosResourse> getServicio(@PathParam("idHospedaje") Long idHospedaje ) throws WebApplicationException
    {
      HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if(hospedaje == null) throw new WebApplicationException("Acceso: La entidad no existe", 405);
        return ServiciosResourse.class;  
    }
    
    @GET
    @Path("{idHospedaje: [0-9][0-9]*}/arrendador")
    public ArrendadorDTO darArrendador(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException
    {
        return new ArrendadorDTO(hospedajeLogic.find(idHospedaje).getArrendador());
    }
    
    @GET
    @Path("{idHospedaje: [0-9][0-9]*}/facturas")
    public List<FacturaDTO> darFacturas(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException
    {
        return convertirFacturas(hospedajeLogic.find(idHospedaje).getFacturas());
    }
    
    private List<FacturaDTO> convertirFacturas(List<FacturaEntity> facturas)
    {
        List<FacturaDTO> ret = new ArrayList<>();
        if(facturas != null) for(FacturaEntity factura : facturas) ret.add(new FacturaDTO(factura));
        return ret;
    }
    
    @GET
    @Path("{idHospedaje: [0-9][0-9]*}/reservas")
    public List<ReservaDTO> darReserva(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException
    {
        return convertirReserva(hospedajeLogic.find(idHospedaje).getReservas());
    }
    
    private List<ReservaDTO> convertirReserva(List<ReservaEntity> reservas)
    {
        List<ReservaDTO> ret = new ArrayList<>();
        if(reservas != null) for(ReservaEntity reserva : reservas) ret.add(new ReservaDTO(reserva));
        return ret;
    }
    
    @GET
    @Path("{idHospedaje: [0-9][0-9]*}/calificaciones")
    public List<CalificacionDTO> darCalificacion(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException
    {
        return convertirCalificacion(hospedajeLogic.find(idHospedaje).getCalificaciones());
    }
    
    private List<CalificacionDTO> convertirCalificacion(List<CalificacionEntity> calificaciones)
    {
        List<CalificacionDTO> ret = new ArrayList<>();
        if(calificaciones != null) for(CalificacionEntity calificacion : calificaciones) ret.add(new CalificacionDTO(calificacion));
        return ret;
    }
    
}
