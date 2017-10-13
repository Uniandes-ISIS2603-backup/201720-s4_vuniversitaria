/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.edu.uniandes.csw.viviendaUniversitaria.interfase.IPersistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author ws.duarte
 * @param <T>
 */

public abstract class GenericPresistence<T extends BaseEntity> implements IPersistence<T>
{
    private Class<T> clase;
    private Logger LOG;

    
    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public GenericPresistence(Class<T> clase) {
        this.clase = clase;
        LOG = Logger.getLogger(clase.getName());
    }
    
    public GenericPresistence(){}
    
    @Override
    public T create(T entity)
    {
        LOG.log(Level.INFO, "Clreanto un nuevo {0}", clase.getSimpleName());
        if(entity.getId() == null) entity.setId(generatedID());
        em.persist(entity);
        LOG.log(Level.FINE, "se ha creado un nuevo {0}", clase.getSimpleName());
        return entity;
    }
    
    @Override
    public T find(Long id)
    {

        LOG.log(Level.INFO, "Consultando un {0} con id: {1}", new String[]{clase.getCanonicalName(), id.toString()});
        return em.find(clase, id);
    }
    
    
    @Override
    public List<T> findAll()
    {
        LOG.log(Level.INFO,"Consultando todos los {0}", clase.getSimpleName());
        return em.createQuery("select u from "+clase.getSimpleName()+" u", clase).getResultList();
    }
    
    @Override
    public T update(T entity)
    {
        LOG.log(Level.INFO,"Actualizando un {0}",clase.getSimpleName());
        entity = em.merge(entity);
        LOG.log(Level.FINE,"{0} actualizando correctamente",clase.getSimpleName());
        return entity;
    }
    
    @Override
    public void delete(Long id)
    {
        LOG.log(Level.INFO, "Eliminando un {0}",clase.getSimpleName());
        em.remove(find(id));
        LOG.log(Level.FINE, "{0} eliminado correctamente",clase.getSimpleName());
    }

    @Override
    public Class<T> getClase() {
        return clase;
    }
    
    private Long generatedID() {
        LOG.log(Level.INFO,"Generando el id automatico");
        return em.createQuery("select max(u.id)+1 from "+clase.getSimpleName()+" u", Long.class).getSingleResult();
    }
    
}
