/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class HospedajeLugarPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(EstudiantePersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public HospedajeLugarEntity create(HospedajeLugarEntity entity) {
        LOGGER.info("Creando un hosedajeLugar nuevo");
        em.persist(entity);
        LOGGER.info("Creando un hosedajeLugar nuevo");
        return entity;
    }

    public HospedajeLugarEntity update(HospedajeLugarEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando un hosedajeLugar con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando hosedajeLugar con id={0}", id);
        em.remove(em.find(HospedajeLugarEntity.class, id));
    }

    public HospedajeLugarEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando hosedajeLugar con id={0}", id);
        return em.find(HospedajeLugarEntity.class, id);
    }

    public List<HospedajeLugarEntity> findAll() {
        LOGGER.info("Consultando todas los hosedajeLugar");
        return em.createQuery("select u from HospedajeLugarEntity u", HospedajeLugarEntity.class).getResultList();
    }
    
}
