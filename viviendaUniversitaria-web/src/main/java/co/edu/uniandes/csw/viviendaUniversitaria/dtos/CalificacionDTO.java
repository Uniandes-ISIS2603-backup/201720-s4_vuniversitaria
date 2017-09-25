/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author kk.penaranda
 */
public class CalificacionDTO {
    
    /**
     * Identificador de la calificacion
     */
    private Long id; 
    
    /**
     * Valoracion dada
     */
    private double valoracion;
    
    /**
     * Comentario otorgado
     */
    private String comentario;
    
    /**
     * Fecha en la que se realizó la calificación
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    /**
     * Hospedaje al que se le realizó la calificación
     */
    //@PodamExclude
    //@ManyToOne
    private HospedajeEntity hospedaje;    
    
    /**
     * Estudiante que realizó la calificación
     */
    //@PodamExclude
    //@ManyToOne
    private EstudianteEntity estudiante;
    
    /**
     * Constructor
     */
    public CalificacionDTO(){
        //Constructor por defecto
    }
    
    /**
     * Convertir una entidad a DTO
     * @param entity 
     */
    public CalificacionDTO(CalificacionEntity entity){
        this.id = entity.getId();
        this.valoracion = entity.getValoracion();
        this.fecha = entity.getFecha();
        this.comentario = entity.getComentario();
    }
    
    /**
     * Retorna el identificador de la calificación
     * @return id
     */
    public Long getId(){
        return id;
    }
    
    /**
     * Retorna la valoración de la calificación
     * @return valoracion
     */
    public double getValoracion(){
        return valoracion;
    }
    
    /**
     * Retorna el comentario dado
     * @return comentario
     */
    public String getComentario(){
        return comentario;
    }
    
    /**
     * Retorna la fecha en la que se realizó la calificación
     * @return fecha
     */
    public Date getFecha(){
        return fecha;
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
     * Establece el identificador
     * @param id 
     */
    public void setId(Long id){
        this.id= id;
    }
    
    /**
     * Establece la valoracion
     * @param valoracion 
     */
    public void setValoracion(double valoracion){
        this.valoracion = valoracion;
    }
    
    /**
     * Establece el comentario
     * @param comentario 
     */
    public void setComentario(String comentario){
        this.comentario= comentario;
    }
    
    /**
     * Establece la fecha
     * @param fecha 
     */
    private void setFecha(Date fecha){
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        date.format(fecha);
        this.fecha = fecha;
    }
    
    /**
     * Convierte el DTO en una entidad
     * @return entity de tipo calificacion
     */
    public CalificacionEntity toEntity() {
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(this.id);
        entity.setComentario(this.comentario);
        entity.setFecha(this.fecha);
        entity.setValoracion(this.valoracion);
        entity.setEstudiante(this.estudiante);
        entity.setHospedaje(this.hospedaje);
        return entity;
    }
            
}
