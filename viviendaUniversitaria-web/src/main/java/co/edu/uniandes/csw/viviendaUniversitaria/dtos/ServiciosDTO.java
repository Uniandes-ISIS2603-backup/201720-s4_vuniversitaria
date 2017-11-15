/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;

/**
 *
 * @author jc.sanguino10
 */
public class ServiciosDTO {

    /**
     * id del servicio
     */
    private Long id;
    /**
     * Descripcion del servicio prestado
     */
    private String descripcion;
    /**
     * Costo por adquirir el servicio, 0 en caso de venir incluido con el
     * hospedaje
     */

    private double costo;

    /**
     * Constructor por defecto
     */
    public ServiciosDTO() {
        //vacio por default

    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param servicio: Es la entidad que se va a convertir a DTO
     */
    public ServiciosDTO(ServiciosEntity servicio) {
        this.costo = servicio.getCosto();
        this.descripcion = servicio.getDescripcion();
        this.id = servicio.getId();
    }

    /**
     * Retorna el id del dto servicios
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el id del dto servicios
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna la descripcion del dto servicios
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripcion del dto servicios
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Retorna el costo del dto servicios
     *
     * @return costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Cambia el costo del dto servicios
     *
     * @param costo
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Transforma del dto servicios a un entity
     *
     * @return ServiciosEntity
     */
    public ServiciosEntity toEntity() {
        ServiciosEntity servicioEntity = new ServiciosEntity();
        servicioEntity.setCosto(this.costo);
        servicioEntity.setDescripcion(this.descripcion);
        servicioEntity.setId(this.id);

        return servicioEntity;
    }

}
