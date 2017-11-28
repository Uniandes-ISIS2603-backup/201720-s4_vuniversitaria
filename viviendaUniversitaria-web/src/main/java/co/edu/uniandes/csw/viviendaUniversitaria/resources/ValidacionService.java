/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.ejb.Validacion;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ws.duarte
 */
@Path("/validar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ValidacionService 
{
    @Inject
    Validacion v;

    public ValidacionService() {
        super();
    }
    
    @GET
    @Path("{nombreUsuario: ([0-9]|[a-z]|[A-Z])([0-9]|[a-z]|[A-Z])*}")///
    public String validarUsu(@PathParam("nombreUsuario") String usuario)
    {
        String[] sep = v.validarUsuario(usuario).split(";");
        return "{ \"rol\": \""+sep[0]+"\",\"contrasenia\": \""+sep[1]+"\",\"id\": \""+sep[2]+"\"}";
    }
    
}
