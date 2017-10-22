/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajePersistence;
import java.util.logging.Level;
import javax.ws.rs.WebApplicationException;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class HospedajeLogic extends GenericLogic<HospedajeEntity> {

    private CalificacionLogic calificacionLogic;

    /**
     * Constructor vacio
     */
    public HospedajeLogic() {
        super();
    }

    /**
     * Constructor inyectado Injecta todos los parametros que se van a usar
     *
     * @param persistenceHospedaje Mi persistencia, esta es la que se pasa al super
     * @param calificacionLogic Esta es otra que estoy usando
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Inject
    public HospedajeLogic(HospedajePersistence persistenceHospedaje, CalificacionLogic calificacionLogic) throws IllegalAccessException, InstantiationException {
        super(persistenceHospedaje, HospedajeEntity.class);
        this.calificacionLogic = calificacionLogic;
    }

    @Override
    public HospedajeEntity create(HospedajeEntity entity) throws BusinessLogicException {
        if (entity.getCantidadVotaciones() != null || entity.getValoracion() != null) {
            LOG.log(Level.SEVERE,"Violacion de la regla de negocio. No se puede inicializar un hospedaje con votos");
            throw new WebApplicationException("No se puede modificar los datos de la valoreacion del hospedaje", 412);
        }
        entity.setValoracion(0.0);
        entity.setCantidadVotaciones(0);
        return super.create(entity); 
    }

    @Override
    public HospedajeEntity update(HospedajeEntity entity, Long id) throws WebApplicationException {
        if (entity.getCantidadVotaciones() != null || entity.getValoracion() != null) {
            LOG.log(Level.SEVERE,"Violacion de la regla de negocio. Actulizacionde la la valotacion o la cantiadad de votos");
            throw new WebApplicationException("No se puede modificar los datos de la valoreacion del hospedaje", 412);
        }
        HospedajeEntity oldEntity = persistence.find(id);
        if (oldEntity != null) {
            entity.setReglas(oldEntity.getReglas());
            entity.setServicios(oldEntity.getServicios());
            entity.setHospedajesLugares(oldEntity.getHospedajesLugares());
            entity.setFacturas(oldEntity.getFacturas());
            entity.setReservas(oldEntity.getReservas());
            entity.setArrendador(oldEntity.getArrendador());
            entity.setUbicacion(oldEntity.getUbicacion());
            entity.setValoracion(oldEntity.getValoracion());
            entity.setCantidadVotaciones(oldEntity.getCantidadVotaciones());
            if (entity.getTipoArrendamiento() == null) {
                entity.setTipoArrendamiento(oldEntity.getTipoArrendamiento());
            }
            if (entity.getDescripcion() == null) {
                entity.setDescripcion(oldEntity.getDescripcion());
            }
        }
        return super.update(entity, id);
    }

    public HospedajeEntity agregarCalificacion(Long idHospedaje, Long idCalificacion) throws BusinessLogicException {
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
