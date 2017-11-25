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
 * Logica de la regla.
 * @author ws.duarte
 */
@Stateless
public class ReglaLogic extends GenericLogic<ReglaEntity> {
    
    /**
     * Logica de un hospedaje.
     */
    private HospedajeLogic hospedajeLogic;
    
    /**
     * Construle una regla con el constructor por defecto.
     */
    public ReglaLogic() {
        super();
    }
    
    /**
     * Construlle una regla inyectando los parametros especificado.
     * @param reglaPersistence Persistencia de regla.
     * @param hospedajeLogic Logica del hospedaje
     * @throws InstantiationException Error si no se instancia
     * @throws IllegalAccessException Error si no puede acceder
     */
    @Inject
    public ReglaLogic(ReglaPersistence reglaPersistence, HospedajeLogic hospedajeLogic) throws InstantiationException, IllegalAccessException {
        super(reglaPersistence, ReglaEntity.class);
        this.hospedajeLogic = hospedajeLogic;
    }    
    
    /**
     * Consulta todas las reglas de un hopedaje.
     * @param idHospedaje id del hospedaje
     * @return Listade reglas del hoepdaje
     * @throws WebApplicationException Ni no har reglas para eso
     * @throws BusinessLogicException Si cuando consulto de persistencia tibo problemas.
     */
    public List<ReglaEntity> findAll(Long idHospedaje) throws WebApplicationException, BusinessLogicException {
        log.log(Level.INFO, "Consultando todas las reglas de un hospedaje. \nid:{0}", idHospedaje);
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if (hospedaje.getReglas() == null || hospedaje.getReglas().isEmpty()) {
            throw new WebApplicationException("Actualmente no existen reglas registradas.", 405);
        }
        return hospedaje.getReglas();
    }
    
    /**
     * Crea una nieva regla.
     * @param idhospedaje id del hospedaj
     * @param entidad regla a crear
     * @return Regla creada.
     * @throws WebApplicationException Si ya exsiste una regla 
     * @throws BusinessLogicException  Si no puede consultar por resistencia.
     */
    public ReglaEntity create(Long idhospedaje, ReglaEntity entidad) throws WebApplicationException, BusinessLogicException {
        log.log(Level.INFO, "Creacion de una nueva entidad regla l hospedaje id: {0}", idhospedaje);
        if (entidad.getId() != null && exist(entidad.getId())) {
            throw new WebApplicationException("Ya existe la regla con el id especificado", 405);
        }
        HospedajeEntity hospedaje = hospedajeLogic.find(idhospedaje);
        entidad.setHospedaje(hospedaje);
        return ((ReglaPersistence) persistence).create(entidad);
    }
    
    /**
     * Actuliza una regla
     * @param idhospedaje id del hospedaje de regla
     * @param entidad Nueva regla
     * @return Regla modificada
     * @throws WebApplicationException No existe regla
     * @throws BusinessLogicException  Si no puede consultar la regla o el hospedaje
     */
    public ReglaEntity update(Long idhospedaje, ReglaEntity entidad) throws WebApplicationException, BusinessLogicException {
        log.log(Level.INFO, "Actualizar la entidad con id: {0}", entidad.getId());
        if (!exist(entidad.getId())) {
            throw new WebApplicationException("No existe la regla con el id especificado", 405);
        }
        HospedajeEntity hospedaje = hospedajeLogic.find(idhospedaje);
        entidad.setHospedaje(hospedaje);
        return ((ReglaPersistence) persistence).update(entidad);
    }
    
    /**
     * Consulta una regla especifica.
     * @param idHospedaje id hospedaje 
     * @param idRegla id regla.
     * @return regla especifica
     * @throws WebApplicationException  Si no existe la regla.
     */
    public ReglaEntity find(Long idHospedaje, Long idRegla) throws WebApplicationException {
        log.log(Level.INFO, "Actualizar la entidad con id: {0}", idRegla);
        if (!exist(idRegla)) {
            throw new WebApplicationException("No existe la regla con el id especificado", 405);
        }
        return ((ReglaPersistence) persistence).find(idHospedaje, idRegla);
    }
    
    /**
     * Elimina una regla
     * @param idhospedaje id del hospedaje
     * @param idRegla id de la regla
     * @throws WebApplicationException no existe una regla con el hospedaje
     * @throws BusinessLogicException Tiene problemas con la consulta.
      */
    public void delete(Long idhospedaje, Long idRegla) throws WebApplicationException, BusinessLogicException {
        log.log(Level.INFO, "Actualizar la entidad con id: {0}", idRegla);
        if (!exist(idRegla)) {
            throw new WebApplicationException("No existe la regla con el id especificado", 405);
        }
        hospedajeLogic.find(idhospedaje).getReglas().remove(find(idRegla));
    }
}
