/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.LugaresInteresPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author jc.sanguino10
 */
@Stateless
public class LugaresInteresLogic {

    private static final Logger LOGGER = Logger.getLogger(LugaresInteresLogic.class.getName());
    
    @Inject
    private LugaresInteresPersistence persistence;
    @Inject
    private UbicacionLogic logicUbicacion;
    
    public List<LugaresInteresEntity> findAll() throws WebApplicationException {
        LOGGER.info("Inicio proceso busqueda de Lugar de interes");
        if (persistence.findAll() == null) {
            throw new WebApplicationException("no existen lugares de interes", 405);
        } else if (persistence.findAll().isEmpty()) {
            throw new WebApplicationException("no existen lugares de interes",405);
        } else {
            return persistence.findAll();
        }
    }

    public LugaresInteresEntity findIdLugarInteres(Long id) throws WebApplicationException {
        LOGGER.info("Inicio proceso busqueda de Lugar de interes");
        LugaresInteresEntity respuesta = persistence.findId(id);
        if (respuesta == null) {
            throw new WebApplicationException("no existe el lugar de interes con id:" + id, 405);
        }
        validacionNull(respuesta.getId());
        LOGGER.info("Fin de proceso de busqueda");
        return respuesta;

    }

    public LugaresInteresEntity createLugarInteres(LugaresInteresEntity entidad) throws WebApplicationException, BusinessLogicException {
        if(logicUbicacion.getUbicacion(entidad.getUbicacion().getId())!=null){
            throw new WebApplicationException("ya existe una ubicacion con este id",412);
        }
        else{
        UbicacionEntity ubicacionLugar = entidad.getUbicacion();
        ubicacionLugar.setLugaresInteres(entidad);        
        logicUbicacion.createUbicacion(entidad.getUbicacion());
        return persistence.create(entidad);
        }
        
    }

    public LugaresInteresEntity updateLugarInteres(LugaresInteresEntity entidad) throws WebApplicationException {
        if (entidad == null) {
            throw new WebApplicationException("ingrese un entity valido", 407);
        }
        LOGGER.info("Inicio proceso de actualizacion de Lugar de interes");
        Long id = entidad.getId();
        validacionNull(id);
        if (findIdLugarInteres(id) == null) {
            throw new WebApplicationException("el lugar con el id: " + id + "no existe", 405);
        }
        LOGGER.info("Finalizando proceso de actualización");
        return persistence.update(entidad);

    }

    public void delete(Long id) throws WebApplicationException, BusinessLogicException {
        validacionNull(id);
        LugaresInteresEntity lugarDelete = persistence.findId(id);
        if (lugarDelete == null) {
            //verifica que el servicio a actualizar exista
            throw new WebApplicationException("Ingrese el id de algun Lugar de interes existente",407);
        } else {
            
            logicUbicacion.deleteUbicacion(lugarDelete.getUbicacion().getId());
            persistence.delete(id);
        }
    }

    public void validacionNull(Long id) throws WebApplicationException {
        if (id == null) {
            //verifica que el servicio a actualizar exista
            throw new WebApplicationException("Ingrese el id del Lugar de interes",407);
        }
    }
    
}
