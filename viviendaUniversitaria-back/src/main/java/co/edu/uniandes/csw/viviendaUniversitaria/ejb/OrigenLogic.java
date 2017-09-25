/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.OrigenPersistence;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.OrigenPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.eslava
 */
@Stateless
public class OrigenLogic {
    
         private static final Logger LOGGER = Logger.getLogger(OrigenLogic.class.getName());

        @Inject
        private OrigenPersistence persistence;
        @Inject
        private EstudianteLogic estudianteLogic;

    public OrigenEntity createOrigen(Long estuCed, OrigenEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de crear review");
        if (validate(entity.getId())!=false) {
            throw new BusinessLogicException("error, ya existe");
        }
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(estuCed);
        entity.setEstudiante(estudiante);
        return persistence.create(entity);
    }

 /**
     * Obtiene los datos de una instancia de Origen a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de OrigenEntity con los datos del Origen consultado.
     * @generated
     */
    public OrigenEntity getOrigen(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un Origen con id = {0}", id);
        if(validate(id)== false){
            throw new BusinessLogicException("no se puede buscar ");
        }
        return persistence.find(id);
    }
    
    public OrigenEntity getOrigenEstudiante(Long cedula) throws BusinessLogicException
    {
        return estudianteLogic.getEstudiante(cedula).getOrigen();
    }
 /**
     * Actualiza la información de una instancia de Origen.
     *
     * @param entity Instancia de OrigenEntity con los nuevos datos.
     * @return Instancia de OrigenEntity con los datos actualizados.
     * @generated
     */
    public OrigenEntity updateOrigen(Long cedula,OrigenEntity entity) throws BusinessLogicException {
        EstudianteEntity add = estudianteLogic.getEstudiante(cedula);
        add.setOrigen(entity);
        estudianteLogic.updateEstudiante(add);
        //EstudianteEntity entity = estudianteLogic.getEstudiante(cedula);
        return entity;// persistence.update(entity);
    }

    /**
     * Elimina una instancia de Origen de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteOrigen(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un Origen ");
        if(validate(id)!=false){
            throw new BusinessLogicException("no se puede borrar ");
        }
        persistence.delete(id);
    }

    private boolean validate(Long id) {
        if (id == null) {
            return false;
        }
        return true;
    }
}
