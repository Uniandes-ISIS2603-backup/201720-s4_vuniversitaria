/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleReservaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author je.bejarano10
 */
public class FacturaDetailDTO extends FacturaDTO {

    private EstudianteDTO estudiante;

    private HospedajeDTO hospedaje;

    private List<DetalleServicioDetailDTO> detalleServicio;

    private List<DetalleReservaDTO> detalleReserva;

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public List<DetalleServicioDetailDTO> getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(List<DetalleServicioDetailDTO> detalleServicio) {
        this.detalleServicio = detalleServicio;
    }


    public List<DetalleReservaDTO> getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(List<DetalleReservaDTO> detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    public HospedajeDTO getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(HospedajeDTO hospedaje) {
        this.hospedaje = hospedaje;
    }

    public FacturaDetailDTO() {
        super();
    }
    public FacturaDetailDTO(FacturaEntity facturaEntity) {
        super(facturaEntity);
        if (facturaEntity != null) {
            if (facturaEntity.getEstudiante() != null) {
                estudiante = new EstudianteDTO(facturaEntity.getEstudiante());
            } else {
                estudiante = null;
            }
            if (facturaEntity.getHospedaje() != null) {
                hospedaje = new HospedajeDTO(facturaEntity.getHospedaje());
            } else {
                hospedaje = null;
            }
            detalleServicio = new ArrayList<>();
            for (DetalleServicioEntity entityDetalleServicio : facturaEntity.getDetalleServicio()) {
                detalleServicio.add(new DetalleServicioDetailDTO(entityDetalleServicio));
            }
            detalleReserva = new ArrayList<>();
            for (DetalleReservaEntity entityDetalleReserva : facturaEntity.getDetallesReserva()) {
                detalleReserva.add(new DetalleReservaDTO(entityDetalleReserva));
            }

        }
    }

    @Override
    public FacturaEntity toEntity() {
        FacturaEntity entity = super.toEntity();
        if (estudiante != null) {
            entity.setEstudiante(estudiante.toEntity());
        }
        if (hospedaje != null) {
            entity.setHospedaje(hospedaje.toEntity());
        }
        if( detalleServicio != null){
            List<DetalleServicioEntity> detalleServicioEntity = new ArrayList<>();
            for (DetalleServicioDTO dtoDetalleServicio : detalleServicio) {
                detalleServicioEntity.add(dtoDetalleServicio.toEntity());
            }
            entity.setDetalleServicio(detalleServicioEntity);
        }
        else
        {
            detalleServicio = new ArrayList<>();
        }
        if (detalleReserva != null) {
            List<DetalleReservaEntity> detalleReservaEntity = new ArrayList<>();
            for (DetalleReservaDTO dtoDetalleReserva : detalleReserva) {
                detalleReservaEntity.add(dtoDetalleReserva.toEntity());
            }
            entity.setDetallesReserva(detalleReservaEntity);
        }
        else
        {
            detalleReserva = new ArrayList<>();
        }
        
        return entity;
    }

}
