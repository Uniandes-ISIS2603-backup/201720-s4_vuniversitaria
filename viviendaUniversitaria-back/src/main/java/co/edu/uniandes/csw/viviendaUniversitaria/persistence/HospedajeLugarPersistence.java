/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Perisitencia de lugar de hospedaje.
 * @author ws.duarte
 */
@Stateless
public class HospedajeLugarPersistence{

    protected static Logger LOG;

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public HospedajeLugarPersistence()
    {
       LOG = Logger.getLogger(HospedajeLugarPersistence.class.getName());
    }
            
    public HospedajeLugarEntity create(HospedajeLugarEntity entity) {
        LOG.log(Level.INFO, "Creando un nuevo hospedaje lugar");
        em.persist(entity);
        LOG.log(Level.FINE, "se ha creado un nuevo hospedaje lugar");
        return entity;
    }

    
    public HospedajeLugarEntity find(Long idHospedaje, Long idLugarInteres) {
        TypedQuery<HospedajeLugarEntity> tq = em.createQuery("select a from HospedajeLugarEntity a where a.hospedaje.id = :idHospedaje and  a.lugarInteres.id = :idLugarInteres", HospedajeLugarEntity.class);
        tq.setParameter("idHospedaje", idHospedaje);
        tq.setParameter("idLugarInteres", idLugarInteres);
        return tq.getSingleResult();
        
    }

    public List<HospedajeLugarEntity> findAll(Long idHospedaje) {
        LOG.log(Level.INFO, "Consultando todos los hospedaje lugar con id {0}", idHospedaje);
        TypedQuery tq = em.createQuery("select a from HospedajeLugarEntity a where a.hospedaje.id = :idHospedaje", HospedajeLugarEntity.class);
        tq.setParameter("idHospedaje", idHospedaje);
        return tq.getResultList();
    }

    public HospedajeLugarEntity update(HospedajeLugarEntity entity) {
        LOG.log(Level.INFO, "Actualizando un lugar hospedaje");
        entity = em.merge(entity);
        LOG.log(Level.FINE, "actualizando correctamente");
        return entity;
    }

    public void delete(Long idHospedaje, Long IdLugarInteres) {
        LOG.log(Level.INFO, "Eliminando un lugar hospedaje");
        em.remove(find(idHospedaje, IdLugarInteres));
        LOG.log(Level.FINE, "eliminado correctamente");
    }  
}
