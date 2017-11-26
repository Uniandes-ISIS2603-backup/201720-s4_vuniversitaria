/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Perisitencia de lugar de hospedaje.
 * @author ws.duarte
 */
@Stateless
public class HospedajeLugarPersistence{

    /**
     * Logger para registro de mensajes.
     */
    private static final Logger log = Logger.getLogger(HospedajeLugarPersistence.class.getName());

    /**
     * Manejador de persistencia.
     */
    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    
    /**
     * Constructor por defecto.
     */
    public HospedajeLugarPersistence()
    {
        //Se ve más bonita asi
    }
            
    /**
     * Crea un nuevo hospedaje lugar.
     * @param entity Realación a aregistrar.
     * @return Entidad registrada.
     */
    public HospedajeLugarEntity create(HospedajeLugarEntity entity) {
        log.log(Level.INFO, "Creando un nuevo hospedaje lugar");
        em.persist(entity);
        log.log(Level.FINE, "se ha creado un nuevo hospedaje lugar");
        return entity;
    }
    
    /**
     * Busca una entidad con el id especifoicado
     * @param idHospedaje Hospedaje de la relacion
     * @param idLugarInteres Lugar de la relacion
     * @return Entidad buscada.
     */
    public HospedajeLugarEntity find(Long idHospedaje, Long idLugarInteres) {
        TypedQuery<HospedajeLugarEntity> tq = em.createQuery("select a from HospedajeLugarEntity a where a.hospedaje.id = :idHospedaje and  a.lugarInteres.id = :idLugarInteres", HospedajeLugarEntity.class);
        tq.setParameter("idHospedaje", idHospedaje);
        tq.setParameter("idLugarInteres", idLugarInteres);
        return tq.getSingleResult();
        
    }

    /**
     * Consulta todas las relaciones de un hospedaje.
     * @param idHospedaje Id del hospedaje.
     * @return Lista de relaciones encontradas.
     */
    public List<HospedajeLugarEntity> findAll(Long idHospedaje) {
        log.log(Level.INFO, "Consultando todos los hospedaje lugar con id {0}", idHospedaje);
        TypedQuery tq = em.createQuery("select a from HospedajeLugarEntity a where a.hospedaje.id = :idHospedaje", HospedajeLugarEntity.class);
        tq.setParameter("idHospedaje", idHospedaje);
        return tq.getResultList();
    }

    /**
     * Actualiza la relacion
     * @param entity Entidad a actualizar.
     * @return Entidad modificada.
     */
    public HospedajeLugarEntity update(HospedajeLugarEntity entity) {
        log.log(Level.INFO, "Actualizando un lugar hospedaje");
        HospedajeLugarEntity entity2 = em.merge(entity);
        log.log(Level.FINE, "actualizando correctamente");
        return entity2;
    }

    /**
     * Elimina una relacion.
     * @param idHospedaje Ide del hospedaje
     * @param IdLugarInteres Id del lugar
     */
    public void delete(Long idHospedaje, Long IdLugarInteres) {
        log.log(Level.INFO, "Eliminando un lugar hospedaje");
        em.remove(find(idHospedaje, IdLugarInteres));
        log.log(Level.FINE, "eliminado correctamente");
    }  
}
