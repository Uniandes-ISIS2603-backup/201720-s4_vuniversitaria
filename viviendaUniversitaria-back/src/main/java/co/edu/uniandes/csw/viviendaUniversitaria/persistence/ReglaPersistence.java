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
 *
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

    /**
     * Consulta la regla de acuerdo a el hospedaje.
     *
     * @param idHospedaje Id del hospedaje especificado.
     * @param id Id de la regla a buscar.
     * @return Retorna la regla buscada. Null en caso de no encontrarla.
     */
    public ReglaEntity find(Long idHospedaje, Long id) {
        LOG.log(Level.INFO, "Consultando regla con id={0}", id);
        TypedQuery<ReglaEntity> q = em.createQuery("select p from ReglaEntity p where (p.hospedaje.id = :idHospedaje) and (p.id = :idRegla)", ReglaEntity.class);
        q.setParameter("idHospedaje", idHospedaje);
        q.setParameter("idRegla", id);
        List<ReglaEntity> results = q.getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        }
        return null;
    }

}
