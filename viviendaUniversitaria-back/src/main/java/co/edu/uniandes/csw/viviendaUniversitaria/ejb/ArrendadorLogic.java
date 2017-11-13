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
 * Clase de la logica de la aplicacion
 * @author kk.penaranda
 */
@Stateless
public class ArrendadorLogic {
    
    /**
     * Logger para mostrar mensajes especificos
     */
    private static final Logger LOGGER = Logger.getLogger(ArrendadorLogic.class.getName());

    /**
     * Persistencia del arrendador
     */
    private ArrendadorPersistence persistence;  
    
    /**
     * Logica del hospedaje
     */
    private HospedajeLogic hospedajeLogic;
    
    /**
     * Constructor de la logica del arrendador
     */
    public ArrendadorLogic(){
        //Constructor por defecto
    }
    
    /**
     * Constructor de la logica
     * @param persistence
     * @param hospedajeLogic 
     */
    @Inject
    public ArrendadorLogic(ArrendadorPersistence persistence, HospedajeLogic hospedajeLogic){
        this.persistence= persistence;
        this.hospedajeLogic= hospedajeLogic;
    }
        
    /**
     * Crea el arrendador y lo registra en la base de datos
     * @param entity Objeto arrendador
     * @return El objeto del arrendador creado
     * @throws BusinessLogicException 
     */
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
    
    /**
     * Retorna la lista de arrendadores
     * @return Lista de entidades de tipo arrendador
     */
    public List<ArrendadorEntity> getArrendadores() {
        LOGGER.info("Inicia proceso de consultar todos los arrendadores");
        List<ArrendadorEntity> arrendadores = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los arrendadores");
        return arrendadores;
    }
        
    /**
     * Retorna el arrendador solicitado por parametro
     * @param id del arrendador a buscar
     * @return entidad de tipo de arrendador
     */
    public ArrendadorEntity getArrendador(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar arrendador con id={0}", id);
        ArrendadorEntity arrendador = persistence.find(id);
        if (arrendador == null) {
            LOGGER.log(Level.SEVERE, "El arrendador con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar arrendador con id={0}", id);
        return arrendador;
    }

    /**
     * Actualiza la informacion de un arrendador
     * @param id del arrendador
     * @param entity del arrendador
     * @return Entidad del arrendador actualizado
     * @throws BusinessLogicException 
     */
    public ArrendadorEntity updateArrendador(Long id, ArrendadorEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar arrendador con id={0}", id);
        if(persistence.find(id)== null)
            throw new BusinessLogicException("No existe el arrendador con el id dado");
        entity.setId(id);
        ArrendadorEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar arrendador con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Elimina el arrendador dado por parametro
     * @param id del arrendador a eliminar
     */
    public void deleteArrendador(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar arrendador con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar arrendador con id={0}", id);
    }  
    
    /**
     * Retorna la lista de hospedajes asociados a un arrendador
     * @param arrendadorId
     * @return lista de entidades de tipo arrendador
     */
    public List<HospedajeEntity> getHospedajesArrendador(Long arrendadorId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los hospedajes del arrendador con id = {0}", arrendadorId);
        return getArrendador(arrendadorId).getHospedajes();
    }
    
    /**
     * Obtiene el hospedaje pedido que le pertenece a un arrendador
     * @param arrendadorId Id del arrendador a buscar
     * @param hospedajeId Id del hospedaje del que se requiere la información
     * @return Hospedaje buscado
     * @throws BusinessLogicException 
     */
    public HospedajeEntity getHospedajeIdArrendador(Long arrendadorId, Long hospedajeId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un hospedaje con id = {0}", hospedajeId);
        List<HospedajeEntity> listaHospedajes = getArrendador(arrendadorId).getHospedajes();
        HospedajeEntity hospedajeEntity = new HospedajeEntity();
        hospedajeEntity.setId(hospedajeId);
        int i = listaHospedajes.indexOf(hospedajeEntity);
        if (i >= 0) {
            return listaHospedajes.get(i);
        }
       else
            throw new BusinessLogicException("El hospedaje no le pertenece al arrendador solicitado");
    }   
    
    /**
     * Agrega un nuevo hospedaje al arrendador dado
     * @param idArrendador Arrendador al que se le agregara el hospedaje
     * @param idHospedaje Id del hospedaje a asociar
     * @return la entidad del hospedaje
     * @throws BusinessLogicException 
     */
    public HospedajeEntity addHospedaje(Long idArrendador, Long idHospedaje) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia el proceso para agregar un hospedaje", idArrendador);
        ArrendadorEntity arrendador = getArrendador(idArrendador);
        hospedajeLogic.find(idHospedaje).setArrendador(arrendador);
        return hospedajeLogic.find(idHospedaje);
    }
    
    /**
     * Elimina determinado hospedaje del arrendador dado
     * @param arrendadorId Arrendador que se desea buscar
     * @param hospedajesId Hospedaje a encontrar para eliminar
     * @throws BusinessLogicException 
     */
    public void removerHospedajes(Long arrendadorId, Long hospedajesId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un hospedaje del arrendador con id = {0}", arrendadorId);
                
        ArrendadorEntity arrendadorEntity = getArrendador(arrendadorId);
        HospedajeEntity hospedaje = hospedajeLogic.find(hospedajesId);
        hospedaje.setArrendador(null);
        arrendadorEntity.getHospedajes().remove(hospedaje);
    }
   
}
