/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author c.santacruza
 */
@Entity
public class UniversidadEntity  extends BaseEntity {
   
   /**
    * Atributo que modela el nombre de la universidad.
    */
    private String nombre;
    /**
     * Modela la ubicacion de la imagen.
     */
    private String imagen;
    /**
     * Atributo que modela la ubicacion de la universidad.
     */
    @PodamExclude
    @OneToOne
    private UbicacionEntity ubicacion;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    /**
     * Retorna el nombre de la universidad. 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Modifica el nombre de la ubicacion.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Retorna la ubicacion de la universidad.
     * @return ubicacion
     */
    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }
    /**
     * Modifica la ubicacion de la universidad.
     * @param ubicacion 
     */
    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }
    /**
     * Compara si dos universidades son iguales
     * @param obj la universidad con la que me comparo
     * @return True si son iguales de lo contrario False.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UniversidadEntity) {
            return super.equals(obj);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.imagen);
        return hash;
    }
    
}
