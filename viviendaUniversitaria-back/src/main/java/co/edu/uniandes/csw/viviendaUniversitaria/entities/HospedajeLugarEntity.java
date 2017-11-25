package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela la relación entre un hospedaje y un lugar de interés.
 *
 * @author ws.duarte
 */
@Entity
public class HospedajeLugarEntity implements Serializable {

    /**
     * Distancia entre el hospedaje y el lugar.
     */
    private Double distancia;

    /**
     * Relación con el hospedaje.
     */
    @Id
    @PodamExclude
    @ManyToOne
    private HospedajeEntity hospedaje;

    /**
     * Relación con el lugar de interés.
     */
    @Id
    @PodamExclude
    @ManyToOne
    private LugaresInteresEntity lugarInteres;

    /**
     * Retorna la distania entre el hospedaje y el lugar de interés.
     *
     * @return Distancia entre el hospedaje y el lugar de interés.
     */
    public Double getDistancia() {
        return distancia;
    }

    /**
     * Cambia la distancia entre el hospedaje y el lugar de interés.
     *
     * @param distancia Nuevo valor de la distacia.
     */
    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    /**
     * Retorna la relación a hospedaje;
     *
     * @return Relación a hospedaje.
     */
    public HospedajeEntity getHospedaje() {
        return hospedaje;
    }

    /**
     * Cambia la relación con hospedaje.
     *
     * @param hospedaje Nueva relación con hospedaje.
     */
    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }

    /**
     * Retorna la relación con lugar de interés
     *
     * @return Relación con lugar de interés.
     */
    public LugaresInteresEntity getLugarInteres() {
        return lugarInteres;
    }

    /**
     * Cambia la relación con lugar de interés.
     *
     * @param lugarInteres Nueva relación con lugar de interés.
     */
    public void setLugarInteres(LugaresInteresEntity lugarInteres) {
        this.lugarInteres = lugarInteres;
    }

    /**
     * Compara dos hospedajeLugar para determinar si son iguales.
     *
     * @param obj HospedajeLugar a comparar.
     * @return True si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HospedajeLugarEntity) {
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.distancia);
        return hash;
    }
}
