package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que modela la relación entre un hospedaje y un lugar de interés. 
 * @author ws.duarte
 */
@Entity
public class HospedajeLugarEntity implements Serializable
{
    /**
     * Código unico de la relacíón.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Distancia entre el hospedaje y el lugar.
     */
    private Long distancia;
    
    /**
     * Relación con el hospedaje.
     */
    @PodamExclude
    @ManyToOne
    private HospedajeEntity hospedaje;
    
    /**
     * Relación con el lugar de interés.
     */
    @PodamExclude
    @ManyToOne
    private LugaresInteresEntity lugarInteres;

    /**
     * Retorna el código único de la relación.
     * @return Código de la relación.
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el código del hosedajeLugar.
     * @param id Nuevo código del hospedaje.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna la distania entre el hospedaje y el lugar de interés.
     * @return Distancia entre el hospedaje y el lugar de interés.
     */
    public Long getDistancia() {
        return distancia;
    }

    /**
     * Cambia la distancia entre el hospedaje y el lugar de interés.
     * @param distancia Nuevo valor de la distacia.
     */
    public void setDistancia(Long distancia) {
        this.distancia = distancia;
    }

    /**
     * Retorna la relación a hospedaje;
     * @return Relación a hospedaje.
     */
    public HospedajeEntity getHospedaje() {
        return hospedaje;
    }

    /**
     * Cambia la relación con hospedaje.
     * @param hospedaje Nueva relación con hospedaje.
     */
    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }

    /**
     * Retorna la relación con lugar de interés
     * @return Relación con lugar de interés.
     */
    public LugaresInteresEntity getLugarInteres() {
        return lugarInteres;
    }

    /**
     * Cambia la relación con lugar de interés.
     * @param lugarInteres Nueva relación  con lugar de interés.
     */
    public void setLugarInteres(LugaresInteresEntity lugarInteres) {
        this.lugarInteres = lugarInteres;
    }
    
    /**
     * Compara dos hospedajeLugar para determinar si son iguales. 
     * @param obj HospedajeLugar a comparar.
     * @return True si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HospedajeEntity && this.id != null && ((HospedajeEntity)obj).getId() != null) return this.id.equals(((HospedajeEntity)obj).getId());
        return super.equals(obj); 
    }

    /**
     * Retorna el código hash de hospedajeLugar
     * @return Código hash de hospedajeLugar.
     */
    @Override
    public int hashCode() {
        if(this.id != null) return this.id.hashCode();
        return super.hashCode(); 
    }
}
