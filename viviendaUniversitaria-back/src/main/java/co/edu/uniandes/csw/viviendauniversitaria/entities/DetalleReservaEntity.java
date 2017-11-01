package co.edu.uniandes.csw.viviendauniversitaria.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela una parte de la factura. ¨Parte que se encarga de regstar
 * los costos generados por el arriendo.
 *
 * @author ws.duarte
 */
@Entity
public class DetalleReservaEntity extends BaseEntity {

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
     * Retorna el total generado por el detalle de reserva.
     *
     * @return Total generado por el detalle de reserva.
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * Cambia el total generado por la reserva.
     *
     * @param subTotal Nuevo total del detalle de reserva.
     */
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Retorna la relación con factura.
     *
     * @return Relación con factura.
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * Cambia la relacíon con factura.
     *
     * @param factura Nueva relación con factura.
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     * Retorna la relacion con reserva.
     *
     * @return Relacion con reserva.
     */
    public ReservaEntity getReserva() {
        return reserva;
    }

    /**
     * Cambia la relacion con reserva.
     *
     * @param reserva Nueva relacion con reserva.
     */
    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    /**
     * Determina si dos detalles de reserva son iguales.
     *
     * @param obj Detalle de reserva a comparar.
     * @return True si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DetalleReservaEntity) {
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.subTotal);
        return hash;
    }

}
