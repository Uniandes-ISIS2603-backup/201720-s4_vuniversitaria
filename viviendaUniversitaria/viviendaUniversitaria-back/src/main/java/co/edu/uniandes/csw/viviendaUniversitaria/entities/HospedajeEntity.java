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
 * @author NOA_WERMEID
 */
@Entity
public class HospedajeEntity extends BaseEntity implements Serializable
{
    
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoArrendamiento() {
        return tipoArrendamiento;
    }

    public void setTipoArrendamiento(String tipoArrendamiento) {
        this.tipoArrendamiento = tipoArrendamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
    private String tipoArrendamiento;
    private String descripcion;
    private double valoracion;
    
    
    
}
