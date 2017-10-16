/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.UbicacionPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author c.santacruza
 */
@Stateless
public class UbicacionLogic extends GenericLogic<UbicacionEntity>{

    
    /**
     * Constructor vacio.
     */
    public UbicacionLogic(){
        super();
    }
    /**
     * Injecta la persistencia
     * @param persistence
     * @throws IllegalAccessException
     * @throws InstantiationException 
     */
    @Inject
    public UbicacionLogic(UbicacionPersistence persistence) throws IllegalAccessException, InstantiationException {
    super(persistence,UbicacionEntity.class);
    }
}
