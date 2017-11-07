/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
import javax.ejb.Stateless;

/**
 *
 * @author jsang
 */
@Stateless
public class ServicioPersistence extends GenericPresistence<ServiciosEntity>{
    
public ServicioPersistence ()
{
    super(ServiciosEntity.class);
}
}
