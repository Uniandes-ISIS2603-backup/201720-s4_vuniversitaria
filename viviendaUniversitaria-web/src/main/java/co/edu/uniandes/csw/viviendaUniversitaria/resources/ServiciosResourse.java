/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ServiciosDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ServiciosLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
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

public class ServiciosResourse {

    /**
     * Relacion con el logic de servicios
     */
    private ServiciosLogic logic;

    /**
     * Constructor por default
     */
    public ServiciosResourse() {
    }
    /**
     * Contructor usado por el ejb
     * @param logic 
     */
    @Inject
    public ServiciosResourse(ServiciosLogic logic) {
        this.logic = logic;
    }
    /**
     * Servicio get ALL
     * @param idHospedaje
     * @return List de ServiciosDetailDTO
     * @throws BusinessLogicException 
     */
    @GET
    public List<ServiciosDetailDTO> getList(@PathParam("idHospedaje") Long idHospedaje) throws BusinessLogicException {
        List<ServiciosEntity> listServicios = logic.findAll(idHospedaje);
        List<ServiciosDetailDTO> respuesta = new ArrayList<>();
        for (ServiciosEntity listServicio : listServicios) {
            respuesta.add(new ServiciosDetailDTO(listServicio));
        }
        return respuesta;
    }

    /**
     * Servicio get por id
     * @param idHospedaje
     * @param id
     * @return ServiciosDetailDTO
     * @throws BusinessLogicException 
     */
    @GET
    @Path("{id: \\d+}")
    public ServiciosDetailDTO getServicio(@PathParam("idHospedaje") long idHospedaje, @PathParam("id") long id) throws BusinessLogicException {
        return new ServiciosDetailDTO(logic.findServicio(idHospedaje, id));
    }

    /**
     * Servicio post
     * @param idHospedaje
     * @param nuevoServicio
     * @return ServiciosDetailDTO
     * @throws BusinessLogicException 
     */
    @POST
    public ServiciosDetailDTO createServicio(@PathParam("idHospedaje") long idHospedaje, ServiciosDetailDTO nuevoServicio) throws BusinessLogicException {
        return new ServiciosDetailDTO(logic.createServicio(idHospedaje, nuevoServicio.toEntity()));

    }

    /**
     * Servicio put
     * @param idHospedaje
     * @param id
     * @param servicioAtualizado
     * @return ServiciosDetailDTO
     * @throws BusinessLogicException 
     */
    @PUT
    @Path("{id: \\d+}")
    public ServiciosDetailDTO updateServicio(@PathParam("idHospedaje") Long idHospedaje,@PathParam("id") Long id, ServiciosDetailDTO servicioAtualizado) throws BusinessLogicException {
        return new ServiciosDetailDTO(logic.updateServicio(idHospedaje,id, servicioAtualizado.toEntity()));
    }
    /**
     * Servicio delete
     * @param idHospedaje
     * @param id
     * @throws BusinessLogicException 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteServicio(@PathParam("idHospedaje") Long idHospedaje, @PathParam("id") Long id) throws BusinessLogicException {
        logic.delete(idHospedaje, id);
    }
}