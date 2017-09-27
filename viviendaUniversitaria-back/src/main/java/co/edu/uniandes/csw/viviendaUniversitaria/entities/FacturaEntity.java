/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author je.bejarano10
 */
@Entity
public class FacturaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal (javax.persistence.TemporalType.DATE)
    private Date fecha;
    private double total;
    private double iva;
    
    @PodamExclude
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleReservaEntity> detallesReserva;
//    
    @PodamExclude
    @ManyToOne
    private HospedajeEntity hospedaje;
//    
    @PodamExclude
    @ManyToOne
    private EstudianteEntity estudiante;
    
    @PodamExclude
    @OneToMany (mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleServicioEntity> detalleServicio;

    public List<DetalleServicioEntity> getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(List<DetalleServicioEntity> detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    public List<DetalleReservaEntity> getDetallesReserva() {
        return detallesReserva;
    }

    public void setDetallesReserva(List<DetalleReservaEntity> detallesReserva) {
        this.detallesReserva = detallesReserva;
    }

    public HospedajeEntity getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }

    public EstudianteEntity getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteEntity estudiante) {
        this.estudiante = estudiante;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        date.format(fecha);
        this.fecha=fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
    
}
