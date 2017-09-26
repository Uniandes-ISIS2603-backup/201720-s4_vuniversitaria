/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReglaEntity;

/**
 *
 * @author ws.duarte
 */
public class ReglaDTO 
{
    private Long id;
    private String regla;

    public ReglaDTO() {
    }
    
    public ReglaDTO(ReglaEntity regla) {
        this.id = regla.getId();
        this.regla = regla.getRegla();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegla() {
        return regla;
    }

    public void setRegla(String regla) {
        this.regla = regla;
    }
    
    
    
    public ReglaEntity toEntity()
    {
        ReglaEntity ret = new ReglaEntity();
        ret.setId(id);;
        ret.setRegla(regla);
        return ret;
    }
    
}
