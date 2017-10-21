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
public class DetalleReservaEntityTest {
    
    public DetalleReservaEntityTest() {
    }
    
    private List<DetalleReservaEntity> data = new ArrayList<>();
    
    
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
        Assert.assertFalse(detalleT .equals(new HospedajeEntity()));
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
