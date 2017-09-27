/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a.eslava
 */
public class OrigenDetailDTO extends OrigenDTO{
    
    private List<EstudianteDTO> estudiantes;
    
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
        if (entity.getEstudiante() != null) {
            estudiantes=new ArrayList<>();
            for(EstudianteEntity ent:entity.getEstudiante()){
                estudiantes.add(new EstudianteDTO(ent));
            }
        }
    }

    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }

    
}
