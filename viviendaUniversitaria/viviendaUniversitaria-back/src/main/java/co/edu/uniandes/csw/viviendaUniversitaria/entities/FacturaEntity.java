/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
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
    @OneToMany (mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true))
    private List<DetalleReservaEntity> detallesReserva;
    
    @PodamExclude
    @ManyToOne
    private HospedajeEntity hospedaje;
    
    @PodamExclude
    @OneToOne
    private EstudianteEntity estudiante;
    
    @OneToMany (mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true))
    private List<DetalleServicioEntity> listaServicios;

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
        this.fecha = fecha;
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
