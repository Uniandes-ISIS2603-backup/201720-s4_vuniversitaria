/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;

/**
 *
 * @author ws.duarte
 */
public class DetalleServicioDTO 
{
    private Long id;
    private Integer cantidad;
    private Double subTotal;

    public DetalleServicioDTO() {
        //Constructor por defecto
    }
    
    public DetalleServicioDTO(DetalleServicioEntity entidad) 
    {
        this.cantidad = entidad.getCantidad();
        this.id = entidad.getId();
        this.subTotal = entidad.getSubTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
    public DetalleServicioEntity toEntity()
    {
        DetalleServicioEntity ret = new DetalleServicioEntity();
        ret.setCantidad(cantidad);
        ret.setId(id);
        ret.setSubTotal(subTotal);
        return ret;
    }
    
    
    
}
