/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;

import javax.ejb.Stateless;

/**
 *
 * @author NOA_WERMEID
 */
@Stateless
public class HospedajePersistence extends GenericPresistence<HospedajeEntity> {

    /**
     * Construye el generico para la clase especificada.
     */
    public HospedajePersistence() {
        super(HospedajeEntity.class);
    }

    /**
     * Actualiza el servicio especificado para el servicio especificado.
     * @param idHospedaje Hospedaje al que se le actualiza el servicio.
     * @param id Id del servicio.
     * @param entity Entidad con la información nueva.
     * @return Retorna el servicio modificado.
     */
    public ServiciosEntity updateServicio(Long idHospedaje, Long id, ServiciosEntity entity) {
        HospedajeEntity hospedaje = find(idHospedaje);
        int i = hospedaje.getServicios().indexOf(entity);
        entity.setHospedaje(find(idHospedaje));
        hospedaje.getServicios().set(i, entity);
        em.merge(hospedaje);
        return entity;
    }

}
