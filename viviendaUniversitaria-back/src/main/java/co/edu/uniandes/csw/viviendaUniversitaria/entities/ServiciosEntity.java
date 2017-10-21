/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela un servicio prestado por un hospedaje
 */
@Entity
public class ServiciosEntity extends BaseEntity implements Serializable {

    /**
     * Asociacion con detalle de facuctura
     */
    @PodamExclude
    @OneToMany(mappedBy = "servicio", fetch = FetchType.LAZY)
    private List<DetalleServicioEntity> detalleServicio;
    
    @PodamExclude
    @ManyToOne
    private HospedajeEntity hospedaje;
    /**
     * Descripcion del servicio prestado
     */
    private String descripcion;
    /**
     * Costo por adquirir el servicio, 0 en caso de venir incluido con el
     * hospedaje
     */
    private double costo;
    
    private String name;


    public List<DetalleServicioEntity> getDetalleServicio() {
        return detalleServicio;
    }

    //--------------------------------------------//
    //--------------GETTERS AND SETTERS-----------//
    //--------------------------------------------//
    public void setDetalleServicio(List<DetalleServicioEntity> detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    public HospedajeEntity getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ServiciosEntity) return super.equals(obj);
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.costo) ^ (Double.doubleToLongBits(this.costo) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

}
