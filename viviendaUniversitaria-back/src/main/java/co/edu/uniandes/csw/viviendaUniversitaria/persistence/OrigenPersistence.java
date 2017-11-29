/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import javax.ejb.Stateless;

/**
 *
 * @author a.eslava
 */
@Stateless
public class OrigenPersistence extends GenericPresistence<OrigenEntity>{
    
    public OrigenPersistence() {
        super(OrigenEntity.class);
    }
    
    
    //public findByName(String )
}
