/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;

/**
 *
 * @author jc.sanguino10
 */
public class DetalleServicioDetailDTO extends DetalleServicioDTO{
    
    public ServiciosDTO servicio;
    
    public DetalleServicioDetailDTO (DetalleServicioEntity entity)
    {
        super(entity);
        if(entity.getServicio()!=null){
        servicio = new ServiciosDTO(entity.getServicio());
        }
    }
    

    public ServiciosDTO getServicio() {
        return servicio;
    }

    public void setServicio(ServiciosDTO servicio) {
        this.servicio = servicio;
    }
    
    @Override
    public DetalleServicioEntity toEntity()
    {
        DetalleServicioEntity entity = super.toEntity();
        if(servicio!=null)
        {
        entity.setServicio(servicio.toEntity());
        }
        return entity;
    }
    
    
}
