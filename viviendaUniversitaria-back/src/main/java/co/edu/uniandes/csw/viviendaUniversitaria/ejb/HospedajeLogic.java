/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajePersistence;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author ws.duarte
 */
@Stateless
public class HospedajeLogic extends GenericLogic<HospedajeEntity>
{

    private static final Logger LOGGER = Logger.getLogger(HospedajeLogic.class.getName());

//    @Inject
//    private HospedajePersistence persistence;
//    
    
    private UbicacionLogic ubicacionLogic;
    
    private CalificacionLogic calificacionLogic;

    public HospedajeLogic() {
        super();
    }
    
    @Inject public HospedajeLogic(HospedajePersistence persistenceHospedaje,UbicacionLogic ubicacionLogic,CalificacionLogic calificacionLogic,HospedajePersistence persistence) throws IllegalAccessException, InstantiationException {
        super(persistenceHospedaje,HospedajeEntity.class);
        System.out.println("=============================================================");
        System.out.println("co.edu.uniandes.csw.viviendaUniversitaria.ejb.HospedajeLogic.<init>()");
        System.out.println(persistenceHospedaje);
        System.out.println(persistenceHospedaje.getClase());
        System.out.println("=============================================================");
        this.calificacionLogic = calificacionLogic;
        this.ubicacionLogic = ubicacionLogic;
    }

    
    
//    @Inject
//    public HospedajeLogic() throws IllegalAccessException, InstantiationException { //UbicacionLogic ubicacionLogic,CalificacionLogic calificacionLogic,HospedajePersistence persistence
//      super(HospedajePersistence.class);
////      this.calificacionLogic = calificacionLogic;
////      this.ubicacionLogic = ubicacionLogic;
//    }
    
    

//    public HospedajeEntity create(HospedajeEntity entidad) throws WebApplicationException {
//        LOGGER.info("Creación de un hospedaje");
//        if (entidad.getId() != null && persistence.find(entidad.getId()) != null) {
//            LOGGER.log(Level.WARNING, "Intento de creacion fallido.\nLa entidad ya existe\nId:{1}", entidad.getId());
//            throw new WebApplicationException("Creacion: La entidad ya existe", 405);
//        }
//        if(entidad.getId() == null) entidad.setId(new Long(0));
//        return persistence.create((entidad));
//    }
//
//    public HospedajeEntity update(HospedajeEntity entidad, Long id) throws WebApplicationException {
//        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", entidad.getId());
//        validar(entidad, "Actualización");
//        return persistence.update((entidad));
//    }
//
//    public void delete(Long id) throws WebApplicationException {
//        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", id);
//        if (persistence.find(id) == null) {
//            LOGGER.log(Level.WARNING, "Intento de Eliminacion fallido.\nLa entidad no existe\nId:{0}", id);
//            throw new WebApplicationException("Eliminacion: La entidad no existe", 405);
//        }
//        persistence.delete(id);
//    }
//
//    public HospedajeEntity find(Long id) throws WebApplicationException {
//        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", id);
//        HospedajeEntity ret = persistence.find(id);
//        if (ret == null) {
//            throw new WebApplicationException("Consulta id: La entidad no existe", 405);
//        }
//        return ret;
//    }
//
//    public List<HospedajeEntity> findAll() throws WebApplicationException {
//        LOGGER.info("Consultando todos los hospedajes");
//        List<HospedajeEntity> ret = persistence.findAll();
//        if (ret.isEmpty()) {
//            throw new WebApplicationException("Actualmente no existen hospedajes registrados.", 405);
//        }
//        return ret;
//    }

    public HospedajeEntity agregarUbicacacion(Long idHospedaje, Long idUbicacion) throws WebApplicationException{
        try {
            HospedajeEntity hospedaje = find(idHospedaje);
            UbicacionEntity ubicacion = ubicacionLogic.getUbicacion(idUbicacion);
            if(ubicacion.getHospedaje() != null) throw new WebApplicationException("Esta ubicacion ya se encuentra sociada a un hospedaje.\nPor favor verifique la ubicacion he intente de nuevo.", 412);
            ubicacion.setHospedaje(hospedaje);
            return find(idHospedaje);
        } catch (BusinessLogicException ble) {
            throw new WebApplicationException(ble.getMessage(), 412);
        }
    }
    
    public HospedajeEntity agregarCalificacion(Long idHospedaje, Long idCalificacion)
    {
        HospedajeEntity hospedaje = find(idHospedaje);
        CalificacionEntity calificaicon = calificacionLogic.getCalificacion(idHospedaje);
        if(calificaicon.getHospedaje() != null) throw new WebApplicationException("Esta calificacion ya se encuentra sociada a un hospedaje.\nPor favor verifique la ubicacion he intente de nuevo.", 412);
        calificaicon.setHospedaje(actualizarVotacion(hospedaje, calificaicon));
        return find(idHospedaje);
    }
    
    private HospedajeEntity actualizarVotacion(HospedajeEntity hospedaje, CalificacionEntity calificacion)
    {
        hospedaje.setValoracion(((hospedaje.getValoracion()*hospedaje.getCantidadVotaciones())+calificacion.getValoracion())/(hospedaje.getCantidadVotaciones()+1));
        hospedaje.setCantidadVotaciones(hospedaje.getCantidadVotaciones()+1);
        return update(hospedaje,hospedaje.getId());
    }
    
    
    private void validar(HospedajeEntity entidad, String proceso) throws WebApplicationException {
        if (persistence.find(entidad.getId()) == null) {
            //LOGGER.log(Level.WARNING, "Intento de {0} fallido.\nLa entidad no existe\nId:{1}", new Object[]{proceso, entidad.getId()});
            throw new WebApplicationException(proceso + ": La entidad no existe", 405);
        }
    }

//    private HospedajeEntity validarEntidad(HospedajeEntity entidad) throws WebApplicationException
//    {
//        if(entidad == null || entidad.getArrendador() != null || entidad.getDescripcion() != null || entidad.getTipoArrendamiento()!= null )
//            throw new WebApplicationException("El parametro enviado no cumple con las caracteristicas especificadas",407);
//        return entidad;
//    }
}
