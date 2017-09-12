/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author je.bejarano10
 */
@Entity
public class ReservaEntity implements Serializable {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCedulaHuesped() {
        return cedulaHuesped;
    }

    public void setCedulaHuesped(int cedulaHuesped) {
        this.cedulaHuesped = cedulaHuesped;
    }

    public int getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(int idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
       
       private int cedulaHuesped;
       private int idHospedaje;
       private Date fechaInicio;
       private Date fechaFin;
}
