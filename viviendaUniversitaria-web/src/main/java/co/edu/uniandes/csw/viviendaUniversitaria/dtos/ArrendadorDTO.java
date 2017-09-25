/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import java.util.List;
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
     * Lista de los hospedajes pertenecientes al arrendador
     */
    //@PodamExclude
    //@OneToMany(mappedBy = "arrendador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospedajeEntity> hospedaje;
    
    
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
     * Retorna los hospedajes del arrendador
     * @return hospedaje
     */
    public List<HospedajeEntity> getHospedajes(){
        return hospedaje;
    }
    
    /**
     * Establece los hospedajes del arrendador
     * @param hospedajes 
     */
    public void setHospedajes(List<HospedajeEntity> hospedajes){
        this.hospedaje = hospedajes;
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
     * Convierte la informacion a una entidad arrendador
     * @return 
     */
    public ArrendadorEntity toEntity() {
        ArrendadorEntity entity = new ArrendadorEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setHospedajes(this.hospedaje);
        return entity;
    }
    
}
