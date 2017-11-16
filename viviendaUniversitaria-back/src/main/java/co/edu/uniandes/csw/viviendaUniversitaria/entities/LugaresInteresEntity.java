/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
    /**
     * Asociacion con hospedajeLugares
     */
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
    /**
     * Nombre del lugar de interes
     */
    private String name;
    //--------------------------------------------//
    //--------------GETTERS AND SETTERS-----------//
    //--------------------------------------------//

    /**
     * Retorna los hospedajes cercanos
     *
     * @return HospedajeLugares
     */
    public List<HospedajeLugarEntity> getHospedajesLugares() {
        return hospedajesLugares;
    }

    /**
     * Cambia los hospedajes cercanos
     *
     * @param hospedajesLugares
     */
    public void setHospedajesLugares(List<HospedajeLugarEntity> hospedajesLugares) {
        this.hospedajesLugares = hospedajesLugares;
    }

    /**
     * Retorna la ubicacion de un lugar de interes
     *
     * @return
     */
    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    /**
     * Cambia la ubicacion de un lugar de interes
     *
     * @param ubicacion
     */
    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Retorna la descripcion de un lugar de Interes
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripcion del lugar de interes
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna la distancia a un lugar de interes
     *
     * @return distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * Cambia la distancia a un lugar de interes
     *
     * @param distancia
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * Retorna la ruta de imagen del lugar de interes
     *
     * @return rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * Cambia la ruta de imagen de un lugar de interes
     *
     * @param rutaImagen
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * Retorna el nombre de un lugar de interes
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre de un lugar de interes
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LugaresInteresEntity) {
            return super.equals(obj);
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.rutaImagen);
        return hash;
    }
}
