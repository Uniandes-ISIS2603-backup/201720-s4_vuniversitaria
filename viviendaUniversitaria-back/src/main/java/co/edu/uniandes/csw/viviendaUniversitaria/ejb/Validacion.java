/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import javax.inject.Inject;

/**
 * Clase que valida el usuario
 *
 * @author ws.duarte
 */
public class Validacion {

    /**
     * Logica de estudiante
     */
    private EstudianteLogic el;
    /**
     * Logica de arrendador
     */
    private ArrendadorLogic al;
    
    public static Long id = 0L;
    public static String rol = "No registrado";

    /**
     * Constructor por defecto
     */
    public Validacion() {
        super();
    }

    /**
     * Constructor que inyecta las logicas
     *
     * @param el logica del estudiante
     * @param al logica de arrendador
     */
    @Inject
    public Validacion(EstudianteLogic el, ArrendadorLogic al) {
        this.el = el;
        this.al = al;
    }

    /**
     * Método que valida un usuario
     *
     * @param idV id del usuario
     * @return si pudo encontrarlo o no
     */
    public String validarUsuario(String usuario) {
        EstudianteEntity est = el.buscarUsusario(usuario);
        if(est != null) {
            id = est.getId();
            return (rol = "Estudinte")+";"+est.getContrasenia();
        } else {
            ArrendadorEntity arr = al.buscarUsusario(usuario);
            if(arr != null) {
                id = arr.getId();
                return (rol = "Arrendador")+";"+arr.getContrasenia();
            } else {
                return "Error;Error";
            }
        }
    }
}
