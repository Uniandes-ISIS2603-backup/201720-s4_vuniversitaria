/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import co.edu.uniandes.csw.viviendaUniversitaria.persistence.ArrendadorPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ws.duarte
 */
@RunWith(Arquillian.class)
public class HospedajeLugarEntityTest {
    
    @Inject
    UserTransaction utx;
    private List<HospedajeLugarEntity> data = new ArrayList<HospedajeLugarEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HospedajeLugarEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
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
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    private void clearData() {
        data = new ArrayList<HospedajeLugarEntity>();
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
