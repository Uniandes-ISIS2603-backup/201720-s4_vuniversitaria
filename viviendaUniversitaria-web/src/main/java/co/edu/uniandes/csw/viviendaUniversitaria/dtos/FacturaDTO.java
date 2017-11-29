/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.dtos;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author je.bejarano10
 */
public class FacturaDTO {

    private Long id;
    private String fecha;
    private double total;
    private double iva;
    private boolean estaPago;

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
   public FacturaDTO(){
       
   }

    /**
     * Crea un objeto AuthorDTO a partir de un objeto AuthorEntity.
     *
     * @param entity Entidad AuthorEntity desde la cual se va a crear el nuevo
     * objeto.
     * 
     */
    public FacturaDTO(FacturaEntity entity) {
        if (entity != null) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            this.id = entity.getId();
            if(entity.getFecha()!=null)
            {
            this.fecha=formato.format(entity.getFecha());
            }
            this.iva=entity.getIva();
            this.total=entity.getTotal();
            this.estaPago=entity.isEstaPago();
        }
    }

    /**
     * Convierte un objeto AuthorDTO a AuthorEntity.
     *
     * @return Nueva objeto AuthorEntity.
     * 
     */
    public FacturaEntity toEntity() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        FacturaEntity entity = new FacturaEntity();
        entity.setId(this.id);
        entity.setIva(this.iva);
        entity.setTotal(this.total);
        entity.setEstaPago(estaPago);
        if(entity.getFecha() != null)
        {
        try {
            entity.setFecha(formato.parse(fecha));
        } catch (ParseException ex) {
            Logger.getLogger(FacturaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return entity;
    }

}
