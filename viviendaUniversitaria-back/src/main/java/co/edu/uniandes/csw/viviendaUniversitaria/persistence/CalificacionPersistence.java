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
 *
 * @author kk.penaranda
 */
@Stateless
public class CalificacionPersistence {
    private static final Logger LOGGER= Logger.getLogger(CalificacionPersistence.class.getName());
    @PersistenceContext(unitName= "viviendaUniversitariaPU")
    protected EntityManager em;
    
    public CalificacionEntity create(CalificacionEntity calificacionEntity){
        LOGGER.info("Creando un nuevo objeto Calificacion");
        em.persist(calificacionEntity);
        LOGGER.info("Creando una nueva calificacion");
        return calificacionEntity;
    }
        
    public CalificacionEntity update(CalificacionEntity calificacionEntity){
    LOGGER.log(Level.INFO, "Actualizando Calificacion con id={0}", calificacionEntity.getId() );
    return em.merge(calificacionEntity);
    }
    
    public CalificacionEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando calificacion con id={0}", id);
        return em.find(CalificacionEntity.class, id);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando Calificacion con id={0}", id);
        CalificacionEntity entity= em.find(CalificacionEntity.class, id);
        em.remove(entity);
    }
    public List<CalificacionEntity> findAll(){
        LOGGER.info("Consultando todas las calificaciones registradas.");
        TypedQuery query= em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        return query.getResultList();
    }
    
    public CalificacionEntity getListaCalificacionesHospedaje(Long idHospedaje, Long idCalificacion){
        TypedQuery<CalificacionEntity> tabla = em.createQuery("select p from CalificacionEntity p where (p.hospedaje.id = :idHospedaje) and (p.id = :idCalificacion)", CalificacionEntity.class);
        tabla.setParameter("idHospedaje", idHospedaje);
        tabla.setParameter("idCalificacion", idCalificacion);
        List<CalificacionEntity> lista= tabla.getResultList();
        CalificacionEntity calificacion= null;
        if(lista== null){
            calificacion = null;
        }
        else if(lista.isEmpty()){
            calificacion= null;
        }
        else if(lista.size()>=1){
            calificacion= lista.get(0);
        }
        return calificacion;
    }
    
    public CalificacionEntity getListaCalificacionesEstudiante(Long idEstudiante, Long idCalificacion){
        TypedQuery<CalificacionEntity> tabla = em.createQuery("select p from CalificacionEntity p where (p.estudiante.id = :idEstudiante) and (p.id = :idCalificacion)", CalificacionEntity.class);
        tabla.setParameter("idEstudiante", idEstudiante);
        tabla.setParameter("idCalificacion", idCalificacion);
        List<CalificacionEntity> lista= tabla.getResultList();
        CalificacionEntity calificacion= null;
        if(lista== null){
            calificacion = null;
        }
        else if(lista.isEmpty()){
            calificacion= null;
        }
        else if(lista.size()>=1){
            calificacion= lista.get(0);
        }
        return calificacion;
    }
}
