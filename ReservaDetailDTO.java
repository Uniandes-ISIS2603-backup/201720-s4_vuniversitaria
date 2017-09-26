/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleReservaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReservaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author je.bejarano10
 */
public class ReservaDetailDTO extends ReservaDTO{
    
    private List<DetalleReservaDTO> detalleReserva;

    public List<DetalleReservaDTO> getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(List<DetalleReservaDTO> detalleReserva) {
        this.detalleReserva = detalleReserva;
    }
    private HospedajeDTO hospedaje;
    
    private EstudianteDTO estudiante;

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    

   

    public HospedajeDTO getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(HospedajeDTO hospedaje) {
        this.hospedaje = hospedaje;
    }
    
    public ReservaDetailDTO(){
        super();
    }
     public ReservaDetailDTO(ReservaEntity reservaEntity){
       super(reservaEntity);
        if(reservaEntity!= null){
            if(reservaEntity.getEstudiante()!=null){
           estudiante= new EstudianteDTO(reservaEntity.getEstudiante());
            }
            else{
                reservaEntity.setEstudiante(null);
            }
            if(reservaEntity.getHospedaje()!=null){
           hospedaje=new HospedajeDTO(reservaEntity.getHospedaje());
            }
            else{
            reservaEntity.setHospedaje(null);
        }
            if (detalleReserva!=null){
                detalleReserva = new ArrayList<>();
                for(DetalleReservaEntity entityDetalleReserva :reservaEntity.getDetalleReserva()){
                    detalleReserva.add(new DetalleReservaDTO(entityDetalleReserva));
                }
            }
        
           
        }
    }
     @Override
     public ReservaEntity toEntity(){
         ReservaEntity reservaEntity = super.toEntity();
         if(estudiante!=null){
             reservaEntity.setEstudiante(estudiante.toEntity());
         }
         if(hospedaje!=null){
             reservaEntity.setHospedaje(hospedaje.toEntity());
         }
         if(detalleReserva!=null){
             List<DetalleReservaEntity> detalleReservaEntity = new ArrayList<>();
            for (DetalleReservaDTO dtoDetalleReserva : detalleReserva) {
                detalleReservaEntity.add(dtoDetalleReserva.toEntity());
            }
            reservaEntity.setDetalleReserva(detalleReservaEntity);
         }
         return reservaEntity;
     }
    
    
}
