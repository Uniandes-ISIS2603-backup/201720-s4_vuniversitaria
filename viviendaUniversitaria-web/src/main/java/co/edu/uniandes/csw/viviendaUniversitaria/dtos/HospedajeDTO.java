/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;

/**
 *
 * @author ws.duarte
 */
public class HospedajeDTO 
{
    private Long id;
    
    /**
     * Tipo de arrendamiento del hospedaje.
     */
    private String tipoArrendamiento;
    
    /**
     * Descripción del hospadaje.
     */
    private String descripcion;
    
    /**
     * Valoración total del hospadaje.
     */
    private Double valoracion;
    
    private Integer cantidadVotaciones;
    
    public HospedajeDTO() {}
    
    public HospedajeDTO(HospedajeEntity entidad) 
    {
        this.id = entidad.getId();
        this.descripcion = entidad.getDescripcion();
        this.tipoArrendamiento = entidad.getTipoArrendamiento();
        this.valoracion = entidad.getValoracion();
        this.cantidadVotaciones = entidad.getCantidadVotaciones();
    }
    
    public HospedajeEntity toEntity()
    {
        HospedajeEntity ret = new HospedajeEntity();
        ret.setDescripcion(descripcion);
        ret.setId(id);
        ret.setValoracion(valoracion);
        ret.setTipoArrendamiento(tipoArrendamiento);
        ret.setCantidadVotaciones(cantidadVotaciones);
        return ret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoArrendamiento() {
        return tipoArrendamiento;
    }

    public void setTipoArrendamiento(String tipoArrendamiento) {
        this.tipoArrendamiento = tipoArrendamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValoracion() {
        return valoracion;
    }

    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getCantidadVotaciones() {
        return cantidadVotaciones;
    }

    public void setCantidadVotaciones(Integer cantidadVotaciones) {
        this.cantidadVotaciones = cantidadVotaciones;
    }
    
    
    
}
