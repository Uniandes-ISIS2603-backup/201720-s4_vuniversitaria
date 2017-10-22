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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author kk.penaranda
 */
@Entity
public class ArrendadorEntity implements Serializable {

    /**
     * Identificador del arrendador
     */
    @Id
    private Long id;
    
    /**
     * Nombre asociado al arrendador
     */
    private String nombre;

    /**
     * Lista de los hospedajes pertenecientes al arrendador
     */
    @PodamExclude
    @OneToMany(mappedBy = "arrendador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HospedajeEntity> hospedaje;

    /**
     * Retorna el id del arrendador
     * @return id
     */
    public Long getId(){
        return id;
    }
    
    
    /**
     * Retorna el nombre de un arrendador 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el identificador del arrendador
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Establece el nombre perteneciente a un arrendador
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna una lista de los hospedajes pertenecientes al arrendador
     *
     * @return List<HospedajeEntity>
     */
    public List<HospedajeEntity> getHospedajes() {
        return this.hospedaje;
    }

    /**
     * Establece una lista con los hospedajes que pertenecen a un arrendador
     *
     * @param hospedaje
     */
    public void setHospedajes(List<HospedajeEntity> hospedaje) {
        this.hospedaje = hospedaje;    
        
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null ){
            return false;
        }
        if(this.getClass()!= obj.getClass()){
            return false;
        }
        if (this.getId() != null && ((ArrendadorEntity) obj).getId()!= null) {
            return this.getId().equals(((ArrendadorEntity) obj).getId());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

}
