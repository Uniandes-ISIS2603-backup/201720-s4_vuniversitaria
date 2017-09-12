/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juan Camilo Sanguino
 */
@Stateless
public class ServiciosPersistence {

    private static final Logger LOGGER = Logger.getLogger(DefaultPersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;

    public ServiciosEntity findId(Long id) {
        return em.find(ServiciosEntity.class, id);
    }

    public ServiciosEntity create(ServiciosEntity entidad) {
        em.persist(entidad);
        LOGGER.info("Se creo un nuevo servicio ");
        return entidad;
    }

    public ServiciosEntity update(ServiciosEntity entidad) {
        LOGGER.info("Actualizando servicio con id: " + entidad.getId());
        return em.merge(entidad);
    }

    public void delete(Long id) {
        em.remove(findId(id));
    }
}
