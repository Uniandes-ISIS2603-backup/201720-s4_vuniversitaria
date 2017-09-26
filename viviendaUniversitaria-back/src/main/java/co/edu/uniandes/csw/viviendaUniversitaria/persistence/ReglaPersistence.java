/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author NOA_WERMEID
 */

@Stateless
public class ReglaPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(ReglaPersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public ReglaEntity create(ReglaEntity entity) {
        LOGGER.info("Creando un regla nuevo");
        em.persist(entity);
        LOGGER.info("Creando un regla nuevo");
        return entity;
    }

    public ReglaEntity update(ReglaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando un regla con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando regla con id={0}", id);
        em.remove(em.find(ReglaEntity.class, id));
    }

    public ReglaEntity find(Long idHospedaje, Long id) {
        LOGGER.log(Level.INFO, "Consultando regla con id={0}", id);
        TypedQuery<ReglaEntity> q = em.createQuery("select p from ReglaEntity p where (p.hospedaje.id = :idHospedaje) and (p.id = :idRegla)", ReglaEntity.class);
        q.setParameter("idHospedaje", idHospedaje);
        q.setParameter("idRegla", id);
        List<ReglaEntity> results = q.getResultList();
        ReglaEntity regla = null;
        if (results == null) {
            regla = null;
        } else if (results.isEmpty()) {
            regla = null;
        } else if (results.size() >= 1) {
            regla = results.get(0);
        }

        return regla;
        //return em.find(ReglaEntity.class, id);
    }

    public List<ReglaEntity> findAll() {
        LOGGER.info("Consultando todas las regla");
        return em.createQuery("select u from ReglaEntity u", ReglaEntity.class).getResultList();
    }
    
}
