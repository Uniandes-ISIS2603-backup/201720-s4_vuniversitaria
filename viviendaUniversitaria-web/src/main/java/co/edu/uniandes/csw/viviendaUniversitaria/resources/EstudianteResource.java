/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDetailDTO;
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

    @Inject
    EstudianteLogic estudiante;

    public EstudianteLogic getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteLogic estudiante) {
        this.estudiante = estudiante;
    }

    @GET
    public List<EstudianteDetailDTO> getEstudiantes() throws Exception {
        return listEstudianteEntity2DetailDTO(estudiante.getEstudiantes());
    }

    @GET
    @Path("{cedula: \\d+}")
    public EstudianteDetailDTO getEstudiante(@PathParam("cedula") Long cedula) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.getEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + " no existe.", 404);
        }
        return new EstudianteDetailDTO(entity);
    }
    
    @POST
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) throws BusinessLogicException {        
         return new EstudianteDetailDTO(this.estudiante.createEstudiante(estudiante.toEntity()));
    }

    @DELETE
    @Path("{estudiantesCedula: \\d+}")
    public void deleteEstudiante(@PathParam("estudiantesCedula") Long cedula) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.getEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + " no existe.", 404);
        }
        estudiante.deleteEstudiante(cedula);
    }
    
    @PUT
    @Path("{cedula: \\d+}")
    public EstudianteDTO updateEstudiante(@PathParam("cedula") Long cedula, EstudianteDTO estu) throws BusinessLogicException {
        estu.setCedula(cedula);
        EstudianteEntity entity = estudiante.getEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + " no existe.", 404);
        }
        return new EstudianteDTO(estudiante.updateEstudiante(estu.toEntity()));
    }
 
    @Path("{cedulaEstudiante: \\d+}/calificaciones")
    public Class<CalificacionResource> getCalificacionResource(@PathParam("cedulaEstudiante") Long cedula) throws BusinessLogicException {
        EstudianteEntity entity = estudiante.getEstudiante(cedula);
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + cedula + "/calificacion no existe.", 404);
        }
        return CalificacionResource.class;
    }
    
    

    private List<EstudianteDetailDTO> listEstudianteEntity2DetailDTO(List<EstudianteEntity> entityList) {
        List<EstudianteDetailDTO> list = new ArrayList<>();
        for (EstudianteEntity entity : entityList) {
            list.add(new EstudianteDetailDTO(entity));
        }
        return list;
    }

    @Path("{cedula: \\d+}/origen")
    public OrigenResource getOrigen()
    {             
     return new OrigenResource();
    }
    
        
}
