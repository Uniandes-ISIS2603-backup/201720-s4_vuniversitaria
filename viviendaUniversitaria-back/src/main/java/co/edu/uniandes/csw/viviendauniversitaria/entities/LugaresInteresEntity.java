/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendauniversitaria.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * La clase modela los lugares que se encuentran alrededor de un hospedaje y le
 * podrian llamar la atencion al arrendatario
 *
 * @author Juan Camilo Sanguino
 */
@Entity
public class LugaresInteresEntity extends BaseEntity implements Serializable {

    /**
     * Atributo donde se describe la ubicacion de un lugar de interes
     */
    @PodamExclude
    @OneToOne
    private UbicacionEntity ubicacion;
    
    @PodamExclude
    @OneToMany(mappedBy = "lugarInteres", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospedajeLugarEntity> hospedajesLugares;
    /**
     * Atributo que modela algunos comentarios del propietario sobre su
     * hospedaje
     */
    private String descripcion;
    /**
     * Modela la distancia desde el lugar de interes al hospedaje
     */
    private double distancia;
    /**
     * Imagen del lugar de interes
     */
    private String rutaImagen;
    
    private String name;
    //--------------------------------------------//
    //--------------GETTERS AND SETTERS-----------//
    //--------------------------------------------//

    public List<HospedajeLugarEntity> getHospedajesLugares() {
        return hospedajesLugares;
    }

    public void setHospedajesLugares(List<HospedajeLugarEntity> hospedajesLugares) {
        this.hospedajesLugares = hospedajesLugares;
    }

    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    

}
