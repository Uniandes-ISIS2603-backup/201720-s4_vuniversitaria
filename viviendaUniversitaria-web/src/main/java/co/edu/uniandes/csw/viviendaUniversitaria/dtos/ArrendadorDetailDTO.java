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
public class ArrendadorDetailDTO extends ArrendadorDTO{
    
    
    /**
     * Constructor por defecto
     */
    public ArrendadorDetailDTO() {
        //Vacío por default
    }
    
   
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ArrendadorDetailDTO(ArrendadorEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ArrendadorEntity toEntity() {
        return super.toEntity();       
    }
}
