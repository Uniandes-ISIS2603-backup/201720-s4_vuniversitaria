/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReglaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ReglaPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class ReglaLogic extends GenericLogic<ReglaEntity>
{
    private HospedajeLogic hospedajeLogic;

    public ReglaLogic() {
        super();
    }

    @Inject
    public ReglaLogic(ReglaPersistence reglaPersistence, HospedajeLogic hospedajeLogic) throws InstantiationException, IllegalAccessException {
        super(reglaPersistence, ReglaEntity.class);
        this.hospedajeLogic = hospedajeLogic;
    }

    public List<ReglaEntity> findAll(Long idHospedaje) throws WebApplicationException, BusinessLogicException {
        LOG.log(Level.INFO, "Consultando todas las reglas de un hospedaje. \nid:{0}", idHospedaje);
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if (hospedaje.getReglas() == null || hospedaje.getReglas().isEmpty()) {
            throw new WebApplicationException("Actualmente no existen reglas registradas.", 405);
        }
        return hospedaje.getReglas();
    }

    public ReglaEntity find(Long idHospedaje, Long idRegla) throws WebApplicationException {
        LOG.log(Level.INFO, "Actualizar la entidad con id: {0}", idRegla);
        if (!exist(idRegla)) {
            throw new WebApplicationException("No existe la regla con el id especificado", 405);
        }
        return ((ReglaPersistence)persistence).find(idHospedaje, idRegla);
    }

    public ReglaEntity create(Long idhospedaje, ReglaEntity entidad) throws WebApplicationException, BusinessLogicException {
        LOG.log(Level.INFO, "Creacion de una nueva entidad regla l hospedaje id: {0}", idhospedaje);
        if (!exist(entidad.getId())) {
            throw new WebApplicationException("Ya existe la regla con el id especificado", 405);
        }
        HospedajeEntity hospedaje = hospedajeLogic.find(idhospedaje);
        entidad.setHospedaje(hospedaje);
        return ((ReglaPersistence)persistence).create(entidad);
    }

    public ReglaEntity update(Long idhospedaje, ReglaEntity entidad) throws WebApplicationException, BusinessLogicException {
        LOG.log(Level.INFO, "Actualizar la entidad con id: {0}", entidad.getId());
        if (!exist(entidad.getId())) {
            throw new WebApplicationException("No existe la regla con el id especificado", 405);
        }
        HospedajeEntity hospedaje = hospedajeLogic.find(idhospedaje);
        entidad.setHospedaje(hospedaje);
        return ((ReglaPersistence)persistence).update(entidad);
    }

    public void delete(Long idhospedaje, Long idRegla) throws WebApplicationException {
        LOG.log(Level.INFO, "Actualizar la entidad con id: {0}", idRegla);
        if (!exist(idRegla)) {
            throw new WebApplicationException("No existe la regla con el id especificado", 405);
        }
        persistence.delete(find(idhospedaje, idRegla).getId());
    }
}
