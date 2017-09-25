/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.LugaresInteresPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author jc.sanguino10
 */
@Stateless
public class LugaresInteresLogic {

    private static final Logger LOGGER = Logger.getLogger(LugaresInteresLogic.class.getName());
    
    private LugaresInteresPersistence persistence;
    
    public LugaresInteresEntity findIdLugarInteres(Long id) throws BusinessLogicException {
        LOGGER.info("Inicio proceso busqueda de Lugar de interes");
        LugaresInteresEntity respuesta = persistence.findId(id);
        ValidacionNull(respuesta.getId());
        LOGGER.info("Fin de proceso de busqueda");
        return respuesta;
        
    }
    
    public LugaresInteresEntity createLugarInteres(LugaresInteresEntity entidad) throws BusinessLogicException {
        LOGGER.info("Inicio proceso creación de Lugar de interes");
        Long id = entidad.getId();
        ValidacionNull(id);
        if (persistence.findId(id) != null) {
            // se verifica que no exista ya un servicio con ese id
            throw new BusinessLogicException("Ya existe un Lugar de interes con el id: " + id);
        } else {
            persistence.create(entidad);
            LOGGER.info("Fin de proceso de creación");
            return entidad;
        }
    }
    
    public LugaresInteresEntity updateLugarInteres(LugaresInteresEntity entidad) throws BusinessLogicException {
        LOGGER.info("Inicio proceso de actualizacion de Lugar de interes");
        Long id = entidad.getId();
        ValidacionNull(id);
        LOGGER.info("Finalizando proceso de actualización");
        return persistence.update(entidad);
        
    }
    
    public void delete(Long id) throws BusinessLogicException {
        ValidacionNull(id);
        if (persistence.findId(id) == null) {
            //verifica que el servicio a actualizar exista
            throw new BusinessLogicException("Ingrese el id de algun Lugar de interes existente");
        } else {
            persistence.delete(id);
        }
    }

    public void ValidacionNull(Long id) throws BusinessLogicException {
        if (id == null) {
            //verifica que el servicio a actualizar exista
            throw new BusinessLogicException("Ingrese el id del Lugar de interes");
        }
    }
    
}
