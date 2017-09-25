/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;

/**
 *
 * @author jc.sanguino10
 */
public class LugaresInteresDTO {

    /**
     * Atributo donde se describe la ubicacion de un lugar de interes
     */

    // private UbicacionEntity ubicacion;
    //private List<HospedajeLugarEntity> hospedajesLugares;
    /**
     * id del Lugar de Interes
     */
    private Long id;
    /**
     * Atributo que modela algunos comentarios del propietario sobre su
     * hospedaje
     */
    private String descripcion;
    /**
     * Modela la distancia desde el lugar de interes al hospedaje
     */
    private double distancia;
    /**
     * Imagen del lugar de interes
     */
    private String rutaImagen;

    /**
     * Constructor por defecto
     */
    public LugaresInteresDTO() {

    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param lugarInteres: Es la entidad que se va a convertir a DTO
     */
    public LugaresInteresDTO(LugaresInteresEntity lugarInteres) {
        this.descripcion = lugarInteres.getDescripcion();
        this.id = lugarInteres.getId();
        this.rutaImagen = lugarInteres.getRutaImagen();
        this.distancia = lugarInteres.getDistancia();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public LugaresInteresEntity toEntity() {
        LugaresInteresEntity lugaresInteresEntity = new LugaresInteresEntity();
        lugaresInteresEntity.setDescripcion(this.descripcion);
        lugaresInteresEntity.setDistancia(this.distancia);
        lugaresInteresEntity.setRutaImagen(this.rutaImagen);
        lugaresInteresEntity.setId(this.id);
        return lugaresInteresEntity;
    }

}
