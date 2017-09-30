/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.UniversidadDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.UniversidadLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
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
@Path("universidades")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class UniversidadResource {

    @Inject
    private UniversidadLogic logic;

    @GET
    public List<UniversidadDetailDTO> getUniversidades() throws BusinessLogicException {
        return listEntity2DetailDTO(logic.getUniversidades());
    }

    private List<UniversidadDetailDTO> listEntity2DetailDTO(List<UniversidadEntity> entityList) {
        List<UniversidadDetailDTO> list = new ArrayList<>();
        for (UniversidadEntity entity : entityList) {
            list.add(new UniversidadDetailDTO(entity));
        }
        return list;
    }

    @GET
    @Path("/{idUni: \\d+}")
    public UniversidadDetailDTO getUniversidad(@PathParam("idUni") Long id) throws BusinessLogicException {
        if (logic.getUniversidad(id) != null) {
            UniversidadEntity entity = logic.getUniversidad(id);
            return new UniversidadDetailDTO(entity);
        } else {
            throw new WebApplicationException("La universidad con ese id no existe", 404);
        }
    }

    @POST
    public UniversidadDetailDTO createUniversidad(UniversidadDetailDTO ubi) throws BusinessLogicException {
        return new UniversidadDetailDTO(logic.createUniversidad(ubi.toEntity()));

    }

    @POST
    @Path("{idUni: \\d+}/ubicacion/{idUbicacion: \\d+}")
    public UniversidadDetailDTO agregarUbicacion(@PathParam("idUni") Long idUni, @PathParam("idUbicacion") Long idUbicacion) {
        return new UniversidadDetailDTO(logic.agregarUbicacacion(idUni, idUbicacion));
    }

    @PUT
    @Path("{idUni: \\d+}")
    public UniversidadDetailDTO updateUniversidad(@PathParam("idUni") Long idUni, UniversidadDetailDTO ubi) throws BusinessLogicException {
        if (idUni != ubi.getId()) {
            throw new WebApplicationException("Los ids no coinciden", 412);
        }
        UniversidadEntity entity = logic.updateUniversidad(idUni, ubi.toEntity());
        return new UniversidadDetailDTO(entity);
    }

    @DELETE
    @Path("/{idUni: \\d+}")
    public void deleteUniversidad(@PathParam("idUni") Long id) throws BusinessLogicException, WebApplicationException {
        logic.deleteUniversidad(id);
    }
}
