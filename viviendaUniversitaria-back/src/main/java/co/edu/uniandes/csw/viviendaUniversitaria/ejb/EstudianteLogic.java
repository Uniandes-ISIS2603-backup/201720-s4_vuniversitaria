package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReservaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.EstudiantePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ISIS2603
 */
@Stateless
public class EstudianteLogic extends GenericLogic<EstudianteEntity>{
    private CalificacionLogic calificacionLogic;
    
    public EstudianteLogic() {
        super();
    }
    
    @Inject
    public EstudianteLogic(EstudiantePersistence persistence, CalificacionLogic calificacionLogic) {
        super(persistence, EstudianteEntity.class);
        this.persistence = persistence;
        this.calificacionLogic = calificacionLogic;
    }
    
    public OrigenEntity getOrigen(Long cedula) throws BusinessLogicException {
        return find(cedula).getOrigen();
    }
    
    @Override
    public EstudianteEntity update(EstudianteEntity entity, Long id) throws WebApplicationException {
        try {
            EstudianteEntity oldEntity = super.find(id);
            if(oldEntity != null) {
                entity.setCedula(oldEntity.getCedula());
            }
        } catch (BusinessLogicException ex) {
            Logger.getLogger(EstudianteLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return super.update(entity, id);
    }

    public CalificacionEntity addCalificacion(Long idCalificacion, Long idEstudiante) throws BusinessLogicException {
        EstudianteEntity estudianteEntity = find(idEstudiante);
        CalificacionEntity calificacionEntity = calificacionLogic.getCalificacion(idCalificacion);
        if (calificacionEntity == null) {
            throw new BusinessLogicException("no existe la calificacion");
        }
        calificacionEntity.setEstudiante(estudianteEntity);
        return calificacionEntity;
    }
/**
 * 
 * @param estudianteId
 * @param idCalificacion
 * @return
 * @throws BusinessLogicException 
 */
    public CalificacionEntity getCalificacion(Long estudianteId, Long idCalificacion) throws BusinessLogicException {
        List<CalificacionEntity> calificaciones = find(estudianteId).getCalificaciones();
        CalificacionEntity calificacion = calificacionLogic.getCalificacion(idCalificacion);
        int index = calificaciones.indexOf(calificacion);
        if (index >= 0) {
            return calificaciones.get(index);
        }
        throw new BusinessLogicException("la calificacion no está asociada al estudiante");

    }
    
    
/**
 * 
 * @param idCalificacion
 * @return
 * @throws BusinessLogicException 
 */
    public List<CalificacionEntity> getCalificaciones(Long idCalificacion) throws BusinessLogicException {
        return find(idCalificacion).getCalificaciones();
    }
    /**
     * 
     * @param idReserva
     * @return
     * @throws BusinessLogicException 
     */
    public ReservaEntity getReserva(Long idReserva) throws BusinessLogicException {
        return find(idReserva).getReserva();
    }
/**
 * 
 * @param cedula
 * @return
 * @throws BusinessLogicException 
 */
    public List<CalificacionEntity> listCalificaciones(Long cedula) throws BusinessLogicException {
        return find(cedula).getCalificaciones();
    }
/**
 * 
 * @param idCalificacion
 * @param id
 * @throws BusinessLogicException 
 */
    public void removeCalificaciones(Long idCalificacion, Long id) throws BusinessLogicException {
        CalificacionEntity calificacionEntity = new CalificacionEntity();
        calificacionEntity.setId(idCalificacion);
        List<CalificacionEntity> list = find(id).getCalificaciones();
        int i = list.indexOf(calificacionEntity);
        if (i < 0) {
            throw new BusinessLogicException("El recurso /origen/" + idCalificacion + "/Estudiante no existe.");
        }
        list.remove(calificacionEntity);
    }
/**
 * 
 * @param idOrigen
 * @param entity
 * @param id
 * @return
 * @throws BusinessLogicException 
 */
    public EstudianteEntity update(Long idOrigen, EstudianteEntity entity,long id) throws BusinessLogicException {
        EstudianteEntity old = find(entity.getId());
        if (!old.getOrigen().getId().equals(idOrigen)) {
            throw new BusinessLogicException("no existe el origen con ese id");
        }
        entity.setOrigen(old.getOrigen());
        entity.setFacturas(old.getFacturas());
        entity.setCalificaciones(old.getCalificaciones());
        return update(entity, id);
    }

    /**
     * Agrega una reserva a un hospedaje.
     * @param idEstudiante id del hospedaje
     * @param reservaEntity la reserva
     * @return Hospedaje modificado
     * @throws BusinessLogicException Se agrega una calificacion ya existente.
     */
    public EstudianteEntity agregarReserva(Long idEstudiante, ReservaEntity reservaEntity) throws BusinessLogicException {
        EstudianteEntity estudiante = find(idEstudiante);
        if (reservaEntity.getEstudiante() != null) {
            throw new WebApplicationException("Esta reserva ya se encuentra sociada a un estudiante.\nPor favor verifique la ubicacion he intente de nuevo.", 412);
        }
        estudiante.setReserva(reservaEntity);
        reservaEntity.setEstudiante(estudiante);
        return find(idEstudiante);
    }
    
    public void removeReserva(Long idEstudiante, Long idReserva) throws BusinessLogicException {
        EstudianteEntity estudianteEntity = find(idEstudiante);
        ReservaEntity reservaEntity = estudianteEntity.getReserva();
        if (reservaEntity == null) {
            throw new BusinessLogicException("El recurso /estudiante/" + idEstudiante + "/Estudiante no existe.");
        }
        estudianteEntity.setReserva(null);
    }
    
     public EstudianteEntity buscarUsusario(String usuario) {         
        return ((EstudiantePersistence)persistence).buscarUsiario(usuario);
    }
}
