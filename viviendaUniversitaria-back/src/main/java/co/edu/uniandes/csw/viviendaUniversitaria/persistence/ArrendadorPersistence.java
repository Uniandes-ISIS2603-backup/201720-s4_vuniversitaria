/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author kk.penaranda
 */
@Stateless
public class ArrendadorPersistence {
    private static final Logger LOGGER = Logger.getLogger(ArrendadorPersistence.class.getName());

    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto Arrendador que se creará en la base de datos
     * @return devuelve la entidad creada con un identificador dado por la base de datos.
     */
    public ArrendadorEntity create(ArrendadorEntity entity) {
        LOGGER.info("Creando un arrendador nuevo");
        em.persist(entity);
        LOGGER.info("Creando un arrendador nuevo");
        return entity;
    }

    /**
     * Actualiza un arrendador.
     * @param arrendadorEntity: el arrendador que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un arrendador con los cambios aplicados.
     */
    public ArrendadorEntity update(ArrendadorEntity arrendadorEntity) {
        LOGGER.log(Level.INFO, "Actualizando Arrendador con id={0}", arrendadorEntity.getId());
        return em.merge(arrendadorEntity);
    }

    /**
     * Borra un biblioteca de la base de datos recibiendo como argumento el id
     * del Arrendador
     * @param id: id correspondiente al Arrendador a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Arrendador con id={0}", id);
        ArrendadorEntity arrendadorEntity = em.find(ArrendadorEntity.class, id);
        em.remove(arrendadorEntity);
    }

    /**
     * Busca si hay algun arrendador con el id que se envía de argumento
     * @param id: id correspondiente al Arrendador buscado.
     * @return un arrendador.
     */
    public ArrendadorEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Arrendador con id={0}", id);
        return em.find(ArrendadorEntity.class, id);
    }

    /**
     * Devuelve todos los Arrendador de la base de datos.
     * @return una lista con todos los Arrendador que encuentre en la base de
     * datos, "select u from ArrendadorEntity u" 
     */
    public List<ArrendadorEntity> findAll() {
        LOGGER.info("Consultando todos los Arrendadores");
        TypedQuery query = em.createQuery("select u from ArrendadorEntity u", ArrendadorEntity.class);
        return query.getResultList();
    }
}
