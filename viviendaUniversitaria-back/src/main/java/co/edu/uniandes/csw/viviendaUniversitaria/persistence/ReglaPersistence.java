/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.*;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * Persistencia de la entidad regla.
 * @author NOA_WERMEID
 */
@Stateless
public class ReglaPersistence extends GenericPresistence<ReglaEntity> {

    /**
     * Construye el generico para la clase especificada.
     */
    public ReglaPersistence() {
        super(ReglaEntity.class);
    }
    
    public ReglaEntity find(Long idHospedaje, Long id) {
        LOG.log(Level.INFO, "Consultando regla con id={0}", id);
        TypedQuery<ReglaEntity> q = em.createQuery("select p from ReglaEntity p where (p.hospedaje.id = :idHospedaje) and (p.id = :idRegla)", ReglaEntity.class);
        q.setParameter("idHospedaje", idHospedaje);
        q.setParameter("idRegla", id);
        List<ReglaEntity> results = q.getResultList();
        ReglaEntity regla = null;
        if (results == null) {
            regla = null;
        } else if (results.isEmpty()) {
            regla = null;
        } else if (results.size() >= 1) {
            regla = results.get(0);
        }
        return regla;
    }
}
