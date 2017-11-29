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
 * @author a.eslava
 */
/**
 * Clase que permite gestionar y validar las reglas de negocio relacionadas con
 * la reserva
 *
 */
@Stateless
public class ReservaLogic {

    private static final Logger LOGGER = Logger.getLogger(ReservaLogic.class.getName());

    @Inject
    private ReservaPersistence persistence;
    @Inject
    private EstudianteLogic estudianteLogic;
    @Inject
    private HospedajeLogic hospedajeLogic;

    
    
    public ReservaEntity createReserva(ReservaEntity entity) throws BusinessLogicException {
        if (entity.getIdHospedaje() == null || entity.getCedulaHuesped() == null || entity.getId() == null) {
            throw new BusinessLogicException("No introdujo todos los valores");
        }
        else{
            if (hospedajeLogic.find(entity.getIdHospedaje()) == null) {
                throw new BusinessLogicException("No existe ese HOSPEDAJE");
            }
            if (estudianteLogic.find(entity.getCedulaHuesped()) == null) {
                throw new BusinessLogicException("No existe ese ESTUDIANTE");
            }
            if (persistence.find(entity.getId()) != null) {
                throw new BusinessLogicException("Ya existe una Reserva con ese id");
            }
        }
        EstudianteEntity estudianteEntity = estudianteLogic.find(entity.getCedulaHuesped());
        HospedajeEntity hospedajeEntity = hospedajeLogic.find(entity.getIdHospedaje());
        hospedajeLogic.agregarReserva(hospedajeEntity.getId(),entity);
        estudianteLogic.agregarReserva(estudianteEntity.getId(),entity);
        ReservaEntity rta = persistence.create(entity);
        return rta;
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
        ReservaEntity Reserva = persistence.find(id);
        if (Reserva == null) {
            LOGGER.log(Level.SEVERE, "La Reserva con el id {0} no existe", id);
        }
        return Reserva;
    }

    /**
     *
     * Actualizar una Reserva.
     *
     * @param id: id de la Reserva para buscarla en la base de datos.
     * @param entity: Reserva con los cambios para ser actualizada, por ejemplo
     * el nombre.
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
     * @throws co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException
     */
    public void deleteReserva(Long id) throws BusinessLogicException {
        if (getReserva(id) == null) {
            throw new BusinessLogicException("No se pudo encontrar una reserva con ese id");

        }       
        estudianteLogic.removeReserva(getEstudiante(id).getId(), id);
        hospedajeLogic.removeReserva(getHospedaje(id).getId(),id);
        persistence.delete(id);
    }

    public HospedajeEntity getHospedaje(Long idReserva) throws BusinessLogicException {
        ReservaEntity reserva = persistence.find(idReserva);
        if (reserva == null) {
            throw new BusinessLogicException("No se pudo encontrar una reserva con ese id");
        }
        return reserva.getHospedaje();
    }

    public HospedajeEntity setHospedaje(Long idReserva, HospedajeEntity hospedaje) throws BusinessLogicException {
        ReservaEntity reserva = persistence.find(idReserva);
        if (reserva == null) {
            throw new BusinessLogicException("No se pudo encontrar una reserva con ese id");
        }
        reserva.setHospedaje(hospedaje);
        persistence.update(reserva);
        return hospedaje;
    }

    public EstudianteEntity getEstudiante(Long idReserva) throws BusinessLogicException {
        ReservaEntity reserva = persistence.find(idReserva);
        if (reserva == null) {
            throw new BusinessLogicException("No se pudo encontrar una reserva con ese id");
        }
        return reserva.getEstudiante();
    }

    public EstudianteEntity setEstudiante(Long idReserva, EstudianteEntity estudiante) throws BusinessLogicException {
        ReservaEntity reserva = persistence.find(idReserva);
        if (reserva == null) {
            throw new BusinessLogicException("No se pudo encontrar una reserva con ese id");
        }
        reserva.setEstudiante(estudiante);
        persistence.update(reserva);
        return estudiante;
    }

    public void asociateReservaConHospedajeYEstudiante(Long idHospedaje, Long idEstudiante, ReservaEntity reserva) throws BusinessLogicException {
        EstudianteEntity estudiante = estudianteLogic.find(idEstudiante);
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if (hospedaje == null || estudiante == null) {
            throw new BusinessLogicException("Usuario u hospedaje inválido");
        }
        reserva.setEstudiante(estudiante);
        reserva.setHospedaje(hospedaje);
        persistence.update(reserva);

    }
}

/**
 * Agregar un book a la Reserva
 *
 * @param estudianteId del book a asociar
 * @param ReservaId
 * @return
 *
 * public EstudianteEntity setEstudiante(Long estudianteId Long ReservaId) {
 * ReservaEntity ReservaEntity = getReserva(ReservaId); EstudianteEntity
 * estudianteEntity = EstudianteLogic.getEstudiante(estudianteId);
 * EstudianteEntity.setReserva(EstudianteEntity); return estudianteEntity; }
 *
 * /**
 * Borrar un book de una Reserva
 *
 * @param bookId
 * @param ReservaId
 *
 * public void removeBook(Long bookId, Long ReservaId) { ReservaEntity
 * ReservaEntity = getReserva(ReservaId); BookEntity book =
 * bookLogic.getBook(bookId); book.setReserva(null);
 * ReservaEntity.getBooks().remove(book); }
 *
 * /**
 * Remplazar el estudiante de una Reserva
 *
 * @param
 * @param ReservaId
 * @return
 *
 * public EstudianteEntity replaceEstudiante(Long ReservaId, EstudianteEntity
 * estudiante) { ReservaEntity reserva = getReserva(ReservaId);
 * reserva.setEstudiante(estudiante);
 *
 * return estudiante; }
 *
 * /**
 * Retorna todos los books asociados a una Reserva
 *
 * @param ReservaId
 * @return
 *
 * public EstudianteEntity getEstudiante(Long ReservaId) { return
 * getReserva(ReservaId).getEstudiante(); }
 *
 */
