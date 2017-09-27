/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;


import java.util.logging.Logger;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.*;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ReservaPersistence;
        
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author je.bejarano10
 */
@Stateless
public class ReservaLogic {
       private static final Logger LOGGER = Logger.getLogger(ReservaLogic.class.getName());
       @Inject
       private ReservaPersistence persistence;
       public ReservaEntity createReserva( ReservaEntity entity) throws BusinessLogicException{
           LOGGER.info("Se inició el proceso para crear la Reserva");
           if(persistence.find(entity.getId())!=null || entity.getCedulaHuesped()<0 || (entity.getFechaInicio().compareTo(entity.getFechaFin())>0) ){
               throw new BusinessLogicException("Ya existe una Reserva con ese id");
           }
           else{
               persistence.create(entity);
               LOGGER.info("Se creó la Reserva");
           }
           return entity;
       }
       /**
     *
     * Obtener todas las Reservaes existentes en la base de datos.
     *
     * @return una lista de Reservaes.
     */
    public List<ReservaEntity> getReservas() {
        LOGGER.info("Inicia proceso de consultar todas las Reservaes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ReservaEntity> Reservas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Reservaes");
        return Reservas;
    }

    /**
     *
     * Obtener una Reserva por medio de su id.
     *
     * @param id: id de la Reserva para ser buscada.
     * @return la Reserva solicitada por medio de su id.
     */
    public ReservaEntity getReserva(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Reserva con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        ReservaEntity Reserva = persistence.find(id);
        if (Reserva == null) {
            LOGGER.log(Level.SEVERE, "La Reserva con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Reserva con id={0}", id);
        return Reserva;
    }

    /**
     *
     * Actualizar una Reserva.
     *
     * @param id: id de la Reserva para buscarla en la base de datos.
     * @param entity: Reserva con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la Reserva con los cambios actualizados en la base de datos.
     */
    public ReservaEntity updateReserva(Long id, ReservaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Reserva con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        ReservaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Reserva con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un Reserva
     *
     * @param id: id de la Reserva a borrar
     */
    public void deleteReserva(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Reserva con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
            persistence.delete(id);

            LOGGER.log(Level.INFO, "Termina proceso de borrar Reserva con id={0}", id);
        }
    }

        /**
         * Agregar un book a la Reserva
         *
         * @param estudianteId del book a asociar
         * @param ReservaId
         * @return
         
    public EstudianteEntity setEstudiante(Long estudianteId Long ReservaId) {
        ReservaEntity ReservaEntity = getReserva(ReservaId);
        EstudianteEntity estudianteEntity = EstudianteLogic.getEstudiante(estudianteId);
        EstudianteEntity.setReserva(EstudianteEntity);
        return estudianteEntity;
    }

    /**
     * Borrar un book de una Reserva
     *
     * @param bookId
     * @param ReservaId
     
    public void removeBook(Long bookId, Long ReservaId) {
        ReservaEntity ReservaEntity = getReserva(ReservaId);
        BookEntity book = bookLogic.getBook(bookId);
        book.setReserva(null);
        ReservaEntity.getBooks().remove(book);
    }

    /**
     * Remplazar el estudiante de una Reserva
     *
     * @param 
     * @param ReservaId
     * @return
     
    public EstudianteEntity replaceEstudiante(Long ReservaId, EstudianteEntity estudiante) {
        ReservaEntity reserva = getReserva(ReservaId);
        reserva.setEstudiante(estudiante);
        
        return estudiante;
    }

    /**
     * Retorna todos los books asociados a una Reserva
     *
     * @param ReservaId
     * @return
     
    public EstudianteEntity getEstudiante(Long ReservaId) {
        return getReserva(ReservaId).getEstudiante();
    }

    */

   
    

