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
    private Long id;
    private Long cedula;  
    private String nombre;
    
    
    public EstudianteDTO(){
        //Constructor por defecto        
    }
    
    public EstudianteDTO(EstudianteEntity estudiante) {
        if (estudiante != null) {
            this.nombre = estudiante.getNombre();
            this.cedula = estudiante.getCedula();
            this.id = estudiante.getId();
        }
    }
    
     public EstudianteEntity toEntity() {

        EstudianteEntity estu = new EstudianteEntity();
        estu.setNombre(this.nombre);
        estu.setCedula(this.cedula);
     
        return estu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
