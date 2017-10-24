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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class HospedajeResource {

    @Inject
    private HospedajeLogic hospedajeLogic;

    public HospedajeResource() {
        super();
    }

    @POST
    public HospedajeDetaillDTO post(HospedajeDetaillDTO entidad) throws WebApplicationException, BusinessLogicException {
        return new HospedajeDetaillDTO(hospedajeLogic.create(entidad.toEntity()));
    }

    @GET
    public List<HospedajeDetaillDTO> getAll() throws WebApplicationException, BusinessLogicException {
        return construir(hospedajeLogic.findAll());
    }

    @GET
    @Path("{idHospedaje: [0-9][0-9]*}")
    public HospedajeDetaillDTO get(@PathParam("idHospedaje") Long id) throws WebApplicationException, BusinessLogicException {
        return new HospedajeDetaillDTO(hospedajeLogic.find(id));
    }

    @PUT
    @Path("{idHospedaje: [0-9][0-9]*}")
    public HospedajeDetaillDTO put(@PathParam("idHospedaje") Long id, HospedajeDetaillDTO dto) throws WebApplicationException, BusinessLogicException {
        dto.setId(id);
        return new HospedajeDetaillDTO(hospedajeLogic.update(dto.toEntity(), id));
    }

    @DELETE
    @Path("{idHospedaje: [0-9][0-9]*}")
    public void delete(@PathParam("idHospedaje") Long id) throws WebApplicationException, BusinessLogicException {
        hospedajeLogic.delete(id);
    }

    private List<HospedajeDetaillDTO> construir(List<HospedajeEntity> list) {
        List<HospedajeDetaillDTO> ret = new ArrayList<>();
        for (HospedajeEntity r : list) {
            ret.add(new HospedajeDetaillDTO(r));
        }
        return ret;
    }

    //Relaciones
    @Path("{idHospedaje: [0-9][0-9]*}/reglas")
    public Class<ReglaResource> getRegla(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException, BusinessLogicException {
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if (hospedaje == null) {
            throw new WebApplicationException("Acceso: La entidad no existe", 405);
        }
        return ReglaResource.class;
    }

    @GET
    @Path("{idHospedaje: [0-9][0-9]*}/arrendador")
    public ArrendadorDTO darArrendador(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException, BusinessLogicException {
        return new ArrendadorDTO(hospedajeLogic.find(idHospedaje).getArrendador());
    }

    @GET
    @Path("{idHospedaje: [0-9][0-9]*}/facturas")
    public List<FacturaDTO> darFacturas(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException, BusinessLogicException {
        return convertirFacturas(hospedajeLogic.find(idHospedaje).getFacturas());
    }

    private List<FacturaDTO> convertirFacturas(List<FacturaEntity> facturas) {
        List<FacturaDTO> ret = new ArrayList<>();
        if (facturas != null) {
            for (FacturaEntity factura : facturas) {
                ret.add(new FacturaDTO(factura));
            }
        }
        return ret;
    }

    @GET
    @Path("{idHospedaje: [0-9][0-9]*}/reservas")
    public List<ReservaDTO> darReserva(@PathParam("idHospedaje") Long idHospedaje) throws WebApplicationException, BusinessLogicException {
        return convertirReserva(hospedajeLogic.find(idHospedaje).getReservas());
    }

    private List<ReservaDTO> convertirReserva(List<ReservaEntity> reservas) {
        List<ReservaDTO> ret = new ArrayList<>();
        if (reservas != null) {
            for (ReservaEntity reserva : reservas) {
                ret.add(new ReservaDTO(reserva));
            }
        }
        return ret;
    }

    @Path("{idHospedaje: [0-9][0-9]*}/calificaciones")
    public Class<CalificacionResource> getCalificacionResource(@PathParam("idHospedaje") Long idHospedaje) throws BusinessLogicException {
        HospedajeEntity entity = hospedajeLogic.find(idHospedaje);
        if (entity == null) {
            throw new WebApplicationException("El recurso solicitado no existe", 404);
        }
        return CalificacionResource.class;
    }

    /**
     *
     * @param idHospedaje
     * @return Clase servicios
     * @throws co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException
     */
    @Path("{idHospedaje: [0-9][0-9]*}/servicios")
    public Class<ServiciosResourse> getServicios(@PathParam("idHospedaje") Long idHospedaje) throws BusinessLogicException {
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if (hospedaje == null) {
            throw new WebApplicationException("Acceso: La entidad no existe", 405);
        }
        return ServiciosResourse.class;
    }

}
