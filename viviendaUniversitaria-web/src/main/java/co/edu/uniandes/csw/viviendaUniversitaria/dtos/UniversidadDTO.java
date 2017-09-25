/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;

/**
 *
 * @author c.santacruza
 */
public class UniversidadDTO {
    
   // @PodamExclude
    //@OneToOne("Ubicacion")
    //private UbicacionEntity ubicacion;
    
    private Long id;
    private String name;
    
    public UniversidadDTO(){
        //Vacio por default
        
    }
    public UniversidadDTO(UniversidadEntity entity){
        this.id = entity.getId();
        this.name = entity.getNombre();
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
      /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public UniversidadEntity toEntity() {
        UniversidadEntity entity = new UniversidadEntity();
        entity.setId(this.id);
        entity.setNombre(this.name);
       
        return entity;
    }
}
