/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;

import java.util.List;
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
    private static final Logger LOGGER = Logger.getLogger(DefaultPersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public HospedajeEntity create(HospedajeEntity entidad)
    {
        em.persist(entidad);
        LOGGER.info("Nuevo hospedaje creado");
        return entidad;
    }
    
    public HospedajeEntity update(HospedajeEntity entidad)
    {
        LOGGER.info("Actualizando hospedaje con id: "+entidad.getId());
        return em.merge(entidad);
    }
    
    public void delete(HospedajeEntity entidad)
    {
        em.remove(entidad);
    }
    
    public HospedajeEntity findId(Long id)
    {
        return em.find(HospedajeEntity.class, id);
    }
    
    public List<HospedajeEntity> findAll()
    {
        return em.createQuerty("select u from HospedajeEntity u", HospedajeEntity.class).getResultList();
    }
    
    
}
