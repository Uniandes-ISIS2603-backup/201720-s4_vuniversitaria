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
public class UbicacionDetailDTO extends UbicacionDTO {
     /**
     * Constructor por defecto
     */
    public UbicacionDetailDTO() {
        //Vacio por default
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public UbicacionDetailDTO(UbicacionEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public UbicacionEntity toEntity() {
        return super.toEntity();
    }
}
