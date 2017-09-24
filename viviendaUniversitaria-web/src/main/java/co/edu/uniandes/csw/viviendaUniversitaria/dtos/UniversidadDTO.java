/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

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
    
    public UniversidadDTO(){
        
    }
    public UniversidadDTO(UniversidadEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
       
    }
      /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public UniversidadEntity toEntity() {
        UniversidadEntity entity = new UniversidadEntity();
        entity.setId(this.id);
        entity.setName(this.name);
       
        return entity;
    }
}
