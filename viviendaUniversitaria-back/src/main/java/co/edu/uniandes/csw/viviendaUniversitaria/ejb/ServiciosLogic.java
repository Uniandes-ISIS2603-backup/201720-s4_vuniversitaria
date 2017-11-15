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
public class ServiciosLogic extends GenericLogic<ServiciosEntity> {

    /*
    * Variable para acceder a la persistencia de la aplicación.
     */
    private HospedajeLogic hospedajeLogic;

    /**
     * Constructor por defecto, necesario para el uso del Generic
     */
    public ServiciosLogic() {
        super();
    }

    /**
     * Constructor de la clase
     *
     * @param servicioPersistence
     * @param hospedajeLogic
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Inject
    public ServiciosLogic(ServicioPersistence servicioPersistence, HospedajeLogic hospedajeLogic) throws InstantiationException, IllegalAccessException {
        super(servicioPersistence, ServiciosEntity.class);
        this.hospedajeLogic = hospedajeLogic;
    }

    /**
     * Obtiene los servicios de un hospedaje en especifico
     *
     * @param idHospedaje
     * @returnLista de servicios de un hospedaje en especifico
     * @throws WebApplicationException
     * @throws BusinessLogicException
     */
    public List<ServiciosEntity> findAll(Long idHospedaje) throws WebApplicationException, BusinessLogicException {

        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        List<ServiciosEntity> respuesta = hospedaje.getServicios();
        if (respuesta == null || respuesta.isEmpty()) {
            throw new WebApplicationException("No existen servicios en el hospedaje con id: " + idHospedaje, 405);
        } else {
            return respuesta;
        }
    }

    /**
     * Retorna un servicio de un hospedaje en especifico
     *
     * @param idHospedaje
     * @param idServicio
     * @return Un servicio
     * @throws WebApplicationException
     * @throws BusinessLogicException
     */
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

    /**
     * Crea un servicio en un hospedaje especifico
     *
     * @param idHospedaje
     * @param entidad
     * @return
     * @throws WebApplicationException
     * @throws BusinessLogicException
     */
    public ServiciosEntity createServicio(Long idHospedaje, ServiciosEntity entidad) throws BusinessLogicException {
        if (entidad.getId() == null) {
            throw new WebApplicationException("el servicio no cuenta con un id valido", 407);
        } else {
            entidad.setHospedaje(hospedajeLogic.find(idHospedaje));
            hospedajeLogic.find(idHospedaje).getServicios().add(entidad);
            return findServicio(idHospedaje, entidad.getId());
        }

    }

    /**
     * Actualiza el servicio de un hospedaje
     *
     * @param idHospedaje
     * @param id
     * @param entidad
     * @return servicio actualizado
     * @throws BusinessLogicException
     */
    public ServiciosEntity updateServicio(Long idHospedaje, Long id, ServiciosEntity entidad) throws BusinessLogicException {
        if (findServicio(idHospedaje, id) == null) {
            throw servicioIdInvalido();
        } else {
            ServiciosEntity old = findServicio(idHospedaje, id);
            entidad.setHospedaje(old.getHospedaje());
            entidad.setId(id);
            if (entidad.getDescripcion() == null) {
                entidad.setDescripcion(old.getDescripcion());
            }
            return persistence.update(entidad);
        }
    }
        /**
         * Elimina el servicio de un hospedaje en especifico
         *
         * @param idHospedaje
         * @param idServicio
         * @throws BusinessLogicException
         */
    public void delete(Long idHospedaje, Long idServicio) throws BusinessLogicException {
        if (findServicio(idHospedaje, idServicio) == null) {
            throw servicioIdInvalido();
        } else {
            persistence.delete(idServicio);
        }
    }

    /**
     * Lanza una excepcion si no encuentra un servicio con el id indicado
     * @return WebApplicationException
     */
    public WebApplicationException servicioIdInvalido() {
       return new WebApplicationException("el servicio no cuenta con un id valido", 407);
    }
}
