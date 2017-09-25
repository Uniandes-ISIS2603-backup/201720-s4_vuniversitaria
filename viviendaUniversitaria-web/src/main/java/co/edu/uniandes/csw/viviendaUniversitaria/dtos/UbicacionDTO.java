/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author c.santacruza
 */

public class UbicacionDTO {
    private Long id;
    private Long latitud;
    private Long altitud;
    private String direccion;
    
    /**
     * Relación con el hospedaje.
     */
    @PodamExclude
    @OneToOne(mappedBy = "ubicacion", orphanRemoval = true)
    private HospedajeEntity  hospedaje;
 /**
     * Relación con LugaresInteres
     */
    @PodamExclude
    @OneToOne(mappedBy = "ubicacion", orphanRemoval = true)
    private LugaresInteresEntity lugarInteres;
/**
     * Relación con Universidad.
     */
    @PodamExclude
    @OneToOne(mappedBy = "ubicacion", orphanRemoval = true)
    private UniversidadEntity  universidad;

    public HospedajeEntity getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }

    public LugaresInteresEntity getLugarInteres() {
        return lugarInteres;
    }

    public void setLugarInteres(LugaresInteresEntity lugarInteres) {
        this.lugarInteres = lugarInteres;
    }

    public UniversidadEntity getUniversidad() {
        return universidad;
    }

    public void setUniversidad(UniversidadEntity universidad) {
        this.universidad = universidad;
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
    
    
    public UbicacionDTO(){
        
    }
    public UbicacionDTO(UbicacionEntity entity){
        this.id = entity.getId();
        this.direccion = entity.getDireccion();
        this.altitud = entity.getAltitud();
        this.latitud = entity.getLatitud();
    }
      /**
     * Convertir DTO a Entity
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
