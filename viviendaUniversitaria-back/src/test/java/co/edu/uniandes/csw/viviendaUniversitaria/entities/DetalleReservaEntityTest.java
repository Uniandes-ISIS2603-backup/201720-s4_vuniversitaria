/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

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
public class DetalleReservaEntityTest {
    
    public DetalleReservaEntityTest() {
    }
    
     @Inject
    UserTransaction utx;
    private List<DetalleReservaEntity> data = new ArrayList<DetalleReservaEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DetalleReservaEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
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
        data = new ArrayList<DetalleReservaEntity>();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DetalleReservaEntity entity = factory.manufacturePojo(DetalleReservaEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class DetalleReservaEntity.
     */
    @Test
    public void testGetId() {
        DetalleReservaEntity detalleT = data.get(0);
        DetalleReservaEntity detalle = new DetalleReservaEntity();
        detalle.setId(detalleT.getId());
        Assert.assertTrue(detalle.getId().equals(detalleT.getId()));
    }

    /**
     * Test of setId method, of class DetalleReservaEntity.
     */
    @Test
    public void testSetId() {
        DetalleReservaEntity detalleT = data.get(0);
        DetalleReservaEntity detalle = new DetalleReservaEntity();
        detalle.setId(detalleT.getId());
        Assert.assertTrue(detalle.getId().equals(detalleT.getId()));
    }

    /**
     * Test of getSubTotal method, of class DetalleReservaEntity.
     */
    @Test
    public void testGetSubTotal() {
        DetalleReservaEntity detalleT = data.get(0);
        DetalleReservaEntity detalle = new DetalleReservaEntity();
        detalle.setSubTotal(detalleT.getSubTotal());
        Assert.assertTrue(detalle.getSubTotal().equals(detalleT.getSubTotal()));
    }

    /**
     * Test of setSubTotal method, of class DetalleReservaEntity.
     */
    @Test
    public void testSetSubTotal() {
        DetalleReservaEntity detalleT = data.get(0);
        DetalleReservaEntity detalle = new DetalleReservaEntity();
        detalle.setSubTotal(detalleT.getSubTotal());
        Assert.assertTrue(detalle.getSubTotal().equals(detalleT.getSubTotal()));
    }

    /**
     * Test of getFactura method, of class DetalleReservaEntity.
     */
    @Test
    public void testGetFactura() {
        FacturaEntity factura = new FacturaEntity();
        factura.setId(new Long(23));
        DetalleReservaEntity detalle = new DetalleReservaEntity();
        detalle.setFactura(factura);
        Assert.assertTrue(detalle.getFactura().getId().equals(factura.getId()));
    }

    /**
     * Test of setFactura method, of class DetalleReservaEntity.
     */
    @Test
    public void testSetFactura() {
        FacturaEntity factura = new FacturaEntity();
        factura.setId(new Long(23));
        DetalleReservaEntity detalle = new DetalleReservaEntity();
        detalle.setFactura(factura);
        Assert.assertTrue(detalle.getFactura().getId().equals(factura.getId()));
    }

    /**
     * Test of getReserva method, of class DetalleReservaEntity.
     */
    @Test
    public void testGetReserva() {
        ReservaEntity servicio = new ReservaEntity();
        servicio.setId(new Long(23));
        DetalleReservaEntity detalle = new DetalleReservaEntity();
        detalle.setReserva(servicio);
        Assert.assertTrue(detalle.getReserva().getId().equals(servicio.getId()));
    }

    /**
     * Test of setReserva method, of class DetalleReservaEntity.
     */
    @Test
    public void testSetReserva() {
        ReservaEntity servicio = new ReservaEntity();
        servicio.setId(new Long(23));
        DetalleReservaEntity detalle = new DetalleReservaEntity();
        detalle.setReserva(servicio);
        Assert.assertTrue(detalle.getReserva().getId().equals(servicio.getId()));
    }

    /**
     * Test of equals method, of class DetalleReservaEntity.
     */
    @Test
    public void testEquals() {
        DetalleReservaEntity detalleT =  data.get(0);
        Assert.assertTrue(detalleT .equals(data.get(0)));
    }

    /**
     * Test of hashCode method, of class DetalleReservaEntity.
     */
    @Test
    public void testHashCode() {
        DetalleReservaEntity detalleT = data.get(0);
        Long id = new Long(3);
        detalleT.setId(new Long(3));
        Assert.assertEquals(id, new Long(detalleT.hashCode()));
    }
    
}
