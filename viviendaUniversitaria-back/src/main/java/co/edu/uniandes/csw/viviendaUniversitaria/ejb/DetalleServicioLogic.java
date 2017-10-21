/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.DetalleServicioPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class DetalleServicioLogic extends GenericLogic<DetalleServicioEntity> {
    
    @Inject
    public DetalleServicioLogic(DetalleServicioPersistence persistence) {
        super(persistence,DetalleServicioEntity.class);
    }

    public DetalleServicioLogic() {
    }
}
