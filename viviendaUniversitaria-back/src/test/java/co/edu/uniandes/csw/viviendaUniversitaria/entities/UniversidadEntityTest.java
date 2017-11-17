/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ws.duarte
 */
public class UniversidadEntityTest {
    private List<UniversidadEntity> data = new ArrayList<>();
    
    public UniversidadEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        clearData();
        insertData();
    }

    private void clearData() {
        data = new ArrayList<>();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            UniversidadEntity entity = factory.manufacturePojo(UniversidadEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getImagen method, of class UniversidadEntity.
     */
    @Test
    public void testGetImagen() {
        UniversidadEntity entidadT = data.get(0);
        UniversidadEntity entidad = new UniversidadEntity();
        entidad.setId(entidadT.getId());
        Assert.assertTrue(entidad.getId().equals(entidadT.getId()));
    }

    /**
     * Test of setImagen method, of class UniversidadEntity.
     */
    @Test
    public void testSetImagen() {
        UniversidadEntity entidadT = data.get(0);
        UniversidadEntity entidad = new UniversidadEntity();
        entidad.setId(entidadT.getId());
        Assert.assertTrue(entidad.getId().equals(entidadT.getId()));
    }

    /**
     * Test of getNombre method, of class UniversidadEntity.
     */
    @Test
    public void testGetNombre() {
        UniversidadEntity entidadT = data.get(0);
        UniversidadEntity entidad = new UniversidadEntity();
        entidad.setNombre(entidadT.getNombre());
        Assert.assertTrue(entidad.getNombre().equals(entidadT.getNombre()));
    }

    /**
     * Test of setNombre method, of class UniversidadEntity.
     */
    @Test
    public void testSetNombre() {
        UniversidadEntity entidadT = data.get(0);
        UniversidadEntity entidad = new UniversidadEntity();
        entidad.setNombre(entidadT.getNombre());
        Assert.assertTrue(entidad.getNombre().equals(entidadT.getNombre()));
    }

    /**
     * Test of getUbicacion method, of class UniversidadEntity.
     */
    @Test
    public void testGetUbicacion() {
        UniversidadEntity entidadT = data.get(0);
        UniversidadEntity entidad = new UniversidadEntity();
        UbicacionEntity h  = new UbicacionEntity();
        h.setId(new Long(0));
        entidad.setUbicacion(h);
        entidadT.setUbicacion(h);
        Assert.assertTrue(entidad.getUbicacion().equals(entidadT.getUbicacion()));
    }

    /**
     * Test of setUbicacion method, of class UniversidadEntity.
     */
    @Test
    public void testSetUbicacion() {
        UniversidadEntity entidadT = data.get(0);
        UniversidadEntity entidad = new UniversidadEntity();
        UbicacionEntity h  = new UbicacionEntity();
        h.setId(new Long(0));
        entidad.setUbicacion(h);
        entidadT.setUbicacion(h);
        Assert.assertTrue(entidad.getUbicacion().equals(entidadT.getUbicacion()));
    }

    /**
     * Test of equals method, of class UniversidadEntity.
     */
    @Test
    public void testEquals() {
        UniversidadEntity entidadT = data.get(0);
        Assert.assertTrue(entidadT.equals(data.get(0)));
        Assert.assertFalse(entidadT.equals(new ServiciosEntity()));
    }

    /**
     * Test of hashCode method, of class UniversidadEntity.
     */
    @Test
    public void testHashCode() {
        UniversidadEntity entidadT = data.get(0);
        entidadT.setId(new Long(3));
        Assert.assertEquals(data.get(0).hashCode(), entidadT.hashCode());
    }
    
}
