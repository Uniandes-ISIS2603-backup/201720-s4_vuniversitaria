/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class DetalleServicioPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(DetalleServicioPersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public DetalleServicioEntity create(DetalleServicioEntity entity) {
        LOGGER.info("Creando un detalles de servicio nuevo");
        em.persist(entity);
        LOGGER.info("Creando un detalles de servicio nuevo");
        return entity;
    }

    public DetalleServicioEntity update(DetalleServicioEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando un detalles de servicio con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando detalles de servicio con id={0}", id);
        em.remove(em.find(DetalleServicioEntity.class, id));
    }

    public DetalleServicioEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando detalles de servicio con id={0}", id);
        return em.find(DetalleServicioEntity.class, id);
    }

    public List<DetalleServicioEntity> findAll() {
        LOGGER.info("Consultando todos los detalles de servicio");
        return em.createQuery("select u from DetalleServicioEntity u", DetalleServicioEntity.class).getResultList();
    }
    
}
