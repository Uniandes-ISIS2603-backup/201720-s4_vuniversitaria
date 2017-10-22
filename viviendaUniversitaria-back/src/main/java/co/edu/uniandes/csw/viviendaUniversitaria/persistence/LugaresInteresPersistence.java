/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import java.util.List;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Juan Camilo Sanguino
 */
@Stateless
public class LugaresInteresPersistence {

    private static final Logger LOGGER = Logger.getLogger(LugaresInteresPersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;

    public LugaresInteresEntity findId(Long id) {
        return em.find(LugaresInteresEntity.class, id);
    }

    public LugaresInteresEntity create(LugaresInteresEntity entidad) {
        em.persist(entidad);
        LOGGER.info("Se creo un nuevo lugar de interes ");
        return entidad;
    }

    public LugaresInteresEntity update(LugaresInteresEntity entidad) {
        LOGGER.info("Actualizando lugar de interes en persistencia");
        return em.merge(entidad);
    }

    public void delete(Long id) {
        em.remove(findId(id));
    }
     public List<LugaresInteresEntity> findAll() {
        LOGGER.info("Consultando todos los lugares de Interes");
        Query q = em.createQuery("select u from LugaresInteresEntity u");
        return q.getResultList();
    }

}
