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
public class LugaresInteresDetailDTO extends LugaresInteresDTO {

    /**
     * Atributo de la relacion con UbicacionDTO
     */
    private UbicacionDTO ubicacion;

    public LugaresInteresDetailDTO() {
        //Constructor por defecto
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public LugaresInteresDetailDTO(LugaresInteresEntity entity) {
        super(entity);
        if(entity.getUbicacion()!=null)
        {
        ubicacion = new UbicacionDTO(entity.getUbicacion());
        }
        else
        {
            ubicacion = new UbicacionDTO();
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return
     */
    @Override
    public LugaresInteresEntity toEntity() {
        LugaresInteresEntity rta = super.toEntity();
        rta.setUbicacion(ubicacion.toEntity());
        return rta;

    }

    /**
     * Retorna la asociacion del dto con ubicacion dto
     * @return ubicacion
     */
    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }

    /**
     * Cambia la asociacion del dto con ubicacion dto
     * @param ubicacion 
     */
    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
