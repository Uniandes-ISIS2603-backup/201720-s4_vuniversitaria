/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;

/**
 *
 * @author jc.sanguino10
 */
public class ServiciosDetailDTO extends ServiciosDTO {
    /**
     * Constructor por defecto
     */
    public ServiciosDetailDTO() {
        //Vacio por default
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ServiciosDetailDTO(ServiciosEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ServiciosEntity toEntity() {
        return super.toEntity();
    }
}
