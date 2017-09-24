/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajeLugarPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class HospedajeLugarLogic 
{
    private static final Logger LOGGER = Logger.getLogger(HospedajeLugarLogic.class.getName());
    
    @Inject
    private HospedajeLugarPersistence persistence;
    
    
    public HospedajeLugarEntity create(HospedajeLugarEntity entidad) throws BusinessLogicException
    {
        LOGGER.info("Creación de un hospedaje");
        if(persistence.find(entidad.getId()) != null)
        {
            LOGGER.log(Level.WARNING, "Intento de creacion fallido.\nLa entidad ya existe\nId:{1}", entidad.getId());
            throw new BusinessLogicException("Creacion: La entidad no existe");
        }
        return persistence.create(entidad);
    }
    
    public HospedajeLugarEntity update(HospedajeLugarEntity entidad) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", entidad.getId());
        validar(entidad, "Actualización");
        return persistence.update(entidad);
    }
    
    public void delete(HospedajeLugarEntity entidad) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", entidad.getId());
        validar(entidad, "actualización");
        persistence.delete(entidad.getId());
    }
    
    public HospedajeLugarEntity find(Long id)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", id);
        HospedajeLugarEntity ret = persistence.find(id);
        if(ret == null) throw new BusinessLogicException("Consulta id: La entidad no existe");
        return ret;
    }
    
    public List<HospedajeLugarEntity> findAll()throws BusinessLogicException
    {
        LOGGER.info("Consultando todos los hospedajes");
        List<HospedajeLugarEntity> ret = persistence.findAll();
        if(ret.isEmpty()) throw new BusinessLogicException("Consulta : La entidad no existe");
        return null;
    }
    
    private void validar(HospedajeLugarEntity entidad, String proceso) throws BusinessLogicException
    {
        if(persistence.find(entidad.getId()) == null)
        {
            LOGGER.log(Level.WARNING, "Intento de {0} fallido.\nLa entidad no existe\nId:{1}", new Object[]{proceso, entidad.getId()});
            throw new BusinessLogicException(proceso+": La entidad no existe");
        }
    }
    
}
