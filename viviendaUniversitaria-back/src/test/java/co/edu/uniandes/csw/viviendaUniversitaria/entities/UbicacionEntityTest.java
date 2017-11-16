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
public class UbicacionEntityTest {
    private List<UbicacionEntity> data = new ArrayList<>();
    
    public UbicacionEntityTest() {
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
            UbicacionEntity entity = factory.manufacturePojo(UbicacionEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLatitud method, of class UbicacionEntity.
     */
    @Test
    public void testGetLatitud() {
        UbicacionEntity entidadT = data.get(0);
        UbicacionEntity entidad = new UbicacionEntity();
        entidad.setLatitud(entidadT.getLatitud());
        Assert.assertTrue(entidad.getLatitud().equals(entidadT.getLatitud()));
    }

    /**
     * Test of setLatitud method, of class UbicacionEntity.
     */
    @Test
    public void testSetLatitud() {
        UbicacionEntity entidadT = data.get(0);
        UbicacionEntity entidad = new UbicacionEntity();
        entidad.setLatitud(entidadT.getLatitud());
        Assert.assertTrue(entidad.getLatitud().equals(entidadT.getLatitud()));
    }

    /**
     * Test of getLongitud method, of class UbicacionEntity.
     */
    @Test
    public void testGetLongitud() {
        UbicacionEntity entidadT = data.get(0);
        UbicacionEntity entidad = new UbicacionEntity();
        entidad.setLongitud(entidadT.getLongitud());
        Assert.assertTrue(entidad.getLongitud().equals(entidadT.getLongitud()));
    }

    /**
     * Test of setLongitud method, of class UbicacionEntity.
     */
    @Test
    public void testSetLongitud() {
        UbicacionEntity entidadT = data.get(0);
        UbicacionEntity entidad = new UbicacionEntity();
        entidad.setLongitud(entidadT.getLongitud());
        Assert.assertTrue(entidad.getLongitud().equals(entidadT.getLongitud()));
    }

    /**
     * Test of getDireccion method, of class UbicacionEntity.
     */
    @Test
    public void testGetDireccion() {
        UbicacionEntity entidadT = data.get(0);
        UbicacionEntity entidad = new UbicacionEntity();
        entidad.setDireccion(entidadT.getDireccion());
        Assert.assertTrue(entidad.getDireccion().equals(entidadT.getDireccion()));
    }

    /**
     * Test of setDireccion method, of class UbicacionEntity.
     */
    @Test
    public void testSetDireccion() {
        UbicacionEntity entidadT = data.get(0);
        UbicacionEntity entidad = new UbicacionEntity();
        entidad.setDireccion(entidadT.getDireccion());
        Assert.assertTrue(entidad.getDireccion().equals(entidadT.getDireccion()));
    }

    /**
     * Test of equals method, of class UbicacionEntity.
     */
    @Test
    public void testEquals() {
        UbicacionEntity entidadT = data.get(0);
        Assert.assertTrue(entidadT.equals(data.get(0)));
        Assert.assertFalse(entidadT.equals(new ServiciosEntity()));
    }

    /**
     * Test of hashCode method, of class UbicacionEntity.
     */
    @Test
    public void testHashCode() {
        UbicacionEntity entidadT = data.get(0);
        entidadT.setId(new Long(3));
        Assert.assertEquals(data.get(0).hashCode(), entidadT.hashCode());
    }
    
}
