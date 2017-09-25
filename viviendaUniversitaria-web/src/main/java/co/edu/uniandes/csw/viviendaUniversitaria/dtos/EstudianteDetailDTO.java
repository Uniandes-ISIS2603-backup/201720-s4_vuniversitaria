/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a.eslava
 */
public class EstudianteDetailDTO extends EstudianteDTO {

    //relacion a un Origen
    private OrigenDTO origen;

    //relacion uno a muchos con calificacion
    private List<CalificacionDTO> calificaciones;

//    //relacion uno a muchos
//    private List<FacturaDTO> facturas;
//
//    //relacion a una reserva
//    private ReservaDTO reserva;

    public EstudianteDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public EstudianteDetailDTO(EstudianteEntity entity) {
        super(entity);
        if (entity.getOrigen() != null) {
            this.origen = new OrigenDTO(entity.getOrigen());
        } else {
            entity.setOrigen(null);
        }
//        if (entity.getFacturas() != null) {
//            facturas = new ArrayList<>();
//            for (FacturaEntity facEntity : entity.getFacturas()) {
//                facturas.add(new FacturaDTO(facEntity));
//            }
//        }
        if (entity.getCalificaciones() != null) {
            calificaciones = new ArrayList<>();
            for (CalificacionEntity cali : entity.getCalificaciones()) {
                calificaciones.add(new CalificacionDTO(cali));
            }
        }
//        if (entity.getReservas() != null) {
//            this.reserva = new ReservaDTO(entity.getReserva());
//        } else {
//            entity.setReserva(null);
//        }
    }

    public EstudianteEntity toEntity() {
        EstudianteEntity entity = super.toEntity();
        
        if (this.getOrigenDTO() != null) {
            entity.setOrigen(this.getOrigenDTO().toEntity());
        }
        if (this.getCalificacionesDTO() != null) {
            List<CalificacionEntity> calificacionEntity = new ArrayList<>();
            for (CalificacionDTO calificacionDTO : getCalificacionesDTO()) {
                calificacionEntity.add(calificacionDTO.toEntity());
            }
            entity.setCalificaciones(calificacionEntity);
        }
//        if (this.getFacturasDTO() != null) {
//            List<FacturaEntity> facturaEntity = new ArrayList<>();
//            for (FacturaDTO facturaDTO : getFacturasDTO()) {
//                facturaEntity.add(facturaDTO.toEntity());
//            }
//            entity.setFacturas(facturaEntity);
//        }
//        if (this.getReservaDTO() != null) {
//            entity.setReserva(this.getReservaDTO().toEntity());
//        }
        return null;
    }
    /**
     * 
     * @return origen
     */
    public OrigenDTO getOrigenDTO(){
        return origen;
    }
    /**
     * @param origen 
     */
    public void setOrigenDTO(OrigenDTO origen){
        this.origen=origen;
    }
    /**
     * 
     * @return la reserva
     */
//    public ReservaDTO getReservaDTO(){
//        return reserva;
//    }
    /**
     * s
     * @param reserva
     */
//    public void setReservaDTO(ReservaDTO reserva){
//        this.reserva=reserva;
//    }
    /**
     * @return la calificacion
     */
    public List<CalificacionDTO> getCalificacionesDTO() {
        return calificaciones;
    }

    /**
     * @param calificaciones
     */
    public void setCalificacionesDTO(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * @return una lista de facturas
     */
//    public List<FacturaDTO> getFacturasDTO() {
//        return facturas;
//    }

    /**
     * @param facturas
     */
//    public void setFacturasDTO(List<FacturaDTO> facturas) {
//        this.facturas = facturas;
//    }

    
}
