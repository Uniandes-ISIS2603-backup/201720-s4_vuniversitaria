/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.OrigenDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.EstudianteLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
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
 * @author a.eslava
 */
@Path("estudiantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EstudianteResource {

    private static final String ALGO1 = "El recurso /estudiantes/ ";
    private static final String ALGO2 = " no existe";

    EstudianteLogic estudiante;

    public EstudianteResource() {
    //asd
    }
    @Inject
    public EstudianteResource(EstudianteLogic estudiante) {
        this.estudiante = estudiante;
    }

    

    @GET
    public List<EstudianteDTO> finds() throws BusinessLogicException {
        return listEstudianteEntity2DTO(estudiante.findAll());
    }

    @GET
    @Path("{cedula: \\d+}")
    public EstudianteDTO find(@PathParam("cedula") Long cedula) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.find(cedula);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + cedula + ALGO2, 404);
        }
        return new EstudianteDTO(entity);
    }

    @POST
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) throws BusinessLogicException {
        return new EstudianteDTO(this.estudiante.create(estudiante.toEntity()));
    }

    @DELETE
    @Path("{estudiantesCedula: \\d+}")
    public void deleteEstudiante(@PathParam("estudiantesCedula") Long cedula) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.find(cedula);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + cedula + ALGO2, 404);
        }
        estudiante.delete(cedula);
    }

    @PUT
    @Path("{cedula: \\d+}")
    public EstudianteDTO updateEstudiante(@PathParam("cedula") Long cedula, EstudianteDTO estu) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.find(cedula);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + cedula + ALGO2, 404);
        }
        return new EstudianteDTO(estudiante.update(estu.toEntity(), cedula));
    }

    @Path("{cedulaEstudiante: \\d+}/calificaciones")
    public Class<CalificacionResource> getCalificacionResource(@PathParam("cedulaEstudiante") Long cedulaEstudiante) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.find(cedulaEstudiante);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + cedulaEstudiante + ALGO2, 404);
        }
        return CalificacionResource.class;
    }

    private List<EstudianteDTO> listEstudianteEntity2DTO(List<EstudianteEntity> entityList) {
        List<EstudianteDTO> list = new ArrayList<>();
        for (EstudianteEntity entity : entityList) {
            list.add(new EstudianteDTO(entity));
        }
        return list;
    }

    @GET
    @Path("{cedula: \\d+}/origenes")
    public OrigenDTO getOrigen(@PathParam("cedula") Long cedula) throws BusinessLogicException {
        return new OrigenDTO(estudiante.getOrigen(cedula));
    }

    @Path("{cedulaEstudiante: \\d+}/reservas")
    public Class<ReservaResource> getReservaResource(@PathParam("cedulaEstudiante") Long cedulaEstudiante) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.find(cedulaEstudiante);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + cedulaEstudiante + ALGO2, 404);
        }
        return ReservaResource.class;
    }
    
    @Path("{cedulaEstudiante: \\d+}/factura")
    public Class<FacturaResource> getFacturasResource(@PathParam("cedulaEstudiante") Long cedulaEstudiante) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.find(cedulaEstudiante);
        if (entity == null) {
            throw new WebApplicationException(ALGO1 + cedulaEstudiante + "/calificacion no existe.", 404);
        }
        return FacturaResource.class;
    }

}
