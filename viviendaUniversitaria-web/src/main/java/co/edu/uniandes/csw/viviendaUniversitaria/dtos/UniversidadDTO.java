/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;

/**
 *
 * @author c.santacruza
 */
public class UniversidadDTO {

    /**
     * Modela el id del de la universidad.
     */
    private Long id;
    /**
     * Modela el nombre de la universidad.
     */
    private String name;
    /**
     * Modela la imagen de la universidad.
     */
    private String imagen;

    /**
     * Contructor vacio.
     */
    public UniversidadDTO() {
        //Vacio por default

    }

    /**
     * Contructor normal.
     *
     * @param entity
     */
    public UniversidadDTO(UniversidadEntity entity) {
        this.id = entity.getId();
        this.name = entity.getNombre();
        this.imagen = entity.getUrlImagen();

    }

    /**
     *Retorna la imagen de la universidad.
     * @return
     */
    public String getImagen() {
        return imagen;
    }
    /**
     * Retorna el nombre de la universidad.
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Retorna el id de la universidad.
     * @return 
     */
    public Long getId() {   
        return id;
    }
    /**
     * Modifica la imagen de la universidad
     * @param imagen 
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    /**
     * Modifica el id de la universidad.
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Modifica el nombre de la universidad.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public UniversidadEntity toEntity() {
        UniversidadEntity entity = new UniversidadEntity();
        entity.setId(this.id);
        entity.setNombre(this.name);
        entity.setUrlImagen((this.imagen));

        return entity;
    }
}
