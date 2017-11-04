/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;

/**
 *
 * @author kk.penaranda
 */
public class ArrendadorDTO {

    /**
     * Atributo que representa el identificador del arrendador
     */
    private Long id;
    
    /**
     * Atributo que representa el nombre del arrendador
     */
    private String nombre;
    
    /**
     * Atrbuto de la ruta
     */
    private String ruta;    
        
    
    /**
     * Constructor
     */
    public ArrendadorDTO(){
        //Constructor por defecto
    }
    
    /**
     * Convierte los datos de entidad Arrendador a DTO
     * @param entity 
     */
    public ArrendadorDTO(ArrendadorEntity entity){
        this.id= entity.getId();
        this.nombre = entity.getNombre();
        this.ruta= entity.getRuta();
    }
    
    /**
     * Retorna el identificador del arrendador
     * @return id
     */
    public Long getId(){
        return id;
    }
    
    /**
     * Retorna el nombre del arrendador
     * @return nombre
     */
    public String getNombre(){
        return nombre;
    }
    
    
    /**
     * Establece el identificador
     * @param id 
     */
    public void setId(Long id){
        this.id= id;
    }
    
    /**
     * Establece el nombre
     * @param nombre 
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    /**
     * Retorna la ruta de la imagen
     * @return ruta
     */
    public String getRuta(){
        return this.ruta;
    }
    
    /**
     * Establece la ruta de la imagen
     * @param ruta 
     */
    public void setRuta(String ruta){
        this.ruta= ruta;
    }
    
    /**
     * Convierte la informacion a una entidad arrendador
     * @return 
     */
    public ArrendadorEntity toEntity() {
        ArrendadorEntity entity = new ArrendadorEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setRuta(this.ruta);
        return entity;
    }
    
}
