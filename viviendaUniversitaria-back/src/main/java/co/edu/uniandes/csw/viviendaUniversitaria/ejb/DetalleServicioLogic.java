/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.DetalleServicioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class DetalleServicioLogic 
{
    private static final Logger LOGGER = Logger.getLogger(DetalleServicioLogic.class.getName());
    
    @Inject
    private DetalleServicioPersistence persistence;
    
    
    public DetalleServicioEntity create(DetalleServicioEntity entidad) throws WebApplicationException
    {
        LOGGER.info("Creación de un hospedaje");
        if(persistence.find(entidad.getId()) != null)
        {
            LOGGER.log(Level.WARNING, "Intento de creacion fallido.\nLa entidad ya existe\nId:{1}", entidad.getId());
            throw new WebApplicationException("Creacion: La entidad ya existe",405);
        }
        return persistence.create(validarEntidad(entidad));
    }
    
    public DetalleServicioEntity update(DetalleServicioEntity entidad) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", entidad.getId());
        validar(entidad, "Actualización");
        return persistence.update(validarEntidad(entidad));
    }
    
    public void delete(Long id) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", id);
        if(persistence.find(id) == null) 
            {
            LOGGER.log(Level.WARNING, "Intento de Eliminación fallido.\nLa entidad no existe\nId:{0}",  id);
            throw new WebApplicationException("Eliminación: La entidad no existe", 405);
        }
        persistence.delete(id);
    }
    
    public DetalleServicioEntity find(Long id)throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", id);
        DetalleServicioEntity ret = persistence.find(id);
        if(ret == null) throw new WebApplicationException("Consulta id: La entidad no existe", 405);
        return ret;
    }
    
    public List<DetalleServicioEntity> findAll()throws WebApplicationException
    {
        LOGGER.info("Consultando todos los hospedajes");
        List<DetalleServicioEntity> ret = persistence.findAll();
        if(ret.isEmpty()) throw new WebApplicationException("Actualimente no existen detaller registrados");
        return ret;
    }
    
    private void validar(DetalleServicioEntity entidad, String proceso) throws WebApplicationException
    {
        if(persistence.find(entidad.getId()) == null)
        {
            LOGGER.log(Level.WARNING, "Intento de {0} fallido.\nLa entidad no existe\nId:{1}", new Object[]{proceso, entidad.getId()});
            throw new WebApplicationException(proceso+": La entidad no existe");
        }
    }
    
    private DetalleServicioEntity validarEntidad(DetalleServicioEntity entidad) throws WebApplicationException
    {
        if(entidad == null || entidad.getSubTotal().intValue() < 0 || entidad.getFactura() != null || entidad.getServicio()!= null || entidad.getCantidad().intValue() > 0)
            throw new WebApplicationException("El parametro enviado no cumple con las caracteristicas especificadas",407);
        return entidad;
    }
    
}
