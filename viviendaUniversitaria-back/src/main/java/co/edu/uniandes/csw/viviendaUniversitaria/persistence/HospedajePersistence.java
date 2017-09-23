/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReglaEntity;

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
public class HospedajePersistence 
{
    private static final Logger LOGGER = Logger.getLogger(EstudiantePersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public HospedajeEntity create(HospedajeEntity entity) {
        LOGGER.info("Creando un hospedaje nuevo");
        em.persist(entity);
        LOGGER.info("Creando un hospedaje nuevo");
        return entity;
    }

    public HospedajeEntity update(HospedajeEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando un hospedaje con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando hospedaje con id={0}", id);
        em.remove(em.find(HospedajeEntity.class, id));
    }

    public HospedajeEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando hospedaje con id={0}", id);
        return em.find(HospedajeEntity.class, id);
    }

    public List<HospedajeEntity> findAll() {
        LOGGER.info("Consultando todas los hospedaje");
        return em.createQuery("select u from HospedajeEntity u", HospedajeEntity.class).getResultList();
    }
    
    
}
