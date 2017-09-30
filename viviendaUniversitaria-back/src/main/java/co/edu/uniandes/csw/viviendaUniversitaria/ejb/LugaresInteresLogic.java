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
    
    public List<LugaresInteresEntity> findAll() throws BusinessLogicException {
        LOGGER.info("Inicio proceso busqueda de Lugar de interes");
        if (persistence.findAll() == null) {
            throw new BusinessLogicException("no existen lugares de interes");
        } else if (persistence.findAll().isEmpty()) {
            throw new BusinessLogicException("no existen lugares de interes");
        } else {
            return persistence.findAll();
        }
    }

    public LugaresInteresEntity findIdLugarInteres(Long id) throws BusinessLogicException {
        LOGGER.info("Inicio proceso busqueda de Lugar de interes");
        LugaresInteresEntity respuesta = persistence.findId(id);
        if (respuesta == null) {
            throw new BusinessLogicException("no existe el lugar de interes con id:" + id);
        }
        validacionNull(respuesta.getId());
        LOGGER.info("Fin de proceso de busqueda");
        return respuesta;

    }

    public LugaresInteresEntity createLugarInteres(LugaresInteresEntity entidad, Long id) throws BusinessLogicException {
        LOGGER.info("Inicio proceso creación de Lugar de interes");
        System.out.println("co.edu.uniandes.csw.viviendaUniversitaria.ejb.LugaresInteresLogic.createLugarInteres()  -           frgtyhgfdfghjhgfdfghjkjhgfdfghjkjhgfdsdfghjhgfdfg");
        Long idEntity = entidad.getId();
        validacionNull(idEntity);
        validacionNull(id);
        if (persistence.findId(idEntity) != null) {
            // se verifica que no exista ya un servicio con ese id
            throw new BusinessLogicException("Ya existe un Lugar de interes con el id: " + idEntity);
        } else if(logicUbicacion.getUbicacion(id)==null){
            throw new BusinessLogicException("No existe una Ubacacion con el id: " + id);
        }else {          
            persistence.create(entidad);
            asignarUbicacion(id,idEntity);
            LOGGER.info("Fin de proceso de creación");
            return entidad;
        }
    }

    public LugaresInteresEntity updateLugarInteres(LugaresInteresEntity entidad) throws BusinessLogicException {
        if (entidad == null) {
            throw new BusinessLogicException("ingrese un entity valido");
        }
        LOGGER.info("Inicio proceso de actualizacion de Lugar de interes");
        Long id = entidad.getId();
        validacionNull(id);
        if (findIdLugarInteres(id) == null) {
            throw new BusinessLogicException("el lugar con el id: " + id + "no existe");
        }
        LOGGER.info("Finalizando proceso de actualización");
        return persistence.update(entidad);

    }

    public void delete(Long id) throws BusinessLogicException {
        validacionNull(id);
        if (persistence.findId(id) == null) {
            //verifica que el servicio a actualizar exista
            throw new BusinessLogicException("Ingrese el id de algun Lugar de interes existente");
        } else {
            persistence.delete(id);
        }
    }

    public void validacionNull(Long id) throws BusinessLogicException {
        if (id == null) {
            //verifica que el servicio a actualizar exista
            throw new BusinessLogicException("Ingrese el id del Lugar de interes");
        }
    }
    public LugaresInteresEntity asignarUbicacion(Long idUbicacion, Long idLugar) throws WebApplicationException
    {
        try {
           LugaresInteresEntity lugar = findIdLugarInteres(idLugar);
            UbicacionEntity ubicacion = logicUbicacion.getUbicacion(idUbicacion);
            System.out.println(ubicacion+"====================================================================================================");
            if(ubicacion==null) throw new WebApplicationException("Esta ubicacion ya se encuentra sociada a un lugar de interes.\nPor favor verifique la ubicacion he intente de nuevo.", 412);
            if(ubicacion.getLugaresInteres() != null) throw new WebApplicationException("Esta ubicacion ya se encuentra sociada a un lugar de interes.\nPor favor verifique la ubicacion he intente de nuevo.", 412);
            ubicacion.setLugaresInteres(lugar);
            lugar.setUbicacion(ubicacion);
            return findIdLugarInteres(idLugar);
        } catch (BusinessLogicException ble) {
            throw new WebApplicationException(ble.getMessage(), 412);
        }
    }
}
