/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.interfase.ILogic;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.GenericPresistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;

/**
 * Logica generica
 * @author ws.duarte
 * @param <T>
 */
public abstract class GenericLogic<T extends BaseEntity> implements ILogic<T> {

    /**
     * Clase de la entidad que se maneja.
     */
    private Class<T> clase;
    
    /**
     * Logger para registra los mensajes
     */
    protected Logger log;

    /**
     * Perisistencia a utilizar.
     */
    protected GenericPresistence<T> persistence;

    /**
     * Costructor por defecto
     */
    public GenericLogic() {
        //Toca dejarlo así
    }

    /**
     * Costrulle la logica
     * @param persis Persistenca a manejar
     * @param clase Entidad a manejar.
     */
    public GenericLogic(GenericPresistence<T> persis, Class<T> clase) {
        this.persistence = persis;
        this.clase = clase;
        log = Logger.getLogger(clase.getName());
    }

    /**
     * Crea una entidad 
     * @param entity entidad a crear 
     * @return Entidad creada
     * @throws BusinessLogicException 
     */
    @Override
    public T create(T entity) throws BusinessLogicException {
        log.log(Level.INFO, "Creación de un nuevo {0}", clase.getSimpleName());
        T ret = persistence.create(entity);
        log.log(Level.FINE, "La entidad fue creada exitosamente.");
        return ret;
    }

    /**
     * Busca una entidad especifica.
     * @param id id por el que se busca
     * @return Entidad buscada
     * @throws BusinessLogicException 
     */
    @Override
    public T find(Long id) throws BusinessLogicException {
        log.log(Level.INFO, "Consultando un {0} con la llave {1}", new String[]{clase.getSimpleName(), id.toString()});
        T ret = persistence.find(id);
        if (ret==null) {
            log.log(Level.SEVERE, "La entidad con la llave primaria {0} no existe", id);
            throw new BusinessLogicException("No existe una entidad con esta llave primaria especificada");
        }
        log.log(Level.FINE, "La consulta fue exitosa");
        return ret;
    }

    /**
     * Consulta toda las entidades
     * @return Lista con las entidades buscadas.
     */
    @Override
    public List<T> findAll() {
        log.log(Level.INFO, "Consultando todos los registros de {0}", clase.getSimpleName());
        List<T> ret = persistence.findAll();
        log.log(Level.FINE, "La consulta fue exitosa");
        return ret;
    }

    /**
     * Modifica la entidad especificada.
     * @param entity entidad a actualizar
     * @param id id de la entidad
     * @return entidad modificada
     * @throws WebApplicationException  Si no existe la entidad especifica
     */
    @Override
    public T update(T entity, Long id) throws WebApplicationException {
        log.log(Level.INFO, "Actualizando la entidad con id {0}", id);
        if (!exist(id)) {
            log.log(Level.SEVERE, "La entidad con la llave primaria {0} no existe", id);
            throw new WebApplicationException("No existe una entidad con esta llave primaria especificada", 405);
        }
        entity.setId(id);
        T ret = persistence.update(entity);
        log.log(Level.FINE, "La entidad se a actualizado exitosamente");
        return ret;
    }

    /**
     * Elimina una entidad
     * @param id id de la entidad a eliminar.
     * @throws BusinessLogicException si la entidad no existe.
     */
    @Override
    public void delete(Long id) throws BusinessLogicException {
        log.log(Level.INFO, "Eliminando la entidad con el id {0}", id);
        persistence.delete(id);
        log.log(Level.FINE, "La entidad fue eliminada exitosamente");
    }

    /**
     * Metodo que valida si la entidad existe.
     * @param id id de la entidad buscada
     * @return retorna el entidad buscada.
     */
    protected boolean exist(Long id) {
        return persistence.find(id) != null;
    }
}
