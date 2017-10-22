/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.*;
import javax.ejb.Stateless;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class HospedajeLugarPersistence extends GenericPresistence<HospedajeLugarEntity> {

    public HospedajeLugarPersistence() {
        super(HospedajeLugarEntity.class);
    }

}
