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
public class HospedajeLugarEntityTest {
    private List<HospedajeLugarEntity> data = new ArrayList<>();

    public HospedajeLugarEntityTest() {
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
            HospedajeLugarEntity entity = factory.manufacturePojo(HospedajeLugarEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class HospedajeLugarEntity.
     */
    @Test
    public void testGetId() {
        HospedajeLugarEntity hospedajeT = data.get(0);
        HospedajeLugarEntity hospedaje = new HospedajeLugarEntity();
        hospedaje.setId(hospedajeT.getId());
        Assert.assertTrue(hospedajeT.getId().equals(hospedaje.getId()));
    }

    /**
     * Test of setId method, of class HospedajeLugarEntity.
     */
    @Test
    public void testSetId() {
        HospedajeLugarEntity hospedajeT = data.get(0);
        HospedajeLugarEntity hospedaje = new HospedajeLugarEntity();
        hospedaje.setId(hospedajeT.getId());
        Assert.assertTrue(hospedajeT.getId().equals(hospedaje.getId()));
    }

    /**
     * Test of getDistancia method, of class HospedajeLugarEntity.
     */
    @Test
    public void testGetDistancia() {
        HospedajeLugarEntity hospedajeT = data.get(0);
        HospedajeLugarEntity hospedaje = new HospedajeLugarEntity();
        hospedaje.setDistancia(hospedajeT.getDistancia());
        Assert.assertTrue(hospedajeT.getDistancia().equals(hospedaje.getDistancia()));
    }

    /**
     * Test of setDistancia method, of class HospedajeLugarEntity.
     */
    @Test
    public void testSetDistancia() {
        HospedajeLugarEntity hospedajeT = data.get(0);
        HospedajeLugarEntity hospedaje = new HospedajeLugarEntity();
        hospedaje.setDistancia(hospedajeT.getDistancia());
        Assert.assertTrue(hospedajeT.getDistancia().equals(hospedaje.getDistancia()));
    }

    /**
     * Test of getHospedaje method, of class HospedajeLugarEntity.
     */
    @Test
    public void testGetHospedaje() {
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(new Long(23));
        HospedajeLugarEntity hospedajeL = new HospedajeLugarEntity();
        hospedajeL.setHospedaje(hospedaje);
        Assert.assertTrue(hospedajeL.getHospedaje().getId().equals(hospedaje.getId()));
    }

    /**
     * Test of setHospedaje method, of class HospedajeLugarEntity.
     */
    @Test
    public void testSetHospedaje() {
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(new Long(23));
        HospedajeLugarEntity hospedajeL = new HospedajeLugarEntity();
        hospedajeL.setHospedaje(hospedaje);
        Assert.assertTrue(hospedajeL.getHospedaje().getId().equals(hospedaje.getId()));
    }

    /**
     * Test of getLugarInteres method, of class HospedajeLugarEntity.
     */
    @Test
    public void testGetLugarInteres() {
        LugaresInteresEntity lugar = new LugaresInteresEntity();
        lugar.setId(new Long(23));
        HospedajeLugarEntity hospedajeL = new HospedajeLugarEntity();
        hospedajeL.setLugarInteres(lugar);
        Assert.assertTrue(hospedajeL.getLugarInteres().getId().equals(lugar.getId()));
    }

    /**
     * Test of setLugarInteres method, of class HospedajeLugarEntity.
     */
    @Test
    public void testSetLugarInteres() {
        LugaresInteresEntity lugar = new LugaresInteresEntity();
        lugar.setId(new Long(23));
        HospedajeLugarEntity hospedajeL = new HospedajeLugarEntity();
        hospedajeL.setLugarInteres(lugar);
        Assert.assertTrue(hospedajeL.getLugarInteres().getId().equals(lugar.getId()));
    }

    /**
     * Test of equals method, of class HospedajeLugarEntity.
     */
    @Test
    public void testEquals() {
        HospedajeLugarEntity hospedajeL = data.get(0);
        Assert.assertTrue(hospedajeL.equals(data.get(0)));
        hospedajeL.setId(new Long(2));
        HospedajeEntity h = new HospedajeEntity();
        h.setId(new Long(2));
        Assert.assertFalse(hospedajeL.equals(h));
    }

    /**
     * Test of hashCode method, of class HospedajeLugarEntity.
     */
    @Test
    public void testHashCode() {
        HospedajeLugarEntity hospedajeL = data.get(0);
        Long id = new Long(3);
        hospedajeL.setId(new Long(3));
        Assert.assertEquals(id, new Long(hospedajeL.hashCode()));
    }
    
}
