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
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ISIS2603
 */
@Entity
public class EstudianteEntity  implements Serializable //extends BaseEntity
{

    @Id
    private Long cedula;
    
    private String nombre;
    
    @PodamExclude
    @ManyToOne
    private OrigenEntity origen;
    
    @PodamExclude
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaEntity> facturas;
    
    @PodamExclude
    @OneToOne(mappedBy = "estudiante", fetch=FetchType.LAZY)
    private ReservaEntity reserva;
    
    @PodamExclude
    @OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = true ,mappedBy = "estudiante", fetch=FetchType.LAZY)
    private List<CalificacionEntity> calificaciones;
    
    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public List<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
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

    
    @Override
    public boolean equals(Object obj) {
        if(obj != null ||this.getClass()!= obj.getClass()){
            return false;
        }
        if (this.getCedula() != null && ((EstudianteEntity) obj).getCedula()!= null) {
            return this.getCedula().equals(((EstudianteEntity) obj).getCedula());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.cedula);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    
    
}
