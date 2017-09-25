/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Temporal;

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
        return entity;
    }
            
}
