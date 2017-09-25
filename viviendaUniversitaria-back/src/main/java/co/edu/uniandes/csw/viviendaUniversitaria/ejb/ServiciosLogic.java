/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ServiciosPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jc.sanguino10
 */
@Stateless
public class ServiciosLogic {

    private static final Logger LOGGER = Logger.getLogger(ServiciosLogic.class.getName());

    @Inject
    private ServiciosPersistence persistence; // Variable para acceder a la persistencia de la aplicación.

    public ServiciosEntity findServicio(Long id) throws BusinessLogicException {
        LOGGER.info("Inicio proceso busqueda de servicio");
        ServiciosEntity respuesta = persistence.findId(id);
        ValidacionNull(respuesta.getId());
        LOGGER.info("Fin de proceso de busqueda");
        return respuesta;

    }

    public ServiciosEntity createServicio(ServiciosEntity entidad) throws BusinessLogicException {
        LOGGER.info("Inicio proceso creación de servicio");
        Long id = entidad.getId();
        ValidacionNull(id);
        if (persistence.findId(id) != null) {
            // se verifica que no exista ya un servicio con ese id
            throw new BusinessLogicException("Ya existe un Servicio con el id: " + id);
        } else {
            persistence.create(entidad);
            LOGGER.info("Fin de proceso de creación");
            return entidad;
        }
    }

    public ServiciosEntity updateServicio(ServiciosEntity entidad) throws BusinessLogicException {
        LOGGER.info("Inicio proceso de actualizacion de servicio");
        Long id = entidad.getId();
        ValidacionNull(id);

        LOGGER.info("Finalizando proceso de actualización");
        return persistence.update(entidad);

    }

    public void delete(Long id) throws BusinessLogicException {
        ValidacionNull(id);
        if (persistence.findId(id) == null) {
            //verifica que el servicio a actualizar exista
            throw new BusinessLogicException("Ingrese el id de algun servicio existente");
        } else {
            persistence.delete(id);
        }
    }

    public void ValidacionNull(Long id) throws BusinessLogicException {
        if (id == null) {
            //verifica que el servicio a actualizar exista
            throw new BusinessLogicException("Ingrese el id del servicio");
        }
    }
}
