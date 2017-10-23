/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.LugaresInteresPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jc.sanguino10
 */
@Stateless
public class LugaresInteresLogic extends GenericLogic<LugaresInteresEntity>{
 /**
  * Constructor vacio por defecto
  */
   public LugaresInteresLogic()
   {
       super();
   }
   @Inject
   public LugaresInteresLogic(LugaresInteresPersistence persistence)
   {
       super(persistence,LugaresInteresEntity.class);
   }
    
}
