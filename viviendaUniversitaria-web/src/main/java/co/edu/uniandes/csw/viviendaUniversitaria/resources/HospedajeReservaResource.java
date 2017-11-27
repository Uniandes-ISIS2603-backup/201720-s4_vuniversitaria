/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ReservaDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ReservaDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.HospedajeLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.OrigenLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 *
 * @author a.eslava
 */
public class HospedajeReservaResource {
    
    private HospedajeLogic hospedajeLogic;

    public HospedajeReservaResource() {
        //constructor para la parte web
    }

    @Inject public HospedajeReservaResource(HospedajeLogic hospedajeLogic) {
        this.hospedajeLogic = hospedajeLogic;
    }
     
}
