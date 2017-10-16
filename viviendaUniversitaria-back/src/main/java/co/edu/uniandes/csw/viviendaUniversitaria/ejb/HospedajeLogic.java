/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajePersistence;
import javax.ws.rs.WebApplicationException;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class HospedajeLogic extends GenericLogic<HospedajeEntity> {

    private UbicacionLogic ubicacionLogic;

    private CalificacionLogic calificacionLogic;

    /**
     * Constructor vacio
     */
    public HospedajeLogic() {
        super();
    }

    /**
     * Constructor inyectado
     * Injecta todos los parametros que se van a usar
     * @param persistenceHospedaje Mi persistencia, esta es la que se pasa al super
     * @param ubicacionLogic Esta es otra que estoy usando
     * @param calificacionLogic Esta es otra que estoy usando
     * @throws IllegalAccessException
     * @throws InstantiationException 
     */
    @Inject
    public HospedajeLogic(HospedajePersistence persistenceHospedaje, UbicacionLogic ubicacionLogic, CalificacionLogic calificacionLogic) throws IllegalAccessException, InstantiationException {
        super(persistenceHospedaje, HospedajeEntity.class);
        this.calificacionLogic = calificacionLogic;
        this.ubicacionLogic = ubicacionLogic;
    }

//    public HospedajeEntity agregarUbicacacion(Long idHospedaje, Long idUbicacion) throws WebApplicationException {
//        try {
//            HospedajeEntity hospedaje = find(idHospedaje);
//            UbicacionEntity ubicacion = ubicacionLogic.getUbicacion(idUbicacion);
//            if (ubicacion.getHospedaje() != null) {
//                throw new WebApplicationException("Esta ubicacion ya se encuentra sociada a un hospedaje.\nPor favor verifique la ubicacion he intente de nuevo.", 412);
//            }
//            ubicacion.setHospedaje(hospedaje);
//            return find(idHospedaje);
//        } catch (BusinessLogicException ble) {
//            throw new WebApplicationException(ble.getMessage(), 412);
//        }
//    }

    public HospedajeEntity agregarCalificacion(Long idHospedaje, Long idCalificacion) {
        HospedajeEntity hospedaje = find(idHospedaje);
        CalificacionEntity calificaicon = calificacionLogic.getCalificacion(idHospedaje);
        if (calificaicon.getHospedaje() != null) {
            throw new WebApplicationException("Esta calificacion ya se encuentra sociada a un hospedaje.\nPor favor verifique la ubicacion he intente de nuevo.", 412);
        }
        calificaicon.setHospedaje(actualizarVotacion(hospedaje, calificaicon));
        return find(idHospedaje);
    }

    private HospedajeEntity actualizarVotacion(HospedajeEntity hospedaje, CalificacionEntity calificacion) {
        hospedaje.setValoracion(((hospedaje.getValoracion() * hospedaje.getCantidadVotaciones()) + calificacion.getValoracion()) / (hospedaje.getCantidadVotaciones() + 1));
        hospedaje.setCantidadVotaciones(hospedaje.getCantidadVotaciones() + 1);
        return update(hospedaje, hospedaje.getId());
    }
}
