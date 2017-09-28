/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.ejb.FacturaLogic;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 *
 * @author je.bejarano10
 */
@Produces("application/json")
@Consumes("application/json")
public class FacturaDetalleReservaResource {
    @Inject 
    private FacturaLogic facturaLogic;
    
}
