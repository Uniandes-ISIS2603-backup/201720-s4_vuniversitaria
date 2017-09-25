/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;

/**
 *
 * @author c.santacruza
 */
public class UniversidadDetailDTO extends UniversidadDTO{
     public UniversidadDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public UniversidadDetailDTO(UniversidadEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public UniversidadEntity toEntity() {
        UniversidadEntity ubi = super.toEntity();
        return ubi;
    }
}
