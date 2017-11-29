/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
import java.util.List;

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
    private LugaresInteresDTO lugarInteres;
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
        this.lugarInteres = new LugaresInteresDTO(entity.getLugarInteres());
    }

    public Long getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(Long idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public LugaresInteresDTO getIdLugarInteres() {
        return lugarInteres;
    }

    public void setIdLugarInteres(LugaresInteresDTO idLugarInteres) {
        this.lugarInteres = idLugarInteres;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
    
    
}
