/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajePersistence;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ServiciosPersistence;
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
public class ServiciosLogic {

    @Inject
    private HospedajePersistence hospedajePersistence; // Variable para acceder a la persistencia de la aplicación.

    public List<ServiciosEntity> findAll(Long idHospedaje) throws WebApplicationException {

        List<ServiciosEntity> respuesta = hospedajePersistence.find(idHospedaje).getServicios();
        if (respuesta == null || respuesta.isEmpty()) {
            throw new WebApplicationException("No existen servicios en el hospedaje con id: " + idHospedaje, 404);
        } else {
            return respuesta;
        }
    }

    public ServiciosEntity findServicio(Long idHospedaje, Long idServicio) throws WebApplicationException {
        List<ServiciosEntity> listServicios = findAll(idHospedaje);
        ServiciosEntity servicioBuscado = null;
        for (int i = 0; i < listServicios.size() && servicioBuscado == null; i++) {
            if (listServicios.get(i).getId() == idServicio) {
                servicioBuscado = listServicios.get(i);
            }
        }
        if (servicioBuscado == null) {
            throw new WebApplicationException("el id del servicio ingresado no existe en el hospedaje con el id: " + idHospedaje, 404);
        } else {
            return servicioBuscado;
        }
    }

    public ServiciosEntity createServicio(Long idHospedaje, ServiciosEntity entidad) throws WebApplicationException {

        if (entidad.getId() == null) {
            throw new WebApplicationException("el servicio no cuenta con un id valido", 404);
        } else {
            entidad.setHospedaje(hospedajePersistence.find(idHospedaje));
            hospedajePersistence.find(idHospedaje).getServicios().add(entidad);
            return findServicio(idHospedaje, entidad.getId());
        }
    }

    public ServiciosEntity updateServicio(Long idHospedaje, Long id, ServiciosEntity entidad) throws WebApplicationException {
        if (findServicio(idHospedaje, id) == null) {
            throw new WebApplicationException("el servicio no cuenta con un id valido", 404);
        } else {
            int existe = hospedajePersistence.find(idHospedaje).getServicios().indexOf(findServicio(idHospedaje, id));
            if (existe < 0) {
                throw new WebApplicationException("no existe el servicio con id: " + id, 400);
            } else {
                return hospedajePersistence.updateServicio(idHospedaje, id, entidad);
            }
        }
    }

    public void delete(Long idHospedaje, Long idServicio) throws WebApplicationException {
        if (findServicio(idHospedaje, idServicio) == null) {
            throw new WebApplicationException("el servicio no cuenta con un id valido", 404);
        } else {
            int existe = hospedajePersistence.find(idHospedaje).getServicios().indexOf(findServicio(idHospedaje, idServicio));
            if (existe < 0) {
                throw new WebApplicationException("no existe el servicio con id: " + idServicio, 400);
            } else {
                hospedajePersistence.find(idHospedaje).getServicios().remove(existe);

            }
        }
    }
}
