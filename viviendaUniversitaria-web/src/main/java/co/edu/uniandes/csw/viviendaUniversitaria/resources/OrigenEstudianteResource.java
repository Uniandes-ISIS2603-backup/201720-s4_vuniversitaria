/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.OrigenLogic;
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
public class OrigenEstudianteResource {

    private OrigenLogic origenLogic;

    public OrigenEstudianteResource() {
    //hgs
    }
    @Inject
    public OrigenEstudianteResource(OrigenLogic origenLogic) {
        this.origenLogic = origenLogic;
    }
    
    
    
    
    /**
     * Convierte una lista de EstudianteEntity a una lista de EstudianteDTO.
     *
     * @param entityList Lista de EstudianteEntity a convertir.
     * @return Lista de EstudianteDTO convertida.
     * 
     */
    private List<EstudianteDTO> estudiantesListEntity2DTO(List<EstudianteEntity> entityList) {
        List<EstudianteDTO> list = new ArrayList<>();
        for (EstudianteEntity entity : entityList) {
            list.add(new EstudianteDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de EstudianteDTO a una lista de EstudianteEntity.
     *
     * @param dtos Lista de EstudianteDTO a convertir.
     * @return Lista de EstudianteEntity convertida.
     * 
     */
    private List<EstudianteEntity> estudiantesListDTO2Entity(List<EstudianteDTO> dtos) {
        List<EstudianteEntity> list = new ArrayList<>();
        for (EstudianteDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de EstudianteDTO asociadas a una
     * instancia de Origen
     *
     * @param OrigensId Identificador de la instancia de Origen
     * @return Colección de instancias de EstudianteDTO asociadas a la instancia
     * de Origen
     * 
     */
    @GET
    public List<EstudianteDTO> listEstudiantes(@PathParam("OrigenesId") Long origensId) throws BusinessLogicException {
        return estudiantesListEntity2DTO(origenLogic.listEstudiantes(origensId));
    }

    /**
     * Obtiene una instancia de Estudiante asociada a una instancia de Origen
     *
     * @param OrigensId Identificador de la instancia de Origen
     * @param EstudiantesId Identificador de la instancia de Estudiante
     * @return
     * @throws co.edu.uniandes.csw.Estudiantestore.exceptions.BusinessLogicException
     * 
     */
    @GET
    @Path("{EstudiantesId: \\d+}")
    public EstudianteDTO getEstudiantes(@PathParam("OrigenesId") Long origensId, @PathParam("EstudiantesId") Long estudiantesId) throws BusinessLogicException {
        return new EstudianteDTO(origenLogic.getEstudiante(origensId, estudiantesId));
    }

    /**
     * Asocia un Estudiante existente a un Origen
     *
     * @param OrigensId Identificador de la instancia de Origen
     * @param EstudiantesId Identificador de la instancia de Estudiante
     * @return Instancia de EstudianteDTO que fue asociada a Origen
     * 
     */
    
    @POST
    @Path("{EstudiantesId: \\d+}")
    public EstudianteDTO addEstudiantes(@PathParam("OrigenesId") Long origensId, @PathParam("EstudiantesId") Long estudiantesId) throws BusinessLogicException {
        return new EstudianteDTO(origenLogic.addEstudiante(estudiantesId,origensId));
    }

    /**
     * Desasocia un Estudiante existente de un Origen existente
     *
     * @param OrigensId Identificador de la instancia de Origen
     * @param EstudiantesId Identificador de la instancia de Estudiante
     * 
     */
    @DELETE
    @Path("{EstudiantesId: \\d+}")
    public void removeEstudiantes(@PathParam("OrigenesId") Long origensId, @PathParam("EstudiantesId") Long estudiantesId) throws BusinessLogicException {
        
        origenLogic.removeEstudiante(estudiantesId,origensId);
    }
}
