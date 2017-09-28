/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.HospedajeDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kk.penaranda
 */
public class ArrendadorDetailDTO extends ArrendadorDTO{
    
    private List<HospedajeDTO> hospedajes;
            
     /**
     * Constructor 
     */
    public ArrendadorDetailDTO() {
        super();
    }
    
    public ArrendadorDetailDTO(ArrendadorEntity arrendador){
        super(arrendador);
        if(arrendador!= null){
            this.hospedajes = new ArrayList<>();
            for(HospedajeEntity entity: arrendador.getHospedajes()){
                hospedajes.add(new HospedajeDTO(entity));
            }
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ArrendadorEntity toEntity() {
        ArrendadorEntity arrendadorEntity = super.toEntity();
        if(hospedajes!= null){
            List<HospedajeEntity> listaHospedajes= new ArrayList<>();
            for(HospedajeDTO hospedajeDTO : hospedajes){
                listaHospedajes.add(hospedajeDTO.toEntity());
            }
            arrendadorEntity.setHospedajes(listaHospedajes);
        }
        return arrendadorEntity;
    }
    
    public List<HospedajeDTO> getHospedajes(){
        return this.hospedajes;
    }
    
    public void setHospedajes(List<HospedajeDTO> hospedajes){
        this.hospedajes= hospedajes;
    }
}
