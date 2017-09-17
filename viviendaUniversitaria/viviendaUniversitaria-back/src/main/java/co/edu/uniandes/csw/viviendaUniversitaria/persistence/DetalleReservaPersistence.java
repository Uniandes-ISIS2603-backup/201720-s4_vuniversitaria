/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleReservaEntity;
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
public class DetalleReservaPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(EstudiantePersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public DetalleReservaEntity create(DetalleReservaEntity entity) {
        LOGGER.info("Creando un detalles de reserva nuevo");
        em.persist(entity);
        LOGGER.info("Creando un detalles de reserva nuevo");
        return entity;
    }

    public DetalleReservaEntity update(DetalleReservaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando un detalles de reserva con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando detalles de reserva con id={0}", id);
        em.remove(em.find(DetalleReservaEntity.class, id));
    }

    public DetalleReservaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando detalles de reserva con id={0}", id);
        return em.find(DetalleReservaEntity.class, id);
    }

    public List<DetalleReservaEntity> findAll() {
        LOGGER.info("Consultando todos los detalles de reserva");
        return em.createQuery("select u from DetalleReservaEntity u", DetalleReservaEntity.class).getResultList();
    }
    
}
