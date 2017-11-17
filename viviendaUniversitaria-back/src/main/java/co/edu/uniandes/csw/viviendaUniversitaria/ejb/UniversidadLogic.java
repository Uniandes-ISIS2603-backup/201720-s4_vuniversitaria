/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.UniversidadPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author c.santacruza
 */
@Stateless
public class UniversidadLogic extends GenericLogic<UniversidadEntity> {
    
    /**
     * Atributo que modela la logica de ubicación.
     */
    private UbicacionLogic logicUbicacion;
    
    /**
     * Constructor vacio.
     */
    public UniversidadLogic() {
        super();
    }

    /**
     *  Injecta la persistencia y la logica de las relaciones
     * @param persistence
     * @param logicUbi
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Inject
    public UniversidadLogic(UniversidadPersistence persistence, UbicacionLogic logicUbi) throws IllegalAccessException, InstantiationException {
        super(persistence, UniversidadEntity.class);
        this.logicUbicacion = logicUbi;
    }
   
}
