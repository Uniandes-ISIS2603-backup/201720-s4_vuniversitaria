/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.HospedajeDetaillDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ArrendadorLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author kk.penaranda
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArrendadorHospedajeResource {

    @Inject
    private ArrendadorLogic arrendadorLogic;
    
    private List<HospedajeDetaillDTO> getListaHospedajesArrendador(List<HospedajeEntity> entityList){
        List<HospedajeDetaillDTO> listaHospedaje = new ArrayList<>();
        for (HospedajeEntity entity : entityList) {
            listaHospedaje.add(new HospedajeDetaillDTO(entity));
        }
        return listaHospedaje;
    }
    
        
    @GET
    public List<HospedajeDetaillDTO> getHospedajes(@PathParam("id") Long id) {
        return getListaHospedajesArrendador(arrendadorLogic.getHospedajesArrendador(id));
    }

    @GET
    @Path("{hospedajeId: [0-9][0-9]*}")
    public HospedajeDetaillDTO getHospedajePorId(@PathParam("id") Long id, @PathParam("hospedajeId") Long hospedajeId) {
        try {
            return new HospedajeDetaillDTO(arrendadorLogic.getHospedajeIdArrendador(id, hospedajeId));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ArrendadorHospedajeResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @POST
    @Path("{hospedajeId: [0-9][0-9]*}")
    public HospedajeDetaillDTO addHospedajesArrendador(@PathParam("id") Long id, @PathParam("hospedajeId") Long hospedajeId) throws BusinessLogicException {
        return new HospedajeDetaillDTO(arrendadorLogic.addHospedaje(id, hospedajeId));
    }
    
    @DELETE
    @Path("{hospedajeId: [0-9][0-9]*}")
    public void deleteHospedajesArrendador(@PathParam("id") Long id, @PathParam("hospedajeId") Long hospedajeId) throws BusinessLogicException{
        arrendadorLogic.removerHospedajes(id, hospedajeId);
    }
}

