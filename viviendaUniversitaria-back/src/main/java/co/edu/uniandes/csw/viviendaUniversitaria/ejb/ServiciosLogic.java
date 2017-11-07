/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ServicioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author jc.sanguino10
 */
@Stateless
public class ServiciosLogic extends GenericLogic<ServiciosEntity>{

    private HospedajeLogic hospedajeLogic; // Variable para acceder a la persistencia de la aplicación.
    
    public ServiciosLogic()
    {
        super();
    }
    
    @Inject
    public ServiciosLogic(ServicioPersistence servicioPersistence, HospedajeLogic hospedajeLogic) throws InstantiationException, IllegalAccessException {
        super(servicioPersistence, ServiciosEntity.class);
        this.hospedajeLogic = hospedajeLogic;
    }

    public List<ServiciosEntity> findAll(Long idHospedaje) throws WebApplicationException, BusinessLogicException {

        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        List<ServiciosEntity> respuesta = hospedaje.getServicios();
        if (respuesta == null || respuesta.isEmpty()) {
            throw new WebApplicationException("No existen servicios en el hospedaje con id: " + idHospedaje, 405);
        } else {
            return respuesta;
        }
    }

    public ServiciosEntity findServicio(Long idHospedaje, Long idServicio) throws WebApplicationException, BusinessLogicException {
        List<ServiciosEntity> listServicios = findAll(idHospedaje);
        ServiciosEntity servicioBuscado = null;
        for (int i = 0; i < listServicios.size() && servicioBuscado == null; i++) {
            if (listServicios.get(i).getId() == idServicio) {
                servicioBuscado = listServicios.get(i);
            }
        }
        if (servicioBuscado == null) {
            throw new WebApplicationException("el id del servicio ingresado no existe en el hospedaje con el id: " + idHospedaje, 405);
        } else {
            return servicioBuscado;
        }
    }

    public ServiciosEntity createServicio(Long idHospedaje, ServiciosEntity entidad) throws WebApplicationException, BusinessLogicException {
        if (entidad.getId() == null) {
            throw new WebApplicationException("el servicio no cuenta con un id valido", 407);
        } else {
            entidad.setHospedaje(hospedajeLogic.find(idHospedaje));
            hospedajeLogic.find(idHospedaje).getServicios().add(entidad);
            return findServicio(idHospedaje, entidad.getId());
        }

    }

    public ServiciosEntity updateServicio(Long idHospedaje, Long id, ServiciosEntity entidad) throws WebApplicationException, BusinessLogicException {
        if (findServicio(idHospedaje, id) == null) {
            throw new WebApplicationException("el servicio no cuenta con un id valido", 407);
        } else {
            ServiciosEntity old = findServicio(idHospedaje, id);
            entidad.setHospedaje(old.getHospedaje());
            entidad.setId(id);
            if(entidad.getDescripcion()==null || entidad.getDescripcion().equals(""))
            {
                entidad.setDescripcion(old.getDescripcion());
            }
            return persistence.update(entidad);
        }
    }

    public void delete(Long idHospedaje, Long idServicio) throws WebApplicationException, BusinessLogicException {
        if (findServicio(idHospedaje, idServicio) == null) {
            throw new WebApplicationException("el servicio no cuenta con un id valido", 407);
        } else {
            persistence.delete(idServicio);
        }
    }
}
