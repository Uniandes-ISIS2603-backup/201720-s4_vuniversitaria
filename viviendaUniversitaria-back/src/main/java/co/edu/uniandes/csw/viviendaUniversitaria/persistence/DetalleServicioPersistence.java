/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;
import javax.ejb.Stateless;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class DetalleServicioPersistence extends GenericPresistence<DetalleServicioEntity> {

    /**
     * Construye el generico para la clase especificada.
     */
    public DetalleServicioPersistence() {
        super(DetalleServicioEntity.class);
    }
}
