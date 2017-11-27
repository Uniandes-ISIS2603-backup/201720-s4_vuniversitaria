/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;

/**
 *
 * @author jc.sanguino10
 */
public class HospedajeLugarInteresDTO {
    
    /**
     * 
     */
    private Long idHospedaje;
    /**
     * 
     */
    private Long idLugarInteres;
    /**
     * 
     */
    private Double distancia;
    
    public HospedajeLugarInteresDTO ()
    {
        //constructor vacio por default
    }
    
    public HospedajeLugarInteresDTO (HospedajeLugarEntity entity)
    {
        this.distancia = entity.getDistancia();
        this.idHospedaje= entity.getHospedaje().getId();
        this.idLugarInteres = entity.getLugarInteres().getId();
    }

    public Long getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(Long idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public Long getIdLugarInteres() {
        return idLugarInteres;
    }

    public void setIdLugarInteres(Long idLugarInteres) {
        this.idLugarInteres = idLugarInteres;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
    
    
}
