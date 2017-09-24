/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import java.util.Date;

/**
 *
 * @author kk.penaranda
 */
public class CalificacionDTO {
    
    private Long id; 
    private double valoracion;
    private String comentario;
    private Date fecha;
    
    public CalificacionDTO(){
        //Constructor por defecto
    }
    
    public CalificacionDTO(CalificacionEntity entity){
        this.id = entity.getId();
        this.valoracion = entity.getValoracion();
        this.fecha = entity.getFecha();
        this.comentario = entity.getComentario();
    }
    
    public Long getId(){
        return id;
    }
    
    public double getValoracion(){
        return valoracion;
    }
    
    public String getComentario(){
        return comentario;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setId(Long id){
        this.id= id;
    }
    
    public void setValoracion(double valoracion){
        this.valoracion = valoracion;
    }
    
    public void setComentario(String comentario){
        this.comentario= comentario;
    }
    
    private void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public CalificacionEntity toEntity() {
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(this.id);
        entity.setComentario(this.comentario);
        entity.setFecha(this.fecha);
        entity.setValoracion(this.valoracion);
        return entity;
    }
            
}
