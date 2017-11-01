/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;

/**
 *
 * @author kk.penaranda
 */

public class CalificacionDetailDTO extends CalificacionDTO{
    
    private HospedajeDTO hospedaje;
    
    
    private EstudianteDTO estudiante;
    /**
     * Constructor por defecto
     */
    public CalificacionDetailDTO() {
        super();
    }
    
   
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public CalificacionDetailDTO(CalificacionEntity entity) {
        super(entity);
        if(entity.getHospedaje()!= null){
            this.hospedaje = new HospedajeDTO(entity.getHospedaje());
        }
        else {
            entity.setHospedaje(null);
        }  
        if(entity.getEstudiante()!= null){
            this.estudiante = new EstudianteDTO(entity.getEstudiante());
        }
        else {
            entity.setEstudiante(null);
        }  
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public CalificacionEntity toEntity() {
        CalificacionEntity calificacionEntity = super.toEntity();
        if (this.getHospedaje() != null) {
            calificacionEntity.setHospedaje(this.getHospedaje().toEntity());
        }
        return calificacionEntity;
    }
    
    public HospedajeDTO getHospedaje(){
        return this.hospedaje;
    }
    
    public void setHospedaje(HospedajeDTO hospedaje){
        this.hospedaje= hospedaje;
    }
    
    public EstudianteDTO getEstudiante(){
        return this.estudiante;
    }
    
    public void setEstudiante(EstudianteDTO estudianteDTO){
        this.estudiante= estudianteDTO;
    }
    
}
