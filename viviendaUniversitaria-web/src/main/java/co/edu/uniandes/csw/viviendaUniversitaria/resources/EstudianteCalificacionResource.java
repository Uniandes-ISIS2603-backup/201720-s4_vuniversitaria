/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.CalificacionDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.EstudianteLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author a.eslava
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstudianteCalificacionResource {
    @Inject
    private EstudianteLogic estudianteLogic;
    
    /**
     * Convierte una lista de CalificacionDTO a una lista de CalificacionEntity.
     *
     * @param dtos Lista de CalificacionDTO a convertir.
     * @return Lista de CalificacionEntity convertida.
     * 
     */
    private List<CalificacionEntity> CalificacionListDTO2Entity(List<CalificacionDTO> dtos) {
        List<CalificacionEntity> list = new ArrayList<>();
        for (CalificacionDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    /**
     * Convierte una lista de CalificacionEntity a una lista de CalificacionDTO.
     *
     * @param entityList Lista de CalificacionEntity a convertir.
     * @return Lista de CalificacionDTO convertida.
     * 
     */
    private List<CalificacionDTO> CalificacionListEntity2DTO(List<CalificacionEntity> entityList) {
        List<CalificacionDTO> list = new ArrayList<>();
        for (CalificacionEntity entity : entityList) {
            list.add(new CalificacionDTO(entity));
        }
        return list;
    }
    
       /**
     * Asocia un Calificacion existente a un Estudiante
     *
     * @param EstudiantesId Identificador de la instancia de Estudiante
     * @param CalificacionId Identificador de la instancia de Calificacion
     * @return Instancia de CalificacionDTO que fue asociada a Estudiante
     * 
     */
    
    @POST
    @Path("{calificacionesId: \\d+}")
    public CalificacionDTO addCalificacion(@PathParam("EstudiantesId") Long EstudiantesId, @PathParam("calificacionesId") Long calificaionesId) throws BusinessLogicException {
        return new CalificacionDTO(estudianteLogic.addCalificacion(calificaionesId, EstudiantesId));
    }
     /**
     * Obtiene una instancia de Estudiante asociada a una instancia de Origen
     *
     * @param EstudiantesId Identificador de la instancia de Estudiante
     * @param CalificacionId Identificador de la instancia de Calificacion
     * @return
     * @throws co.edu.uniandes.csw.Estudiantestore.exceptions.BusinessLogicException
     * 
     */
    @GET
    @Path("{calificacionesId: \\d+}")
    public CalificacionDTO getCalificaciones(@PathParam("EstudiantesId") Long EstudiantesId, @PathParam("calificacionesId") Long calificacionesId) throws BusinessLogicException {
        return new CalificacionDTO(estudianteLogic.getCalificacion(calificacionesId, EstudiantesId));
    }
    
    /**
     * Obtiene una colección de instancias de CalificacionDTO asociadas a una
     * instancia de Estudiante
     *
     * @param EstudiantesId Identificador de la instancia de Estudiantes
     * @return Colección de instancias de CalificacionDTO asociadas a la instancia
     * de Origen
     * 
     */
    @GET
    public List<CalificacionDTO> listCalificaciones(@PathParam("EstudiantesId") Long EstudiantesId) {
        return CalificacionListEntity2DTO(estudianteLogic.listCalificaciones(EstudiantesId));
    }
    
        /**
     * Desasocia un Calificacion existente de un Estudiantes existente
     *
     * @param EstudiantesId Identificador de la instancia de Estudiantes
     * @param CalificacionId Identificador de la instancia de Calificacion
     * 
     */
    @DELETE
    @Path("{calificacionesId: \\d+}")
    public void removeCalificacion(@PathParam("EstudiantesId") Long EstudiantesId, @PathParam("calificacionesId") Long calificacionesId) throws BusinessLogicException {
        
        estudianteLogic.removeCalificaciones(calificacionesId,EstudiantesId);
    }
}
