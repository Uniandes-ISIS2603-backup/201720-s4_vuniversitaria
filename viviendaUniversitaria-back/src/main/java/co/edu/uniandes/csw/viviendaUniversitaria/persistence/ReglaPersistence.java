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

    public ReglaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando regla con id={0}", id);
        return em.find(ReglaEntity.class, id);
    }

    public List<ReglaEntity> findAll() {
        LOGGER.info("Consultando todas las regla");
        List<ReglaEntity> ret = em.createQuery("select u from ReglaEntity u", ReglaEntity.class).getResultList();
        if(ret == null) return new ArrayList<>();
        return ret;
    }
    
}
