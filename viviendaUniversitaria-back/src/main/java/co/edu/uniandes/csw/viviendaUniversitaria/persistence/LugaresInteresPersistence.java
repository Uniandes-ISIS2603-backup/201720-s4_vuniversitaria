/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import javax.ejb.Stateless;

/**
 *
 * @author Juan Camilo Sanguino
 */
@Stateless
public class LugaresInteresPersistence extends GenericPresistence<LugaresInteresEntity>{

    public  LugaresInteresPersistence()
    {
        super(LugaresInteresEntity.class);
    }  
}
