package co.edu.uniandes.csw.viviendauniversitaria.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela una regla agregada a un hospedaje.
 *
 * @author ws.duarte
 */
@Entity
public class ReglaEntity extends BaseEntity {

    /**
     * Regla de un hospedaje.
     */
    private String regla;

    /**
     * Relación con hospedaje.
     */
    @PodamExclude
    @ManyToOne
    private HospedajeEntity hospedaje;

    /**
     * Retorna la regla de un hospedaje.
     *
     * @return Regla del hospedaje
     */
    public String getRegla() {
        return regla;
    }

    /**
     * Cambia la regla de un hospedaje.
     *
     * @param regla Nuevo valor de regla.
     */
    public void setRegla(String regla) {
        this.regla = regla;
    }

    /**
     * Retorna el hospedaje que se relaciona con la regla.
     *
     * @return Relación con hospedaje.
     */
    public HospedajeEntity getHospedaje() {
        return hospedaje;
    }

    /**
     * Cambia la relación que se tiene con hospedaje.
     *
     * @param hospedaje Nueva relación con hospedaje.
     */
    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }

    /**
     * Compara dos reglas para determinar si son iguales.
     *
     * @param obj Regla a comparar.
     * @return True si las reglas son igules, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ReglaEntity) {
            return super.equals(obj);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.regla);
        return hash;
    }
}
