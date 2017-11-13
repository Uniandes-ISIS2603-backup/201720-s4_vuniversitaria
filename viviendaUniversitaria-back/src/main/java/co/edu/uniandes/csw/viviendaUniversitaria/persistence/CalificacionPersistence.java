/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Persistencia de la aplicacion
 * @author kk.penaranda
 */
@Stateless
public class CalificacionPersistence {
    
    /**
     * Logger para mostrar los comentarios
     */
    private static final Logger LOGGER= Logger.getLogger(CalificacionPersistence.class.getName());
    
    /**
     * Entidad manager
     */
    @PersistenceContext(unitName= "viviendaUniversitariaPU")
    protected EntityManager em;
    
    /**
     * Crea una nueva calificacion
     * @param calificacionEntity
     * @return entidad de la calificacion
     */
    public CalificacionEntity create(CalificacionEntity calificacionEntity){
        LOGGER.info("Creando un nuevo objeto Calificacion");
        em.persist(calificacionEntity);
        LOGGER.info("Creando una nueva calificacion");
        return calificacionEntity;
    }
     
    /**
     * Actualiza una calificacion. Por reglas de negocio esto no se permite.
     * @param calificacionEntity
     * @return califiacion actualizada
     */
    public CalificacionEntity update(CalificacionEntity calificacionEntity){
    LOGGER.log(Level.INFO, "Actualizando Calificacion con id={0}", calificacionEntity.getId() );
    return em.merge(calificacionEntity);
    }
    
    /**
     * Encuentra una calificacion dada por parametro.
     * @param id
     * @return entidad encontrada
     */
    public CalificacionEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando calificacion con id={0}", id);
        return em.find(CalificacionEntity.class, id);
    }
    
    /**
     * Elimina la calificacion dada
     * @param id 
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando Calificacion con id={0}", id);
        CalificacionEntity entity= em.find(CalificacionEntity.class, id);
        em.remove(entity);
    }
    
    /**
     * Encuentra todas las calificaciones
     * @return 
     */
    public List<CalificacionEntity> findAll(){
        LOGGER.info("Consultando todas las calificaciones registradas.");
        TypedQuery query= em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        return query.getResultList();
    }    
    
}
