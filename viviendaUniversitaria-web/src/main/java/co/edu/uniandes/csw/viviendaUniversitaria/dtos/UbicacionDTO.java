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

    private Long id;
    private Long latitud;
    private Long altitud;
    private String direccion;

    public UbicacionDTO() {
        //Vacio por defecto        
    }

    public UbicacionDTO(UbicacionEntity entity) {
        this.id = entity.getId();
        this.direccion = entity.getDireccion();
        this.altitud = entity.getAltitud();
        this.latitud = entity.getLatitud();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLatitud() {
        return latitud;
    }

    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    public Long getAltitud() {
        return altitud;
    }

    public void setAltitud(Long altitud) {
        this.altitud = altitud;
    }

    public String getDireccion() {
        return direccion;
    }

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
        entity.setAltitud(altitud);
        return entity;
    }
}