/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.UbicacionPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author c.santacruza
 */
@Stateless
public class UbicacionLogic {

    private static final Logger LOGGER = Logger.getLogger(UbicacionLogic.class.getName());

    @Inject
    private UbicacionPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public UbicacionEntity createUbicacion(UbicacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Ubicacion");
        // Invoca la persistencia para crear la Ubicacion
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Ubicacion");
        return entity;
    }
    /**
     * Retorna una ubicacion
     * @param id de la ubicacion
     * @return la ubicacion con el id correspondiente
     * @throws BusinessLogicException Si no existe una ubicacion con ese id
     */
    public UbicacionEntity getUbicacion(Long id) throws BusinessLogicException{
        LOGGER.info("Inicia proceso de consulta de una ubicacion");
        UbicacionEntity ubi = persistence.find(id);
        LOGGER.info("Termima proceso de consulta");
        return ubi;
    }
    /**
     * 
     * Obtener todas las Ubicaciones existentes en la base de datos.
     *
     * @return una lista de Ubicaciones.
     */
    public List<UbicacionEntity> getUbicaciones() {
        LOGGER.info("Inicia proceso de consultar todas las Ubicaciones");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<UbicacionEntity> Ubicacion = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Ubicaciones");
        return Ubicacion;
    }
    
    /**
     * Modificar una ubicacion dado un id.
     * @param id
     * @param entity, contiene la nueva información de la ubicacion
     * @return 
     * @throws co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException
     * @Return UbicacionEntity
     */
    public UbicacionEntity updateUbicacion(Long id,UbicacionEntity entity) throws BusinessLogicException{
        UbicacionEntity aModificar = getUbicacion(id);
                aModificar.setDireccion(entity.getDireccion());
                aModificar.setAltitud(entity.getAltitud());
                aModificar.setLatitud(entity.getLatitud());
       
        UbicacionEntity modificado =  persistence.update(entity);
        return modificado;
    }
    /**
     * Elimina una ubicacion dado un id
     * @param id, el id de la ubicacion a eliminar
     */
    public void deleteUbicacion(Long id){
        persistence.delete(id);
    }

}