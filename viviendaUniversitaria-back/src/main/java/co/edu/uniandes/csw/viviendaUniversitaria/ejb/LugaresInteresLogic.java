/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.HospedajeLugarPersistence;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.LugaresInteresPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author jc.sanguino10
 */
@Stateless
public class LugaresInteresLogic {

    private HospedajeLugarPersistence hospedajelugar;

    private LugaresInteresPersistence persistence;

    private HospedajeLogic hospedajeLogic;

    /**
     * Constructor vacio por defecto
     */
    public LugaresInteresLogic() {
        super();
    }

    @Inject
    public LugaresInteresLogic(HospedajeLugarPersistence hospedajelugar, LugaresInteresPersistence persistence, HospedajeLogic logicaHospedaje) {
        this.hospedajelugar = hospedajelugar;
        this.persistence = persistence;
        this.hospedajeLogic = logicaHospedaje;
    }

    /**
     * Update de un lugar de interes
     *
     * @param entity
     * @param id
     * @return
     * @throws WebApplicationException
     */
    public LugaresInteresEntity update(LugaresInteresEntity entity, Long id) {
        LugaresInteresEntity old = persistence.find(id);
        if (entity.getDescripcion() == null) {
            entity.setDescripcion(old.getDescripcion());
        }
        if (entity.getRutaImagen() == null) {
            entity.setRutaImagen(old.getRutaImagen());
        }
        if (entity.getUbicacion() == null) {
            entity.setUbicacion(old.getUbicacion());
        }
        if (entity.getName() == null) {
            entity.setName(old.getName());
        }
        return persistence.update(entity);
    }

    /**
     *
     * @param idHospedaje
     * @return
     */
    public List<LugaresInteresEntity> findAll(Long idHospedaje) {
        Logger log=Logger.getLogger(LugaresInteresLogic.class.getName());
        List<HospedajeLugarEntity> hospedajesLugar = hospedajelugar.findAll(idHospedaje);
        List<LugaresInteresEntity> lugaresInteres = new ArrayList<>();
        for (HospedajeLugarEntity hospedajeLugar : hospedajesLugar) {
            LugaresInteresEntity lugar = persistence.find(hospedajeLugar.getLugarInteres().getId());
            List<HospedajeLugarEntity> hospedajesLugares = new ArrayList<>();
            hospedajesLugares.add(hospedajeLugar);
            lugar.setHospedaLugar(hospedajesLugares);
            lugaresInteres.add(lugar);
            log.log(Level.INFO, "esta es la distancia: " + lugar.getHospedajeLugar().get(0).getDistancia());
        }
        return lugaresInteres;
    }

    /**
     *
     * @param idHospedaje
     * @param idLugarInteres
     * @return
     */
    public LugaresInteresEntity find(Long idHospedaje, Long idLugarInteres) {
        HospedajeLugarEntity hospedajesLugar = hospedajelugar.find(idHospedaje, idLugarInteres);
        List<HospedajeLugarEntity> listado = new ArrayList<>();
        listado.add(hospedajesLugar);
        LugaresInteresEntity lugar = persistence.find(idLugarInteres);
        lugar.setHospedaLugar(listado);
        return lugar;
    }
    /**
     *
     * @param idHospedaje
     * @param idLugarInteres
     */
    public void delete(Long idHospedaje, Long idLugarInteres) {
        hospedajelugar.delete(idHospedaje, idLugarInteres);
    }
    /**
     * 
     * @param idHospedaje
     * @param nuevo
     * @return
     * @throws BusinessLogicException 
     */    
    public LugaresInteresEntity create(Long idHospedaje, LugaresInteresEntity nuevo) throws BusinessLogicException {
        LugaresInteresEntity nuevoLugar = persistence.findForName(nuevo.getName());
        if (nuevoLugar == null) {
            nuevoLugar = persistence.create(nuevo);
        }
        HospedajeLugarEntity nuevaRelacion = new HospedajeLugarEntity();
        HospedajeEntity hospedajeDelLugar = hospedajeLogic.find(idHospedaje);
        nuevaRelacion.setHospedaje(hospedajeDelLugar);
        //nuevaRelacion.setDistancia(darDistancia(hospedajeDelLugar.getUbicacion(), nuevo.getUbicacion()));
        nuevaRelacion.setDistancia(2.5);
        nuevaRelacion.setLugarInteres(nuevoLugar);
        hospedajelugar.create(nuevaRelacion);
        return nuevoLugar;
    }
    public Double darDistancia(UbicacionEntity ubicacionHospedaje, UbicacionEntity ubicacionLugar)
    {
        double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(ubicacionHospedaje.getLatitud() - ubicacionLugar.getLatitud());  
        double dLng = Math.toRadians(ubicacionHospedaje.getLongitud() - ubicacionLugar.getLongitud());  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(ubicacionLugar.getLatitud())) * Math.cos(Math.toRadians(ubicacionHospedaje.getLatitud()));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia; 
    }
}
