/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.util.ArrayList;
import java.util.List;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jc.sanguino10
 */
@RunWith(Arquillian.class)
public class LugaresInteresEntityTest {
    
  
    private List<LugaresInteresEntity> data = new ArrayList<>();

    
    public LugaresInteresEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 2; i++) {
            LugaresInteresEntity entity = factory.manufacturePojo(LugaresInteresEntity.class);
            UbicacionEntity ubicacion = factory.manufacturePojo(UbicacionEntity.class);
            ArrayList<HospedajeLugarEntity> muestraHospedajes = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                HospedajeLugarEntity hospedaje = factory.manufacturePojo(HospedajeLugarEntity.class);
                muestraHospedajes.add(hospedaje);                       
            }
            entity.setHospedajesLugares(muestraHospedajes);
            entity.setUbicacion(ubicacion);
            data.add(entity);
        }
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHospedajesLugares method, of class LugaresInteresEntity.
     */
    @Test
    public void testGetHospedajesLugares() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setHospedajesLugares(data.get(1).getHospedajesLugares());
        assertEquals(muestra.getHospedajesLugares().size(), data.get(1).getHospedajesLugares().size());
    }

    /**
     * Test of setHospedajesLugares method, of class LugaresInteresEntity.
     */
    @Test
    public void testSetHospedajesLugares() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setHospedajesLugares(data.get(1).getHospedajesLugares());
        assertEquals(muestra.getHospedajesLugares().size(), data.get(1).getHospedajesLugares().size());
    }

    /**
     * Test of getUbicacion method, of class LugaresInteresEntity.
     */
    @Test
    public void testGetUbicacion() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setUbicacion(data.get(1).getUbicacion());
        assertEquals(muestra.getUbicacion().getId(), data.get(1).getUbicacion().getId());
    }

    /**
     * Test of setUbicacion method, of class LugaresInteresEntity.
     */
    @Test
    public void testSetUbicacion() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setUbicacion(data.get(1).getUbicacion());
        assertEquals(muestra.getUbicacion().getId(), data.get(1).getUbicacion().getId());
    }

    /**
     * Test of getDescripcion method, of class LugaresInteresEntity.
     */
    @Test
    public void testGetDescripcion() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setDescripcion(data.get(1).getDescripcion());
        assertEquals(muestra.getDescripcion(), data.get(1).getDescripcion());
    }

    /**
     * Test of setDescripcion method, of class LugaresInteresEntity.
     */
    @Test
    public void testSetDescripcion() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setDescripcion(data.get(1).getDescripcion());
        assertEquals(muestra.getDescripcion(), data.get(1).getDescripcion());
    }

    /**
     * Test of getDistancia method, of class LugaresInteresEntity.
     */
    @Test
    public void testGetDistancia() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setDistancia(data.get(1).getDistancia());
        assertTrue((muestra.getDistancia()-data.get(1).getDistancia())==0.0);
    }

    /**
     * Test of setDistancia method, of class LugaresInteresEntity.
     */
    @Test
    public void testSetDistancia() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setDistancia(data.get(1).getDistancia());
        assertTrue((muestra.getDistancia()-data.get(1).getDistancia())==0.0);
    }

    /**
     * Test of getRutaImagen method, of class LugaresInteresEntity.
     */
    @Test
    public void testGetRutaImagen() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setRutaImagen(data.get(1).getRutaImagen());
        assertEquals(muestra.getRutaImagen(), data.get(1).getRutaImagen());
    }

    /**
     * Test of setRutaImagen method, of class LugaresInteresEntity.
     */
    @Test
    public void testSetRutaImagen() {
        LugaresInteresEntity muestra = data.get(0);
        muestra.setRutaImagen(data.get(1).getRutaImagen());
        assertEquals(muestra.getRutaImagen(), data.get(1).getRutaImagen());
    }    
}
