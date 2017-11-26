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
 * Logica del detalle de reserva
 * @author ws.duarte
 */
@Stateless
public class DetalleReservaLogic extends GenericLogic<DetalleReservaEntity> {

    /**
     * Constructor por defecto
     */
    public DetalleReservaLogic() {
        super();
    }

    /**
     * Cosntrulle la logica 
     * @param persistence persistencia a utilizar.
     */
    @Inject
    public DetalleReservaLogic(DetalleReservaPersistence persistence) {
        super(persistence, DetalleReservaEntity.class);
    }
}
