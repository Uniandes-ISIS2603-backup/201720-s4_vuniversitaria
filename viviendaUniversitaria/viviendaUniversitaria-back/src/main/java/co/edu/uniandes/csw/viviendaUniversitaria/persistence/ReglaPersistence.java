/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReglaEntity;
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
public class ReglaPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(DefaultPersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public ReglaEntity create(ReglaEntity entidad)
    {
        em.persist(entidad);
        LOGGER.info("Nuevo hospedaje creado");
        return entidad;
    }
    
    public ReglaEntity update(ReglaEntity entidad)
    {
        LOGGER.info("Actualizando hospedaje con id: "+entidad.getId());
        return em.merge(entidad);
    }
    
    public void delete(ReglaEntity entidad)
    {
        em.remove(entidad);
    }
    
    public ReglaEntity findId(Long id)
    {
        return em.find(ReglaEntity.class, id);
    }
    
    public List<ReglaEntity> findAll()
    {
        return em.createQuerty("select u from HospedajeEntity u", ReglaEntity.class).getResultList();
    }
    
}
