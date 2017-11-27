/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;

/**
 *
 * @author c.santacruza
 */
public class UbicacionDTO {
    /**
     * Representa el id de una ubicacion.
     */
    private Long id;
    /**
     * Representa la latitud de una ubicacion.
     */
    private Double latitud;
    /**
     * Representa la longitud de una ubicacion.
     */
    private Long longitud;
    /**
     * Representa la direccion de una ubicacion.
     */
    private String direccion;

    /**
     * Contructor vacio.
     */
    public UbicacionDTO() {
        //Vacio por defecto        
    }

    /**
     * Contructor original
     * @param entity 
     */
    public UbicacionDTO(UbicacionEntity entity) {
        this.id = entity.getId();
        this.direccion = entity.getDireccion();
        this.longitud = entity.getLongitud();
        this.latitud = entity.getLatitud();
    }

    /**
     * Retorna el id de la ubicacion.
     * @return 
     */
    public Long getId() {
        return id;
    }
    /**
     * Retorna la latitud de la ubicacion.
     * @return 
     */
    public Double getLatitud() {
        return latitud;
    }
    /**
     * Retorna la longitud de la ubicacion
     * @return 
     */
     public Long getLongitud() {
        return longitud;
    }
     /**
     *Retorna la direccion de una ubicacion
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }
     /**
      * Modifica el id de una ubicacion
      * @param id 
      */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Modifica la latitud de una ubicacion
     * @param latitud 
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    /**
     * Modifica la longitud de una ubicacion
     * @param longitud 
     */
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }
    /**
     * Modifica la direccion de una ubicacion
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public UbicacionEntity toEntity() {
        UbicacionEntity entity = new UbicacionEntity();
        entity.setId(this.id);
        entity.setDireccion(this.direccion);
        entity.setLatitud(this.latitud);
        entity.setLongitud(longitud);
        return entity;
    }
}
