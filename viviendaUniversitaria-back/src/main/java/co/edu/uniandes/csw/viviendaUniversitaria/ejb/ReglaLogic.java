/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReglaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ReglaPersistence;
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
public class ReglaLogic 
{
    private static final Logger LOGGER = Logger.getLogger(ReglaLogic.class.getName());
    
    @Inject
    private ReglaPersistence reglaPersistence;
    
    public ReglaEntity create(ReglaEntity entidad) throws WebApplicationException
    {
        LOGGER.info("Creación de una regla");
        if(reglaPersistence.find(entidad.getId()) != null)
        {
            LOGGER.log(Level.WARNING, "Intento de creacion fallido.\nLa entidad ya existe\nId:{1}", entidad.getId());
            throw new WebApplicationException("Ya existe una entidad con el id:"+entidad.getId(), 405);
        }
        return reglaPersistence.create((entidad));
    }
    
    public ReglaEntity update(ReglaEntity entidad) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", entidad.getId());
        validar((entidad), "Actualización");
        return reglaPersistence.update((entidad));
    }
    
    public void delete(Long id) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", id);
        if(reglaPersistence.find(id) == null) 
            {
            LOGGER.log(Level.WARNING, "Intento de Eliminación fallido.\nLa entidad no existe\nId:{0}",  id);
            throw new WebApplicationException("Eliminación: La entidad no existe", 405);
        }
        reglaPersistence.delete(id);
    }
    
    public ReglaEntity find(Long id)throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", id);
        ReglaEntity ret = reglaPersistence.find(id);
        if(ret == null) throw new WebApplicationException("Consulta id: La entidad no existe", 405);
        return ret;
    }
    
    public List<ReglaEntity> findAll()throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Consultando todas las reglas de un hospedaje. \nid:{0}");
        List<ReglaEntity> ret = reglaPersistence.findAll();
        if(ret.isEmpty()) throw new WebApplicationException("Actualmente no existen reglas registradas.",405);
        return ret;
    }
    
    private void validar(ReglaEntity entidad, String proceso) throws WebApplicationException
    {
        if(reglaPersistence.find(entidad.getId()) == null)
        {
            LOGGER.log(Level.WARNING, "Intento de {0} fallido.\nLa entidad no existe\nId:{1}", new Object[]{proceso, entidad.getId()});
            throw new WebApplicationException(proceso+": La entidad no existe",405);
        }
    }
    
//    private ReglaEntity validarEntidad(ReglaEntity regla) throws WebApplicationException {
//        if(regla ==  null || regla.getHospedaje() != null || regla.getRegla() != null) 
//            throw new WebApplicationException("El parametro enviado no cumple con las caracteristicas especificadas",407);
//        return regla;
//    }
}
