/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajeLugarPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class HospedajeLugarLogic extends GenericLogic<HospedajeLugarEntity>
{

    public HospedajeLugarLogic() {
    }
    
    @Inject
    public HospedajeLugarLogic(HospedajeLugarPersistence persistence) {
        super(persistence,HospedajeLugarEntity.class);
    }
    
}
