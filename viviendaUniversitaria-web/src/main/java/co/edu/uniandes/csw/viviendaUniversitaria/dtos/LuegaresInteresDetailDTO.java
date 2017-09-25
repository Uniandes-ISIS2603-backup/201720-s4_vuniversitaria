/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;

/**
 *
 * @author jc.sanguino10
 */
public class LuegaresInteresDetailDTO extends LugaresInteresDTO {
    public LuegaresInteresDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public LuegaresInteresDetailDTO(LugaresInteresEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public LugaresInteresEntity toEntity() {
        LugaresInteresEntity lugarInteres = super.toEntity();
        return lugarInteres;
    }
}
