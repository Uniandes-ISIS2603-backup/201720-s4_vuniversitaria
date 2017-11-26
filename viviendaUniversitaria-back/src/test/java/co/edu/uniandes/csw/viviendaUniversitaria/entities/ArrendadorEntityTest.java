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
public class ArrendadorEntityTest {
    private List<ArrendadorEntity> data = new ArrayList<>();
    
    public ArrendadorEntityTest() {
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
            ArrendadorEntity entity = factory.manufacturePojo(ArrendadorEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class ArrendadorEntity.
     */
    @Test
    public void testGetId() {
        ArrendadorEntity arrendador = data.get(0);
        ArrendadorEntity arrendadorT = new ArrendadorEntity();
        arrendadorT.setId(arrendador.getId());
        Assert.assertTrue(arrendadorT.getId().equals(arrendador.getId())); 
    }

    /**
     * Test of getNombre method, of class ArrendadorEntity.
     */
    @Test
    public void testGetNombre() {
        ArrendadorEntity arrendador = data.get(0);
        ArrendadorEntity arrendadorT = new ArrendadorEntity();
        arrendadorT.setNombre(arrendador.getNombre());
        Assert.assertTrue(arrendadorT.getNombre().equals(arrendador.getNombre()));
    }

    /**
     * Test of setId method, of class ArrendadorEntity.
     */
    @Test
    public void testSetId() {
        ArrendadorEntity arrendador = data.get(0);
        ArrendadorEntity arrendadorT = new ArrendadorEntity();
        arrendadorT.setId(arrendador.getId());
        Assert.assertTrue(arrendadorT.getId().equals(arrendador.getId()));
    }

    /**
     * Test of setNombre method, of class ArrendadorEntity.
     */
    @Test
    public void testSetNombre() {
        ArrendadorEntity arrendador = data.get(0);
        ArrendadorEntity arrendadorT = new ArrendadorEntity();
        arrendadorT.setNombre(arrendador.getNombre());
        Assert.assertTrue(arrendadorT.getNombre().equals(arrendador.getNombre()));
    }

    /**
     * Test of getHospedajes method, of class ArrendadorEntity.
     */
    @Test
    public void testGetHospedajes() {
        ArrendadorEntity arrendadorT = data.get(0);
        arrendadorT.setHospedajes(generarHospedajes());
        Assert.assertNotNull(arrendadorT.getHospedajes());
        Assert.assertTrue(arrendadorT.getHospedajes().size() == 3);
        Assert.assertTrue(arrendadorT.getHospedajes().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(arrendadorT.getHospedajes().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(arrendadorT.getHospedajes().get(2).getId().equals(new Long(3)));
    }
    
    private List<HospedajeEntity> generarHospedajes()
    {
        List<HospedajeEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            HospedajeEntity add = new HospedajeEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setHospedajes method, of class ArrendadorEntity.
     */
    @Test
    public void testSetHospedajes() {
        ArrendadorEntity arrendadorT = data.get(0);
        arrendadorT.setHospedajes(generarHospedajes());
        Assert.assertNotNull(arrendadorT.getHospedajes());
        Assert.assertTrue(arrendadorT.getHospedajes().size() == 3);
        Assert.assertTrue(arrendadorT.getHospedajes().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(arrendadorT.getHospedajes().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(arrendadorT.getHospedajes().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of getRuta method, of class ArrendadorEntity.
     */
    @Test
    public void testGetRuta() {
        ArrendadorEntity arrendador = data.get(0);
        arrendador.setRuta("/esta/es/una/ruta");
        ArrendadorEntity arrendadorT = new ArrendadorEntity();
        arrendadorT.setRuta(arrendador.getRuta());
        Assert.assertTrue(arrendadorT.getRuta().equals(arrendador.getRuta()));
    }

    /**
     * Test of setRuta method, of class ArrendadorEntity.
     */
    @Test
    public void testSetRuta() {
        ArrendadorEntity arrendador = data.get(0);
        arrendador.setRuta("/esta/es/una/ruta");
        ArrendadorEntity arrendadorT = new ArrendadorEntity();
        arrendadorT.setRuta(arrendador.getRuta());
        Assert.assertTrue(arrendadorT.getRuta().equals(arrendador.getRuta()));
    }

    /**
     * Test of equals method, of class ArrendadorEntity.
     */
    @Test
    public void testEquals() {
        ArrendadorEntity arrendador =  data.get(0);
        Assert.assertTrue(arrendador.equals(data.get(0)));
        Assert.assertFalse(arrendador.equals(new ServiciosEntity()));
    }

    /**
     * Test of hashCode method, of class ArrendadorEntity.
     */
    @Test
    public void testHashCode() {
        ArrendadorEntity hospedajeT = data.get(0);
        hospedajeT.setId(new Long(3));
        Assert.assertEquals(data.get(0).hashCode(), hospedajeT.hashCode());
    }
    
}
