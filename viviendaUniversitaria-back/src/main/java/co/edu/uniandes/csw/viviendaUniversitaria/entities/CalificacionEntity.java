/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author kk.penaranda
 */
@Entity
public class CalificacionEntity extends BaseEntity implements Serializable{
    private double valoracion; //Puntuacion dada por un usuario
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha; //Fecha en la que se realiza la calificacion
    private String comentario;//Descripción de la opinión
    
    public double getValoracion(){
        return valoracion;
    }
    
   
    public Date getFecha(){
        return fecha;
    }
    
    public String getComentario(){
        return comentario;
    }
    
    public void setValoracion(double valoracion){
        this.valoracion= valoracion;
    }
    
    public void setFecha(Date fecha){
        this.fecha= fecha;
    }
    
    public void setComentario(String comentario){
        this.comentario= comentario;
    }
}
