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
 *¨Parte que se encarga de registar los servicios que pide un usuario.
 * @author ws.duarte
 */
@Entity
public class DetalleServicioEntity implements Serializable
{
    /**
     * Identificador del detalle del servicio.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Cantidad de servicios pedidos.
     */
    private Integer cantidad;
    
    /**
     * Total generado por la prestación del servicio.
     */
    private Double subTotal;
    
    /**
     * Relación con factura.
     */
    @PodamExclude
    @ManyToOne
    private FacturaEntity factura;

    /**
     * Retorna el identificador del detalle del servicio.
     * @return Identificador del detalle del servicio.
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el identificador del detalle del servicio.
     * @param id Nuevo identificador del servicio.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna la cantidad de servicios pedidos.
     * @return Cantidad de servicios pedidos.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Cambia la cantidad de servicios pedidos.
     * @param cantidad Nueva cantidad de servicios pedidos.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Retorna el total generado por el servicio.
     * @return Total generado por el servicio.
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * Cambia el total generado por el servicio.
     * @param subTotal Nuevo total genreado por el sevicio.
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
     * Determina si dos detalles de servicio son  iguales.
     * @param obj Detalle de servicio a comparar.
     * @return True si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DetalleServicioEntity && this.id != null && ((DetalleServicioEntity)obj).getId() != null) return this.id.equals(((DetalleServicioEntity)obj).getId());
        return super.equals(obj); 
    }

    /**
     * Retorna el código hash del detalle de servicio.
     * @return Código hash del detalle de servicio.
     */
    @Override
    public int hashCode() {
        if(this.id != null) return this.id.hashCode();
        return super.hashCode();
    }
}
