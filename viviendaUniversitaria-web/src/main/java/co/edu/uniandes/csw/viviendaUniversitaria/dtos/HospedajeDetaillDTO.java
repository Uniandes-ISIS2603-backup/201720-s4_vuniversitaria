/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReglaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReservaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ws.duarte
 */
public class HospedajeDetaillDTO extends HospedajeDTO {

    private List<ReglaDTO> reglas;
    private List<ServiciosDTO> servicios;
    private List<HospedajeLugarDTO> hospedajeLugares;
    private List<FacturaDTO> facturas;
    private List<ReservaDTO> reservas;
    private List<CalificacionDTO> calificaciones;
    private ArrendadorDTO arrendador;
    private UbicacionDTO ubicacion;

    public HospedajeDetaillDTO() {
        super();
    }

    public HospedajeDetaillDTO(HospedajeEntity entidad) {
        super(entidad);
        if (entidad.getReglas() != null) {
            this.reglas = new ArrayList<>();
            for (ReglaEntity regla : entidad.getReglas()) {
                reglas.add(new ReglaDTO(regla));
            }
        }
        //else {entidad.setReglas(null);}
        if (entidad.getServicios() != null) {
            this.servicios = new ArrayList<>();
            for (ServiciosEntity servicio : entidad.getServicios()) {
                servicios.add(new ServiciosDTO(servicio));
            }
        }
        //else {entidad.setServicios(null);}
        if (entidad.getHospedajesLugares() != null) {
            this.hospedajeLugares = new ArrayList<>();
            for (HospedajeLugarEntity hospedajeL : entidad.getHospedajesLugares()) {
                hospedajeLugares.add(new HospedajeLugarDTO(hospedajeL));
            }
        }
        //else {entidad.setHospedajesLugares(null);}
        if (entidad.getCalificaciones() != null) {
            this.calificaciones = new ArrayList<>();
            for (CalificacionEntity calificacion : entidad.getCalificaciones()) {
                calificaciones.add(new CalificacionDTO(calificacion));
            }
        }
        if (entidad.getFacturas() != null) {
            this.facturas = new ArrayList<>();
            for (FacturaEntity calificacion : entidad.getFacturas()) {
                facturas.add(new FacturaDTO(calificacion));
            }
        }
        if (entidad.getReservas() != null) {
            this.reservas = new ArrayList<>();
            for (ReservaEntity calificacion : entidad.getReservas()) {
                reservas.add(new ReservaDTO(calificacion));
            }
        }
        //else {entidad.setCalificaciones(null);}
        if (entidad.getArrendador() != null) {
            this.arrendador = new ArrendadorDTO(entidad.getArrendador());
        }
        //else entidad.setArrendador(null);
        if (entidad.getUbicacion() != null) {
            this.ubicacion = new UbicacionDTO(entidad.getUbicacion());
        }

    }

    @Override
    public HospedajeEntity toEntity() {
        HospedajeEntity ret = super.toEntity();
        if (this.arrendador != null) {
            ret.setArrendador(arrendador.toEntity());
        }
        if (this.reglas != null) {
            List<ReglaEntity> add = new ArrayList<>();
            for (ReglaDTO re : reglas) {
                add.add(re.toEntity());
            }
            ret.setReglas(add);
        }
        if (this.servicios != null) {
            List<ServiciosEntity> add = new ArrayList<>();
            for (ServiciosDTO se : servicios) {
                add.add(se.toEntity());
            }
            ret.setServicios(add);
        }
        if (hospedajeLugares != null) {
            List<HospedajeLugarEntity> add = new ArrayList<>();
            for (HospedajeLugarDTO ho : hospedajeLugares) {
                add.add(ho.toEntity());
            }
            ret.setHospedajesLugares(add);
        }
        if (calificaciones != null) {
            List<CalificacionEntity> add = new ArrayList<>();
            for (CalificacionDTO ca : calificaciones) {
                add.add(ca.toEntity());
            }
            ret.setCalificaciones(add);
        }
        if (calificaciones != null) {
            List<CalificacionEntity> add = new ArrayList<>();
            for (CalificacionDTO ca : calificaciones) {
                add.add(ca.toEntity());
            }
            ret.setCalificaciones(add);
        }
        if (facturas != null) {
            List<FacturaEntity> add = new ArrayList<>();
            for (FacturaDTO ca : facturas) {
                add.add(ca.toEntity());
            }
            ret.setFacturas(add);
        }
        if (reservas != null) {
            List<ReservaEntity> add = new ArrayList<>();
            for (ReservaDTO ca : reservas) {
                add.add(ca.toEntity());
            }
            ret.setReservas(add);
        }
        if (ubicacion != null) {
            ret.setUbicacion(ubicacion.toEntity());
        }
        return ret;
    }

    public List<ReglaDTO> getReglas() {
        return reglas;
    }

    public void setReglas(List<ReglaDTO> reglas) {
        this.reglas = reglas;
    }

    public List<ServiciosDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServiciosDTO> servicios) {
        this.servicios = servicios;
    }

    public List<HospedajeLugarDTO> getHospedajeLugares() {
        return hospedajeLugares;
    }

    public void setHospedajeLugares(List<HospedajeLugarDTO> hospedajeLugares) {
        this.hospedajeLugares = hospedajeLugares;
    }

    public List<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public ArrendadorDTO getArrendador() {
        return arrendador;
    }

    public void setArrendador(ArrendadorDTO arrendador) {
        this.arrendador = arrendador;
    }

    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<FacturaDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaDTO> facturas) {
        this.facturas = facturas;
    }

    public List<ReservaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }

}
