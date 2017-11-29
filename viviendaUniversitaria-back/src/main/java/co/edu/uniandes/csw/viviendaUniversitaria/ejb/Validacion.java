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
     * @param usuario
     * @return si pudo encontrarlo o no
     */
    public String validarUsuario(String usuario) {
        EstudianteEntity est = el.buscarUsusario(usuario);
        if(est != null) {
            return "Estudiante;"+est.getContrasenia()+";"+est.getId();
        } else {
            ArrendadorEntity arr = al.buscarUsusario(usuario);
            if(arr != null) {
                return "Arrendador;"+arr.getContrasenia()+";"+arr.getId();
            } else {
                return "Error;Error;Error";
            }
        }
    }
}
