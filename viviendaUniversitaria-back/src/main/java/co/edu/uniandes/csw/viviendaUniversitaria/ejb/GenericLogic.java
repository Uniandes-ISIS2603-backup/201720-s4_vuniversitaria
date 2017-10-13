/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.interfase.IPersistence;
import co.edu.uniandes.csw.viviendaUniversitaria.interfase.ILogic;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.GenericPresistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;
/**
 *
 * @author ws.duarte
 * @param <T>
 */
public abstract class GenericLogic <T extends BaseEntity>  implements ILogic<T>
{
    
    private Class<T> clase;
    private Logger LOG;
    
    
    
    protected GenericPresistence<T>  persistence;

    public GenericLogic() {}
    
    public GenericLogic(GenericPresistence<T> persis,Class<T> clase) throws IllegalAccessException, InstantiationException {
        this.persistence = persis;
        this.clase = clase;
        LOG = Logger.getLogger(clase.getName());
    }
    
    
    @Override
    public T create(T entity) throws WebApplicationException {
        LOG.log(Level.INFO,"Creación de un nuevo {0}",clase.getSimpleName());
        if(exist(entity.getId())) {
            LOG.log(Level.SEVERE,"La entidad con la llave primaria {0} ya existe",entity.getId());
            throw new WebApplicationException("Ya existe una entidad con esta llave primaria",405);
        }
        T ret = persistence.create(entity);
        LOG.log(Level.FINE,"La entidad fue creada exitosamente.");
        return ret;
    }
    
    @Override
    public T find(Long id) throws WebApplicationException {
        LOG.log(Level.INFO,"Consultando un {0} con la llave {1}",new String[]{clase.getSimpleName(),id.toString()});
        if(!exist(id)) {
            LOG.log(Level.SEVERE,"La entidad con la llave primaria {0} no existe",id);
            throw new WebApplicationException("No existe una entidad con esta llave primaria especificada",405);
        }
        T ret = persistence.find(id);
        LOG.log(Level.FINE,"La consulta fue exitosa");
        return ret;
    }
    
    @Override
    public List<T> findAll() throws WebApplicationException {
        LOG.log(Level.INFO,"Consultando todos los registros de {0}",clase.getSimpleName());
        List<T> ret = persistence.findAll();
        if(ret.isEmpty()) {
            LOG.log(Level.SEVERE,"No se encontraron registros al momento de consultar");
            throw new WebApplicationException("No existen entidades registradas actualmente",405);
        }
        LOG.log(Level.FINE,"La consulta fue exitosa");
        return ret;
    }
    
    @Override
    public T update(T entity, Long id) throws WebApplicationException {
        LOG.log(Level.INFO,"Actualizando la entidad con id {0}",id);
        if(!exist(id)) {
            LOG.log(Level.SEVERE,"La entidad con la llave primaria {0} no existe",id);
            throw new WebApplicationException("No existe una entidad con esta llave primaria especificada",405);
        }
        entity.setId(id);
        T ret = persistence.update(entity);
        LOG.log(Level.FINE,"La entidad se a actualizado exitosamente");
        return ret;
    }
    
    @Override
    public void delete(Long id) throws WebApplicationException {
        LOG.log(Level.INFO,"Eliminando la entidad con el id {0}",id);
        persistence.delete(id);
        LOG.log(Level.FINE,"La entidad fue eliminada exitosamente");
    }
    
    protected boolean exist(Long id) {
        return persistence.find(id) != null;
    }
    
    
}
