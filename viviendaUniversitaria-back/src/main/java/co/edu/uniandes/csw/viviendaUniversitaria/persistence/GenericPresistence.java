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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import co.edu.uniandes.csw.viviendaUniversitaria.interfase.IPersistence;

/**
 *
 * @author ws.duarte
 * @param <T>
 */
@Stateless
public class GenericPresistence<T extends BaseEntity> implements IPersistence<T>
{
    public static final String CONTEXT = "viviendaUniversitariaPU";
    private Class<T> clase;
    private Logger LOG;

    @PersistenceContext(unitName = CONTEXT)
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
        LOG.log(Level.INFO, "Consultando un {0} con id: {1}", new String[]{clase.getSimpleName(), id.toString()});
        return em.find(clase, id);
    }
    
    @Override
    public List<T> findAll()
    {
        LOG.log(Level.INFO,"Consultando todos los {0}",clase.getSimpleName());
        return execute("select u from "+clase.getSimpleName()+" u").getResultList();
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
    public TypedQuery<T> execute(String sql)
    {
        LOG.info("Ejecutando la query");
        return em.createQuery(sql, clase);
    }

    @Override
    public Class<T> getClase() {
        return clase;
    }
    
    private Long generatedID() {
        return em.createQuery("select count(u) from "+clase.getSimpleName()+" u", Long.class).getSingleResult();
    }
    
}
