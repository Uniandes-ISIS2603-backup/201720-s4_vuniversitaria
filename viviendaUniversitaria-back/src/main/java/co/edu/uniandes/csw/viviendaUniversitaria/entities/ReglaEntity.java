package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
     * Retorna el id de la regla.
     *
     * @return Código unoco de la regla.
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el id de la regla.
     *
     * @param id Nuevo código de la regla.
     */
    public void setId(Long id) {
        this.id = id;
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
            super.equals(obj);
        }
        return false;
    }

    /**
     * Retorna el código hash de la regla.
     *
     * @return Código hash de Regla.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.regla);
        hash = 37 * hash + Objects.hashCode(this.hospedaje);
        return hash;
    }
}
