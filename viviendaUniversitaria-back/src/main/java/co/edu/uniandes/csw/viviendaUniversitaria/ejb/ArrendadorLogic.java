/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ArrendadorPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author kk.penaranda
 */
@Stateless
public class ArrendadorLogic {
    private static final Logger LOGGER = Logger.getLogger(ArrendadorLogic.class.getName());

    private ArrendadorPersistence persistence;  
    
    private HospedajeLogic hospedajeLogic;
    
    public ArrendadorLogic(){
        //Constructor por defecto
    }
    
    @Inject
    public ArrendadorLogic(ArrendadorPersistence persistence, HospedajeLogic hospedajeLogic){
        this.persistence= persistence;
        this.hospedajeLogic= hospedajeLogic;
    }
        
    public ArrendadorEntity createArrendador(ArrendadorEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de arrendador");
        if (persistence.find(entity.getId())!= null)
            throw new BusinessLogicException("Ya existe un Arrendador con el id \"" + entity.getId()+"\"");
        if(entity.getId()<10000)
            throw new WebApplicationException("El identificador es un documento de identidad por lo que debe tener mas de 5 digitos", 412);
           
        if(entity.getId()<0) 
            throw new WebApplicationException("El id no puede ser un número negativo", 412);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de un arrendador");
        return entity;
    }
    
        public List<ArrendadorEntity> getArrendadores() {
        LOGGER.info("Inicia proceso de consultar todos los arrendadores");
        List<ArrendadorEntity> arrendadores = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los arrendadores");
        return arrendadores;
    }
        
        public ArrendadorEntity getArrendador(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar arrendador con id={0}", id);
        ArrendadorEntity arrendador = persistence.find(id);
        if (arrendador == null) {
            LOGGER.log(Level.SEVERE, "El arrendador con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar arrendador con id={0}", id);
        return arrendador;
    }

    public ArrendadorEntity updateArrendador(Long id, ArrendadorEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar arrendador con id={0}", id);
        ArrendadorEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar arrendador con id={0}", entity.getId());
        return newEntity;
    }
    
    public void deleteArrendador(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar arrendador con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar arrendador con id={0}", id);
    }
    
    
    
    public List<HospedajeEntity> getHospedajesArrendador(Long arrendadorId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los hospedajes del arrendador con id = {0}", arrendadorId);
        return getArrendador(arrendadorId).getHospedajes();
    }
    
    public HospedajeEntity getHospedajeIdArrendador(Long arrendadorId, Long hospedajeId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un hospedaje con id = {0}", hospedajeId);
        List<HospedajeEntity> listaHospedajes = getArrendador(arrendadorId).getHospedajes();
        HospedajeEntity hospedajeEntity = new HospedajeEntity();
        hospedajeEntity.setId(hospedajeId);
        int i = listaHospedajes.indexOf(hospedajeEntity);
        if (i >= 0) {
            return listaHospedajes.get(i);
        }
        return null;
    }   
    
    public HospedajeEntity addHospedaje(Long idArrendador, Long idHospedaje) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia el proceso para agregar un hospedaje", idArrendador);
        ArrendadorEntity arrendador = getArrendador(idArrendador);
        hospedajeLogic.find(idHospedaje).setArrendador(arrendador);
        return hospedajeLogic.find(idHospedaje);
    }
    
    
    public void removerHospedajes(Long arrendadorId, Long hospedajesId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un hospedaje del arrendador con id = {0}", arrendadorId);
                
        ArrendadorEntity arrendadorEntity = getArrendador(arrendadorId);
        HospedajeEntity hospedaje = hospedajeLogic.find(hospedajesId);
        hospedaje.setArrendador(null);
        arrendadorEntity.getHospedajes().remove(hospedaje);
    }
   
}
