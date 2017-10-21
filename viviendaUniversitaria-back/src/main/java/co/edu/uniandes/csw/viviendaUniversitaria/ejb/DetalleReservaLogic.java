/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleReservaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.DetalleReservaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class DetalleReservaLogic extends GenericLogic<DetalleReservaEntity> {

    public DetalleReservaLogic() {
        super();
    }

    @Inject
    public DetalleReservaLogic(DetalleReservaPersistence persistence) {
        super(persistence, DetalleReservaEntity.class);
    }
}
