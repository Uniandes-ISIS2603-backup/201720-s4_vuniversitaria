/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jc.sanguino10
 */
public class LugaresInteresDetailDTO extends LugaresInteresDTO {

    /**
     * Atributo de la relacion con UbicacionDTO
     */
    private UbicacionDTO ubicacion;
    /**
     * 
     */
    private List<HospedajeLugarInteresDTO> hospedajeLugar;

    public LugaresInteresDetailDTO() {
        //Constructor por defecto
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public LugaresInteresDetailDTO(LugaresInteresEntity entity) {
        super(entity);
        if(entity.getUbicacion()!=null)
        {
        ubicacion = new UbicacionDTO(entity.getUbicacion());
        }
        else
        {
            ubicacion = new UbicacionDTO();
        }
        if(entity.getHospedajeLugar().isEmpty())
        {
            hospedajeLugar = new ArrayList<>();
        }
        else
        {
            List<HospedajeLugarEntity> listadoHospedajes = entity.getHospedajeLugar();
            List<HospedajeLugarInteresDTO> dtos = new ArrayList<>();
            for (HospedajeLugarEntity hospedajeLugar : listadoHospedajes) {
                dtos.add(new HospedajeLugarInteresDTO(hospedajeLugar));
            }
            hospedajeLugar = dtos;
            
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return
     */
    @Override
    public LugaresInteresEntity toEntity() {
        LugaresInteresEntity rta = super.toEntity();
        rta.setUbicacion(ubicacion.toEntity());
        return rta;

    }

    /**
     * Retorna la asociacion del dto con ubicacion dto
     * @return ubicacion
     */
    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }

    /**
     * Cambia la asociacion del dto con ubicacion dto
     * @param ubicacion 
     */
    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<HospedajeLugarInteresDTO> getHospedajeLugar() {
        return hospedajeLugar;
    }

    public void setHospedajeLugar(List<HospedajeLugarInteresDTO> hospedajeLugar) {
        this.hospedajeLugar = hospedajeLugar;
    }
    
    
    
}
