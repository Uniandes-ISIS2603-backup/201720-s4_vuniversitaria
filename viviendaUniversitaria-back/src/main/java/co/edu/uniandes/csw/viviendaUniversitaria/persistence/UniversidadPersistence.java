/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import javax.ejb.Stateless;

/**
 *
 * @author c.santacruza
 */

@Stateless
public class UniversidadPersistence  extends GenericPresistence<UniversidadEntity>{
    
    /**
     * Contructor con persistence.
     */
    public UniversidadPersistence(){
        super(UniversidadEntity.class);
    }
    /**
     * Metodo para hace un update de ubicacion.
     * @param idUniversidad
     * @param entity
     * @return 
     */
    public UbicacionEntity updateUbicacion (Long idUniversidad, UbicacionEntity entity) {
        UniversidadEntity universidad = find(idUniversidad);
        universidad.setUbicacion(entity);
        em.merge(universidad);
        return entity;
    }
}
