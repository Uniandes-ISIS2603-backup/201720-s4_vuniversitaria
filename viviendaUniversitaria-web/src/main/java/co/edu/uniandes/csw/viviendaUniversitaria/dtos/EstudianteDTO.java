/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;

/**
 *
 * @author a.eslava
 */
public class EstudianteDTO {
    private Long cedula;  
    private String nombre;
    
    
    //para crear solo el dto¿?
    public EstudianteDTO(){
        
    }
    
    public EstudianteDTO(EstudianteEntity estudiante) {
        if (estudiante != null) {
            this.nombre = estudiante.getNombre();
            this.cedula = estudiante.getCedula();
            
        }
    }
    
     public EstudianteEntity toEntity() {

        EstudianteEntity estu = new EstudianteEntity();
        estu.setNombre(this.nombre);
        estu.setCedula(this.cedula);
     
        return estu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
}
