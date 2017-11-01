/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;

/**
 *
 * @author ws.duarte
 */
public class HospedajeLugarDTO 
{
    
    private Long id;
    
    /**
     * Distancia entre el hospedaje y el lugar.
     */
    private Long distancia;

    public HospedajeLugarDTO() {
        //Constructor por defecto
    }
    
    public HospedajeLugarDTO(HospedajeLugarEntity entidad) {
        this.distancia = entidad.getDistancia();
        this.id = entidad.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDistancia() {
        return distancia;
    }

    public void setDistancia(Long distancia) {
        this.distancia = distancia;
    }
    
    
    
    public HospedajeLugarEntity toEntity()
    {
        HospedajeLugarEntity ret = new HospedajeLugarEntity();
        ret.setId(id);
        ret.setDistancia(distancia);
        return ret;
    }
    
}
