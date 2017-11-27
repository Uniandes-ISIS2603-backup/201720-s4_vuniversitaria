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
    
    public static Long id;
    public static String rol;

    /**
     * Constructor por defecto
     */
    public Validacion() {
        super();
        id = 0L;
        rol = "No registrado";
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
        id = 0L;
        rol = "No registrado";
    }

    /**
     * Método que valida un usuario
     *
     * @param usuario
     * @return si pudo encontrarlo o no
     */
    public String validarUsuario(String usuario) {
        EstudianteEntity est = el.buscarUsusario(usuario);
        if(est != null) {
            id = est.getId();
            rol = "Estudiante";
            return rol+";"+est.getContrasenia();
        } else {
            ArrendadorEntity arr = al.buscarUsusario(usuario);
            if(arr != null) {
                id = arr.getId();
                rol = "Arrendador";
                return rol+";"+arr.getContrasenia();
            } else {
                rol = "No registrado";
                return "Error;Error";
            }
        }
    }
}
