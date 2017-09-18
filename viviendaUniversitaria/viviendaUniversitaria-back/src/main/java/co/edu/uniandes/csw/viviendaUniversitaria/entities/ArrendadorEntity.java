/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author kk.penaranda
 */
@Entity
public class ArrendadorEntity extends BaseEntity implements Serializable{

    private String nombre;// Nombre asociado al arrendador
    
    @PodamExclude
    @OneToMany(mappedBy = "arrendador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospedajeEntity> hospedaje;
    
    /**
     * Retorna el nombre de un arrendador
     * @return nombre
     */
    public String getNombre(){
        return nombre;
    }
    
    
    /**
     * Establece el nombre perteneciente a un arrendador
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    
    public List<HospedajeEntity> getHospedajes()
    {
        return this.hospedaje;
    }
    
    public void setHospedajes(List<HospedajeEntity> hospedaje){
        this.hospedaje= hospedaje;
    }
}
