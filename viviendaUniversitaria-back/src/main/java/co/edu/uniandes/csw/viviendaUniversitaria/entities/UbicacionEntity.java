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

import java.util.Objects;
import javax.persistence.Entity;
/**
 *
 * @author ISIS2603
 */
@Entity
public class UbicacionEntity extends BaseEntity{
  
    /**
    * Atributo que modela la direccion de la ubicacion.
    */
    private String direccion;
    /**
     * Atributo que modela la latitud de la ubicacion.
     */
    private Long latitud;
    /**
     * Atributo que modela la altitud de la ubicacion.
     */
    private Long altitud;

    /**
     * Retorna la latitud
     * @return latitud
     */
    public Long getLatitud() {
        return latitud;
    }
    /**
     * Modifica la latitud
     * @param latitud 
     */
    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }
    /**
     * Retorna la altitud
     * @return altitud
     */
    public Long getAltitud() {
        return altitud;
    }
    /**
     * Modifica la altitud 
     * @param altitud 
     */
    public void setAltitud(Long altitud) {
        this.altitud = altitud;
    }
    /**
     * Retorna la direccion
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Modifica la direccion
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Compara si dos ubicaciones son iguales
     * @param obj la ubicacion con la que me comparo
     * @return True si son iguales de lo contrario False.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UbicacionEntity) {
            return super.equals(obj);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.direccion);
        hash = 37 * hash + Objects.hashCode(this.latitud);
        hash = 37 * hash + Objects.hashCode(this.altitud);
        return hash;
    }
}
