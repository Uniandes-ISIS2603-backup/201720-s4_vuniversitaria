/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;

/**
 *
 * @author a.eslava
 */
public class OrigenDetailDTO extends OrigenDTO{
    
    private EstudianteDTO estudiante;
    
      /**
     * Constructor por defecto
     */
    public OrigenDetailDTO() {
        //Vacio por default
    }

    
        /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public OrigenDetailDTO(OrigenEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getEstudiante()!=null) {
                estudiante = new EstudianteDTO(entity.getEstudiante());
            }
        }else {
            entity.setEstudiante(null);
        }
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }
    
    
}
