/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReservaEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author je.bejarano10
 */
public class ReservaDTO {
 private Long id;
    private int cedulaHuesped;
    private int idHospedaje;
    private String fechaInicio;
    private String fechaFin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCedulaHuesped() {
        return cedulaHuesped;
    }

    public void setCedulaHuesped(int cedulaHuesped) {
        this.cedulaHuesped = cedulaHuesped;
    }

    public int getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(int idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
    
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    

    /**
     * 
     */
    public ReservaDTO() {
    }

    /**
     * Crea un objeto AuthorDTO a partir de un objeto AuthorEntity.
     *
     * @param entity Entidad AuthorEntity desde la cual se va a crear el nuevo
     * objeto.
     * 
     */
    public ReservaDTO(ReservaEntity entity) {
        if (entity != null) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
            this.id = entity.getId();
            this.cedulaHuesped = entity.getCedulaHuesped();
            this.idHospedaje = entity.getIdHospedaje();
          
            this.fechaInicio = formato.format(entity.getFechaInicio());
            this.fechaFin = formato.format(entity.getFechaFin());
        }
    }

    /**
     * Convierte un objeto AuthorDTO a AuthorEntity.
     *
     * @return Nueva objeto AuthorEntity.
     * 
     */
    public ReservaEntity toEntity() {
     
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
         ReservaEntity entity = new ReservaEntity();
         entity.setId(this.id);
         entity.setIdHospedaje(this.idHospedaje);
         entity.setCedulaHuesped(this.cedulaHuesped);
         try{
         entity.setFechaInicio(formato.parse(this.fechaInicio));}
         catch(ParseException e)
         {
             Logger.getLogger(ReservaDTO.class.getName()).log(Level.SEVERE, null, e);
         }
         try{
         entity.setFechaFin(formato.parse(this.fechaFin));
         }
         catch(ParseException ex)
         {
             Logger.getLogger(ReservaDTO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return entity;
    }
}
