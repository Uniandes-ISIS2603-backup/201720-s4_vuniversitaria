/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;

/**
 *
 * @author a.eslava
 */
public class OrigenDTO {

    private Long id;
    private String name;
    
    
     /**
     * Constructor por defecto
     */
    public OrigenDTO() {
    }
     /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param origen: Es la entidad que se va a convertir a DTO 
     */
    public OrigenDTO(OrigenEntity origen) {
            this.id = origen.getId();
            this.name = origen.getName();
    }
    
     public OrigenEntity toEntity() {

        OrigenEntity origen = new OrigenEntity();
        origen.setId(this.id);
        origen.setName(this.name);
     
        return origen;
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
}
