/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.viviendaUniversitaria.entities;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ISIS2603
 */
@Entity
public class EstudianteEntity extends BaseEntity implements Serializable {
    
    int cedula;
    
    @PodamExclude
    @OneToOne(mappedBy = "estudiante", fetch=FetchType.EAGER)
    private OrigenEntity origen;
    
    @PodamExclude
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaEntity> facturas;
    
    @PodamExclude
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaEntity> reservas;
    
    @PodamExclude
    @OneToMany(mappedBy = "estudiante")
    private List<FacturaEntity> calificaciones;
    
    public List<FacturaEntity> getReservas() {
        return reservas;
    }

//    @PodamExclude
//    @ManyToOne
//    HospedajeEntity hospedaje;
    public void setReservas(List<FacturaEntity> reservas) {
        this.reservas = reservas;
    }

    public List<FacturaEntity> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<FacturaEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public OrigenEntity getOrigen() {
        return origen;
    }

    public void setOrigen(OrigenEntity origen) {
        this.origen = origen;
    }

    public List<FacturaEntity> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaEntity> facturas) {
        this.facturas = facturas;
    }
    
    
}
