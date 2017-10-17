/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.interfase.ILogic;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.GenericPresistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ws.duarte
 * @param <T>
 */
public abstract class GenericLogic<T extends BaseEntity> implements ILogic<T> {

    private Class<T> clase;
    protected Logger LOG;

    protected GenericPresistence<T> persistence;

    public GenericLogic() {
    }

    public GenericLogic(GenericPresistence<T> persis, Class<T> clase) throws IllegalAccessException, InstantiationException {
        this.persistence = persis;
        this.clase = clase;
        LOG = Logger.getLogger(clase.getName());
    }

    @Override
    public T create(T entity) throws BusinessLogicException {
        LOG.log(Level.INFO, "Creación de un nuevo {0}", clase.getSimpleName());
        if (exist(entity.getId())) {
            LOG.log(Level.SEVERE, "La entidad con la llave primaria {0} ya existe", entity.getId());
            throw new BusinessLogicException("Ya existe una entidad con esta llave primaria");
        }
        T ret = persistence.create(entity);
        LOG.log(Level.FINE, "La entidad fue creada exitosamente.");
        return ret;
    }

    @Override
    public T find(Long id) throws BusinessLogicException {
        LOG.log(Level.INFO, "Consultando un {0} con la llave {1}", new String[]{clase.getSimpleName(), id.toString()});
        T ret = persistence.find(id);
        if (ret==null) {
            LOG.log(Level.SEVERE, "La entidad con la llave primaria {0} no existe", id);
            throw new BusinessLogicException("No existe una entidad con esta llave primaria especificada");
        }
        LOG.log(Level.FINE, "La consulta fue exitosa");
        return ret;
    }

    @Override
    public List<T> findAll() {
        LOG.log(Level.INFO, "Consultando todos los registros de {0}", clase.getSimpleName());
        List<T> ret = persistence.findAll();
        LOG.log(Level.FINE, "La consulta fue exitosa");
        return ret;
    }

    @Override
    public T update(T entity, Long id) throws WebApplicationException {
        LOG.log(Level.INFO, "Actualizando la entidad con id {0}", id);
        if (!exist(id)) {
            LOG.log(Level.SEVERE, "La entidad con la llave primaria {0} no existe", id);
            throw new WebApplicationException("No existe una entidad con esta llave primaria especificada", 405);
        }
        entity.setId(id);
        T ret = persistence.update(entity);
        LOG.log(Level.FINE, "La entidad se a actualizado exitosamente");
        return ret;
    }

    @Override
    public void delete(Long id) throws BusinessLogicException {
        LOG.log(Level.INFO, "Eliminando la entidad con el id {0}", id);
        persistence.delete(id);
        LOG.log(Level.FINE, "La entidad fue eliminada exitosamente");
    }

    protected boolean exist(Long id) {
        return persistence.find(id) != null;
    }
}
