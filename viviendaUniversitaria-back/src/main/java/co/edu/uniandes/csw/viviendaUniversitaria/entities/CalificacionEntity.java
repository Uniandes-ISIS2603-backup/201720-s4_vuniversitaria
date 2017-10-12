/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author kk.penaranda
 */
@Entity
public class CalificacionEntity implements Serializable {

    /**
     * Identificador de la calificacion 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Puntuacion dada por un usuario
     */
    private double valoracion;

    /**
     * Modela la fecha en la que se realizó la calificación
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    /**
     * Descripción de la opinión dada por el usuario
     */
    private String comentario;

    /**
     * Hospedaje al que se le realizó la calificación
     */
    @PodamExclude
    @ManyToOne
    private HospedajeEntity hospedaje;    
    
    /**
     * Estudiante que realizó la calificación
     */
    @PodamExclude
    @ManyToOne
    private EstudianteEntity estudiante;

    /**
     * Retorna el identificador de la calificación
     * @return id
     */
    public Long getId(){
        return id;
    }
    
    /**
     * Establece el identificador de la calificación
     * @param id 
     */
    public void setId(Long id){
        this.id= id;
    }
    
    /**
     * Retorna la calificacion dada por un usuario
     * @return valoracion
     */
    public double getValoracion() {
        return this.valoracion;
    }

    /**
     * Retorna la fecha en la que el usuario otorgó la calificación
     * @return fecha
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * Retorna el texto calificativo que otorgó el usuario
     * @return comentario
     */
    public String getComentario() {
        return this.comentario;
    }

    /**
     * Retorna el hospedaje calificado
     * @return hospedaje
     */
    public HospedajeEntity getHospedaje() {
        return this.hospedaje;
    }

    /**
     * Retorna el estudiante que realizó la acción
     * @return estudiante
     */
    public EstudianteEntity getEstudiante() {
        return this.estudiante;
    }

    /**
     * Establece el hospedaje que fue calificado
     * @param hospedaje 
     */
    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }

    /**
     * Establece el estudiante que realizó la calificación
     * @param estudiante 
     */
    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Establece la puntuación otorgada por el usuario
     * @param valoracion 
     */
    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    /**
     * Establece la fecha en la que se realizó la calificación.
     * La fecha tiene un formato de año-mes-día
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el comentario realizado por el usuario
     * @param comentario 
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null ){
            return false;
        }
        if(this.getClass()!= obj.getClass()){
            return false;
        }
        if (this.getId() != null && ((CalificacionEntity) obj).getId()!= null) {
            return this.getId().equals(((CalificacionEntity) obj).getId());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.valoracion) ^ (Double.doubleToLongBits(this.valoracion) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.fecha);
        hash = 79 * hash + Objects.hashCode(this.comentario);
        hash = 79 * hash + Objects.hashCode(this.hospedaje);
        return hash;
    }

   

}
