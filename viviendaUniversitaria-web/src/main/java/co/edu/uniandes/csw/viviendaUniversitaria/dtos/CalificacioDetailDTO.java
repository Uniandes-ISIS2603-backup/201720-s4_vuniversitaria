/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;

/**
 *
 * @author kk.penaranda
 */
public class CalificacioDetailDTO extends CalificacionDTO{
    /**
     * Constructor por defecto
     */
    public CalificacioDetailDTO() {
    }
    
   
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public CalificacioDetailDTO(CalificacionEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public CalificacionEntity toEntity() {
        CalificacionEntity arrendadorEntity = super.toEntity();
        return arrendadorEntity;
    }
    
}
