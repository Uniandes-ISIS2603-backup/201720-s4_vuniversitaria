/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.HospedajeDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.HospedajeDetaillDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ArrendadorLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author kk.penaranda
 */
@Produces("application/json")
@Consumes("application/json")
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
    @Path("{id: [0-9][0-9]*}")
    public HospedajeDetaillDTO getHospedajePorId(@PathParam("id") Long id, @PathParam("hospedajeId") Long hospedajeId) {
        return new HospedajeDetaillDTO(arrendadorLogic.getHospedajeIdArrendador(id, hospedajeId));
    }
}
