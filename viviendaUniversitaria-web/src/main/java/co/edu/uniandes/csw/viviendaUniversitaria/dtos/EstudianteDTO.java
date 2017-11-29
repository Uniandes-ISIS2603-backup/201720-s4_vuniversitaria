/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;

/**
 *
 * @author a.eslava
 */
public class EstudianteDTO {
    private Long id;
    private Long cedula;  
    private String nombre;
    private OrigenDTO origenDTO;
    private String nombreOrigen;
    /**
     * Nombre de usuario
     */
    private String nombreUsuario;
    
    /**
     * Conrasenia de usuario
     */
    private String contrasenia;
    
    private String rutaImagen;
    
    
    public EstudianteDTO(){
        //Constructor por defecto        
    }
    
    public EstudianteDTO(EstudianteEntity estudiante) {
        if (estudiante != null) {
            this.nombre = estudiante.getNombre();
            this.cedula = estudiante.getCedula();
            this.id = estudiante.getId();
            nombreUsuario = estudiante.getNombreUsuario();
            contrasenia = estudiante.getContrasenia();
            rutaImagen = estudiante.getRutaImagen();
            nombreOrigen = estudiante.getNombreOrigen();
        }
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    
     public EstudianteEntity toEntity() {

        EstudianteEntity estu = new EstudianteEntity();
        estu.setNombre(this.nombre);
        estu.setCedula(this.cedula);
        estu.setContrasenia(contrasenia);
        estu.setNombreUsuario(nombreUsuario);
        estu.setRutaImagen(rutaImagen);
        estu.setNombreOrigen(nombreOrigen);

     
        return estu;
    }

    public OrigenDTO getOrigenDTO() {
        return origenDTO;
    }

    public void setOrigenDTO(OrigenDTO origenDTO) {
        this.origenDTO = origenDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
    
    /**
     * Retorna la contrasenuia de usuario.
     * @return contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Cambia la contrasenia de usuario.
     * @param Contrasenia nueva contrasenia.
     */
    public void setContrasenia(String Contrasenia) {
        this.contrasenia = Contrasenia;
    }

    /**
     * Retorna el nombre de usuario
     * @return nombre de usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Cmbia el nombre de susario
     * @param nombreUsuario nuevo nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }
    
}
