/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReglaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajePersistence;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ReglaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ws.duarte
 */
@Stateless
public class ReglaLogic 
{
    private static final Logger LOGGER = Logger.getLogger(ReglaLogic.class.getName());
    
    @Inject
    private ReglaPersistence reglaPersistence;
    @Inject
    private HospedajeLogic hospedajeLogic;
    
    public List<ReglaEntity> findAll(Long idHospedaje)throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Consultando todas las reglas de un hospedaje. \nid:{0}", idHospedaje);
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        if(hospedaje.getReglas() == null || hospedaje.getReglas().isEmpty())
            throw new WebApplicationException("Actualmente no existen reglas registradas.",405);
        return hospedaje.getReglas();
    }
    
    public ReglaEntity find(Long idHospedaje, Long idRegla)throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", idRegla);
//        ReglaEntity ret = reglaPersistence.find(idRegla);
//        //hospedajePersistence.find(idHospedaje).getReglas().get(hospedajePersistence.find(idHospedaje).getReglas().indexOf(ret));
//        if(ret == null) throw new WebApplicationException("Consulta id: La entidad no existe", 405);
//        return ret;
        return reglaPersistence.find(idHospedaje, idRegla);
    }
    
    public ReglaEntity create(Long idhospedaje, ReglaEntity entidad) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Creacion de una nueva entidad regla l hospedaje id: {0}", idhospedaje);
//        if(reglaPersistence.find(entidad.getId()) != null)
//        {
//            LOGGER.log(Level.WARNING, "Intento de creacion fallido.\nLa entidad ya existe\nId:{1}", entidad.getId());
//            throw new WebApplicationException("Ya existe una entidad con el id:"+entidad.getId(), 405);
//        }
//        hospedajeLogic.find(idhospedaje).getReglas().add(entidad);
        //return reglaPersistence.create((entidad));
        HospedajeEntity hospedaje = hospedajeLogic.find(idhospedaje);
        entidad.setHospedaje(hospedaje);
        return reglaPersistence.create(entidad);
    }
    
    public ReglaEntity update(Long idhospedaje, ReglaEntity entidad) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", entidad.getId());
//        List<ReglaEntity> lista = hospedajeLogic.find(idhospedaje).getReglas();
//        int i = lista.indexOf(entidad);
//        if(i >= 0) lista.set(i, entidad);
//        validar((entidad), "Actualización");
//        //return reglaPersistence.update((entidad));
//        hospedajeLogic.find(idhospedaje).setReglas(lista);
        
        HospedajeEntity hospedaje = hospedajeLogic.find(idhospedaje);
        entidad.setHospedaje(hospedaje);
        return reglaPersistence.update(entidad);
    }
    
    public void delete(Long idhospedaje,Long idRegla) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "Actualizar la entidad con id: {0}", idRegla);
//        if(reglaPersistence.find(idRegla) == null) 
//            {
//            LOGGER.log(Level.WARNING, "Intento de Eliminación fallido.\nLa entidad no existe\nId:{0}",  idRegla);
//            throw new WebApplicationException("Eliminación: La entidad no existe", 405);
//        }
//        hospedajeLogic.find(idhospedaje).getReglas().remove(reglaPersistence.find(idRegla));
        //reglaPersistence.delete(idRegla);
        reglaPersistence.delete(find(idhospedaje, idRegla).getId());
    }
    
//    private void validar(ReglaEntity entidad, String proceso) throws WebApplicationException
//    {
//        if(reglaPersistence.find(entidad.getId()) == null)
//        {
//            LOGGER.log(Level.WARNING, "Intento de {0} fallido.\nLa entidad no existe\nId:{1}", new Object[]{proceso, entidad.getId()});
//            throw new WebApplicationException(proceso+": La entidad no existe",405);
//        }
//    }
    
//    private ReglaEntity validarEntidad(ReglaEntity regla) throws WebApplicationException {
//        if(regla ==  null || regla.getHospedaje() != null || regla.getRegla() != null) 
//            throw new WebApplicationException("El parametro enviado no cumple con las caracteristicas especificadas",407);
//        return regla;
//    }
}
