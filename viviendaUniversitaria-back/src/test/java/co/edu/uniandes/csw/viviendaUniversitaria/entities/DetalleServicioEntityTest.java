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
public class DetalleServicioEntityTest {

    private List<DetalleServicioEntity> data = new ArrayList<>();

    public DetalleServicioEntityTest() {
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
            DetalleServicioEntity entity = factory.manufacturePojo(DetalleServicioEntity.class);
            data.add(entity);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class DetalleServicioEntity.
     */
    @Test
    public void testGetId() {
        DetalleServicioEntity detalleT = data.get(0);
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setId(detalleT.getId());
        Assert.assertTrue(detalle.getId().equals(detalleT.getId()));
    }

    /**
     * Test of setId method, of class DetalleServicioEntity.
     */
    @Test
    public void testSetId() {
        DetalleServicioEntity detalleT = data.get(0);
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setId(detalleT.getId());
        Assert.assertTrue(detalle.getId().equals(detalleT.getId()));
    }

    /**
     * Test of getCantidad method, of class DetalleServicioEntity.
     */
    @Test
    public void testGetCantidad() {
        DetalleServicioEntity detalleT = data.get(0);
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setCantidad(detalleT.getCantidad());
        Assert.assertTrue(detalle.getCantidad().equals(detalleT.getCantidad()));
    }

    /**
     * Test of setCantidad method, of class DetalleServicioEntity.
     */
    @Test
    public void testSetCantidad() {
        DetalleServicioEntity detalleT = data.get(0);
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setCantidad(detalleT.getCantidad());
        Assert.assertTrue(detalle.getCantidad().equals(detalleT.getCantidad()));
    }

    /**
     * Test of getSubTotal method, of class DetalleServicioEntity.
     */
    @Test
    public void testGetSubTotal() {
        DetalleServicioEntity detalleT = data.get(0);
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setSubTotal(detalleT.getSubTotal());
        Assert.assertTrue(detalle.getSubTotal().equals(detalleT.getSubTotal()));
    }

    /**
     * Test of setSubTotal method, of class DetalleServicioEntity.
     */
    @Test
    public void testSetSubTotal() {
        DetalleServicioEntity detalleT = data.get(0);
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setSubTotal(detalleT.getSubTotal());
        Assert.assertTrue(detalle.getSubTotal().equals(detalleT.getSubTotal()));
    }

    /**
     * Test of getFactura method, of class DetalleServicioEntity.
     */
    @Test
    public void testGetFactura() {
        FacturaEntity factura = new FacturaEntity();
        factura.setId(new Long(23));
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setFactura(factura);
        Assert.assertTrue(detalle.getFactura().getId().equals(factura.getId()));
    }

    /**
     * Test of setFactura method, of class DetalleServicioEntity.
     */
    @Test
    public void testSetFactura() {
        FacturaEntity factura = new FacturaEntity();
        factura.setId(new Long(23));
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setFactura(factura);
        Assert.assertTrue(detalle.getFactura().getId().equals(factura.getId()));
    }

    /**
     * Test of getServicio method, of class DetalleServicioEntity.
     */
    @Test
    public void testGetServicio() {
        ServiciosEntity servicio = new ServiciosEntity();
        servicio.setId(new Long(23));
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setServicio(servicio);
        Assert.assertTrue(detalle.getServicio().getId().equals(servicio.getId()));
    }

    /**
     * Test of setServicio method, of class DetalleServicioEntity.
     */
    @Test
    public void testSetServicio() {
        ServiciosEntity servicio = new ServiciosEntity();
        servicio.setId(new Long(23));
        DetalleServicioEntity detalle = new DetalleServicioEntity();
        detalle.setServicio(servicio);
        Assert.assertTrue(detalle.getServicio().getId().equals(servicio.getId()));
    }

    /**
     * Test of equals method, of class DetalleServicioEntity.
     */
    @Test
    public void testEquals() {
        DetalleServicioEntity detalleT = data.get(0);
        Assert.assertTrue(detalleT.equals(data.get(0)));
        Assert.assertFalse(detalleT.equals(new HospedajeEntity()));
    }

    /**
     * Test of hashCode method, of class DetalleServicioEntity.
     */
    @Test
    public void testHashCode() {
        DetalleServicioEntity detalleT = data.get(0);
        Long id = new Long(3);
        detalleT.setId(new Long(3));
        Assert.assertEquals(id, new Long(detalleT.hashCode()));
    }

}
