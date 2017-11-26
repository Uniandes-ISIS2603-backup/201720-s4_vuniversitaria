/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.LugaresInteresDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.LugaresInteresLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jc.sanguino10
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class LugarInteresResource {

    /**
     * Relacion con el logic de servicios
     */
    private LugaresInteresLogic logic;

    /**
     * Constructor por default
     */
    public LugarInteresResource() {
    }

    /**
     * Contructor usado por el ejb
     *
     * @param logic
     */
    @Inject
    public LugarInteresResource(LugaresInteresLogic logic) {
        this.logic = logic;
    }

    /**
     * Servicio get ALL
     *
     * @param idHospedaje
     * @return List de ServiciosDetailDTO
     * @throws BusinessLogicException
     */
    @GET
    public List<LugaresInteresDTO> getList(@PathParam("idHospedaje") Long idHospedaje) throws BusinessLogicException {
        List<LugaresInteresEntity> listLugaresInteres = logic.findAll(idHospedaje);
        List<LugaresInteresDTO> respuesta = new ArrayList<>();
        for (LugaresInteresEntity listLugaresIntere : listLugaresInteres) {
            respuesta.add(new LugaresInteresDTO(listLugaresIntere));
        }
        return respuesta;
    }

    /**
     * Servicio get por id
     *
     * @param idHospedaje
     * @param id
     * @return ServiciosDetailDTO
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public LugaresInteresDTO getLugarInteres(@PathParam("idHospedaje") long idHospedaje, @PathParam("id") long id) throws BusinessLogicException {
        return new LugaresInteresDTO(logic.find(idHospedaje, id));
    }

    /**
     *
     * @param idHospedaje
     * @param nuevoLugar
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public LugaresInteresDTO createLugarInteres(@PathParam("idHospedaje") long idHospedaje, LugaresInteresDTO nuevoLugar) throws
            BusinessLogicException {
        return new LugaresInteresDTO(logic.create(idHospedaje, nuevoLugar.toEntity()));

    }

    /**
     * 
     * @param idHospedaje
     * @param id
     * @param lugarAtualizado
     * @return
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{id: \\d+}")
    public LugaresInteresDTO updateLugarInteres(@PathParam("idHospedaje") Long idHospedaje, @PathParam("id") Long id, LugaresInteresDTO lugarAtualizado) throws BusinessLogicException {
        return new LugaresInteresDTO(logic.update(lugarAtualizado.toEntity(), idHospedaje));
    }

    /**
     * Servicio delete
     *
     * @param idHospedaje
     * @param id
     * @throws BusinessLogicException
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteLugarInteres(@PathParam("idHospedaje") Long idHospedaje, @PathParam("id") Long id) throws BusinessLogicException {
        logic.delete(idHospedaje, id);
    }
}
