package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela una parte de la factura.
 *¨Parte que se encarga de regstar los costos generados por el arriendo.
 * @author ws.duarte
 */
@Entity
public class DetalleReservaEntity implements Serializable
{
    /**
     * Identificador del detalle de reserva.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Total generado por la reserva.
     */
    private Double subTotal;
    
    /**
     * Relación con factura.
     */
    @PodamExclude
    @ManyToOne
    private FacturaEntity factura;
    
    /**
     * Relacion con reserva
     */
    @PodamExclude
    @ManyToOne
    private ReservaEntity reserva;

    /**
     * Retorna el identificador del detalle de reserva.
     * @return Identifiacdor del detalle de reserva.
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el identifiacdor del detalle de reserva.
     * @param id Nuevo identificador del detalle de reserva.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el total generado por el detalle de reserva.
     * @return Total generado por el detalle de reserva.
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * Cambia el total generado por la reserva.
     * @param subTotal Nuevo total del detalle de reserva.
     */
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    
    /**
     * Retorna la relación con factura.
     * @return Relación con factura.
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * Cambia la relacíon con factura.
     * @param factura Nueva relación con factura.
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     * Retorna la relacion con reserva.
     * @return Relacion con reserva.
     */
    public ReservaEntity getReserva() {
        return reserva;
    }

    /**
     * Cambia la relacion con reserva.
     * @param reserva Nueva relacion con reserva.
     */
    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }
    
    /**
     * Determina si dos detalles de reserva son  iguales.
     * @param obj Detalle de reserva a comparar.
     * @return True si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DetalleReservaEntity && this.id != null && ((DetalleReservaEntity)obj).getId() != null) return this.id.equals(((DetalleReservaEntity)obj).getId());
        return super.equals(obj); 
    }

    /**
     * Retorna el código hash del detalle de reserva.
     * @return Código hash del detalle de reserva.
     */
    @Override
    public int hashCode() {
        if(this.id != null) return this.id.hashCode();
        return super.hashCode(); 
    }
    
}
