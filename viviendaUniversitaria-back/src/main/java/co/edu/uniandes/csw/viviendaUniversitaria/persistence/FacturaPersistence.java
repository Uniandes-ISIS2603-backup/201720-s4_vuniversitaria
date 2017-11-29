/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author je.bejarano10
 */
@Stateless
public class FacturaPersistence extends GenericPresistence<FacturaEntity> {
    /**
     * Logger para registro de mensajes.
     */
    private static final Logger log = Logger.getLogger(FacturaPersistence.class.getName());
/**
 * Constructor por default
 */    
public FacturaPersistence()
{
    super(FacturaEntity.class);
}

public List<FacturaEntity> findIdEstudiante (Long idEstudiante)
{
    log.log(Level.INFO, "Consultando todas las facturas donde el estudiante tiene la cedula {0}", idEstudiante);
    TypedQuery tq = em.createQuery("select a from FacturaEntity a where a.estudiante.id = :idEstudiante", FacturaEntity.class);
    tq.setParameter("idEstudiante", idEstudiante);
    return tq.getResultList();
}
public List<FacturaEntity> findIdHospedaje (Long idHospedaje)
{
    log.log(Level.INFO, "Consultando todas las facturas donde el id del hospedaje es {0}", idHospedaje);
    TypedQuery tq = em.createQuery("select a from FacturaEntity a where a.hospedaje.id = :idHospedaje", FacturaEntity.class);
    tq.setParameter("idHospedaje", idHospedaje);
    return tq.getResultList();
}
}
