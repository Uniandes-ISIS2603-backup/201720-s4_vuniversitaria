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
import javax.persistence.FetchType;
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
     * Asociacion con hospedajeLugares
     */
    @PodamExclude
    @OneToMany(mappedBy = "lugarInteres",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<HospedajeLugarEntity> hospedajeLugar;
    /**
     * Atributo donde se describe la ubicacion de un lugar de interes
     */
    private UbicacionEntity ubicacion;
    
    /**
     * Atributo que modela algunos comentarios del propietario sobre su
     * hospedaje
     */
    private String descripcion;
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
    public List<HospedajeLugarEntity> getHospedajeLugar() {
        return hospedajeLugar;
    }

    /**
     * Cambia los hospedajes cercanos
     *
     * @param hospedajeLugar
     */
    public void setHospedaLugar(List<HospedajeLugarEntity> hospedajeLugar) {
        this.hospedajeLugar = hospedajeLugar;
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
        hash = 97 * hash + Objects.hashCode(this.ubicacion);
        return hash;
    }
}
