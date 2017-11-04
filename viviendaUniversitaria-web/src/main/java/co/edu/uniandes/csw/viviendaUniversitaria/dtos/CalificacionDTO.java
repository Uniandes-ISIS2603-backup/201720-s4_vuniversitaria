/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String fecha;
    
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
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        this.id = entity.getId();
        this.valoracion = entity.getValoracion();
        this.comentario = entity.getComentario();
        this.fecha = date.format(entity.getFecha());
        
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
    public String getFecha(){
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
    
    public void setComentario(String comentario){
        this.comentario= comentario;
    }
    
    
    
    /**
     * Establece la fecha
     * @param fecha 
     */
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    /**
     * Convierte el DTO en una entidad
     * @return entity de tipo calificacion
     */
    public CalificacionEntity toEntity() {
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(this.id);
        entity.setValoracion(this.valoracion);
        entity.setComentario(this.comentario);
        try {
            entity.setFecha(date.parse(this.fecha));
        } catch (ParseException ex) {
            Logger.getLogger(CalificacionDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return entity;
    }
            
}
