/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author kk.penaranda
 */
@Entity
public class ArrendadorEntity extends BaseEntity implements Serializable{

    private String nombre;// Nombre asociado al arrendador
    
    
    /**
     * Retorna el nombre de un arrendador
     * @return nombre
     */
    public String getNombre(){
        return nombre;
    }
    
    
    /**
     * Establece el nombre perteneciente a un arrendador
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
}
