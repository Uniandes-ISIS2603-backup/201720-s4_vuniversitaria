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
public class ReglaEntityTest {

    public ReglaEntityTest() {
    }

    private List<ReglaEntity> data = new ArrayList<>();

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
            ReglaEntity entity = factory.manufacturePojo(ReglaEntity.class);
            data.add(entity);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegla method, of class ReglaEntity.
     */
    @Test
    public void testGetRegla() {
        ReglaEntity reglaT = data.get(0);
        ReglaEntity regla = new ReglaEntity();
        regla.setRegla(reglaT.getRegla());
        Assert.assertTrue(regla.getRegla().equals(reglaT.getRegla()));
    }

    /**
     * Test of setRegla method, of class ReglaEntity.
     */
    @Test
    public void testSetRegla() {
        ReglaEntity reglaT = data.get(0);
        ReglaEntity regla = new ReglaEntity();
        regla.setRegla(reglaT.getRegla());
        Assert.assertTrue(regla.getRegla().equals(reglaT.getRegla()));
    }

    /**
     * Test of getId method, of class ReglaEntity.
     */
    @Test
    public void testGetId() {
        ReglaEntity reglaT = data.get(0);
        ReglaEntity regla = new ReglaEntity();
        regla.setId(reglaT.getId());
        Assert.assertTrue(regla.getId().equals(reglaT.getId()));
    }

    /**
     * Test of setId method, of class ReglaEntity.
     */
    @Test
    public void testSetId() {
        ReglaEntity reglaT = data.get(0);
        ReglaEntity regla = new ReglaEntity();
        regla.setId(reglaT.getId());
        Assert.assertTrue(regla.getId().equals(reglaT.getId()));
    }

    /**
     * Test of getHospedaje method, of class ReglaEntity.
     */
    @Test
    public void testGetHospedaje() {
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(new Long(23));
        ReglaEntity regla = new ReglaEntity();
        regla.setHospedaje(hospedaje);
        Assert.assertTrue(regla.getHospedaje().getId().equals(hospedaje.getId()));
    }

    /**
     * Test of setHospedaje method, of class ReglaEntity.
     */
    @Test
    public void testSetHospedaje() {
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(new Long(23));
        ReglaEntity regla = new ReglaEntity();
        regla.setHospedaje(hospedaje);
        Assert.assertTrue(regla.getHospedaje().getId().equals(hospedaje.getId()));
    }

    /**
     * Test of equals method, of class ReglaEntity.
     */
    @Test
    public void testEquals() {
        ReglaEntity reglaT = data.get(0);
        Assert.assertTrue(reglaT.equals(data.get(0)));
        BaseEntity base = new BaseEntity() {
        };
        base.setId(new Long(89));
        reglaT.setId(new Long(89));
        Assert.assertTrue(!reglaT.equals(base));
    }

    /**
     * Test of hashCode method, of class ReglaEntity.
     */
    @Test
    public void testHashCode() {
        ReglaEntity reglaT = data.get(0);
        Long id = new Long(3);
        reglaT.setId(new Long(3));
        Assert.assertEquals(id, new Long(reglaT.hashCode()));
    }

}
