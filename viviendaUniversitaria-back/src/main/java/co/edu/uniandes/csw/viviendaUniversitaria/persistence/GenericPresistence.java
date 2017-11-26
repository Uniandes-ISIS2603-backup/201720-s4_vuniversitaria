/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.edu.uniandes.csw.viviendaUniversitaria.interfase.IPersistence;

/**
 * Persistencia generica.
 * @author ws.duarte
 * @param <T>
 */
public abstract class GenericPresistence<T extends BaseEntity> implements IPersistence<T> {

    /**
     * Clase entidad que implementa el generico.
     */
    private Class<T> clase;
    
    /**
     * Loger para el registro de la entidad.
     */
    protected Logger log;

    /**
     * Manejardor de persistencia de entidaddes.
     */
    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;

    /**
     * Contruye el generico con la clase especificada.
     * @param clase Clase entidad especificada.
     */
    public GenericPresistence(Class<T> clase) {
        this.clase = clase;
        log = Logger.getLogger(clase.getName());
    }

    /**
     * Constructor por defecto de entidades.
     */
    public GenericPresistence() {
        //Se puso vacio porque toco
    }

    /**
     * Persiste una entidad
     * @param entity entidad a persistir.
     * @return Entidad persistida.
     */
    @Override
    public T create(T entity) {
        log.log(Level.INFO, "Clreanto un nuevo {0}", clase.getSimpleName());
        if (entity.getId() == null) {
            entity.setId(generatedID());
        }
        em.persist(entity);
        log.log(Level.FINE, "se ha creado un nuevo {0}", clase.getSimpleName());
        return entity;
    }

    /**
     * Bisca ina entidad por id.
     * @param id Id entidad a buscar.
     * @return La entidad a buscar.
     */
    @Override
    public T find(Long id) {
        return em.find(clase, id);
    }

    /**
     * Consulta una lista con todas la entidades.
     * @return Lista de entidades.
     */
    @Override
    public List<T> findAll() {
        log.log(Level.INFO, "Consultando todos los {0}", clase.getSimpleName());
        return em.createQuery("select u from " + clase.getSimpleName() + " u", clase).getResultList();
    }

    /**
     * Actualiza una entidad.
     * @param entity Entidad a jmodificar.
     * @return Retorna la nuava entidad a modificar.
     */
    @Override
    public T update(T entity) {
        log.log(Level.INFO, "Actualizando un {0}", clase.getSimpleName());
        T entity2 = em.merge(entity);
        log.log(Level.FINE, "{0} actualizando correctamente", clase.getSimpleName());
        return entity2;
    }

    /**
     * Elimina una entidad por un id especificado.
     * @param id Entidad a eliminar.
     */
    @Override
    public void delete(Long id) {
        log.log(Level.INFO, "Eliminando un {0}", clase.getSimpleName());
        em.remove(find(id));
        log.log(Level.FINE, "{0} eliminado correctamente", clase.getSimpleName());
    }

    /**
     * Retorna la clase de la entidad.
     * @return Clase de la entidad.
     */
    @Override
    public Class<T> getClase() {
        return clase;
    }

    /**
     * Genera el id de manera automatica de una entidad.
     * @return Id de la entidad.
     */
    private Long generatedID() {
        log.log(Level.INFO, "Generando el id automatico");
        return em.createQuery("select max(u.id)+1 from " + clase.getSimpleName() + " u", Long.class).getSingleResult();
    }

}
