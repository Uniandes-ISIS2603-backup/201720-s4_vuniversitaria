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
import javax.ws.rs.WebApplicationException;

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
   @Override
   public LugaresInteresEntity update(LugaresInteresEntity entity, Long id)throws WebApplicationException
   {
       LugaresInteresEntity old = persistence.find(id);
       if(entity.getDistancia()==0 && old.getDistancia()>entity.getDistancia())
       {
           entity.setDistancia(old.getDistancia());
       }
       if(entity.getDescripcion()==null || entity.getDescripcion().equals(""))
       {
           entity.setDescripcion(old.getDescripcion());
       }
       if(entity.getRutaImagen()==null || entity.getRutaImagen().equals(""))
       {
           entity.setRutaImagen(old.getRutaImagen());
       }
       if(entity.getUbicacion()==null)
       {
           entity.setUbicacion(old.getUbicacion());
       }
       return persistence.update(entity);
   }
    
}
