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
public class FacturaEntityTest {
    private List<FacturaEntity> data = new ArrayList<>();
    
    public FacturaEntityTest() {
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
            FacturaEntity entity = factory.manufacturePojo(FacturaEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDetalleServicio method, of class FacturaEntity.
     */
    @Test
    public void testGetDetalleServicio() {
        FacturaEntity hospedajeT = data.get(0);
        hospedajeT.setDetalleServicio(generarDetalleServivio());
        Assert.assertNotNull(hospedajeT.getDetalleServicio());
        Assert.assertTrue(hospedajeT.getDetalleServicio().size() == 3);
        Assert.assertTrue(hospedajeT.getDetalleServicio().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getDetalleServicio().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getDetalleServicio().get(2).getId().equals(new Long(3)));
    }
    
    private List<DetalleServicioEntity> generarDetalleServivio()
    {
        List<DetalleServicioEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            DetalleServicioEntity add = new DetalleServicioEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setDetalleServicio method, of class FacturaEntity.
     */
    @Test
    public void testSetDetalleServicio() {
        FacturaEntity hospedajeT = data.get(0);
        hospedajeT.setDetalleServicio(generarDetalleServivio());
        Assert.assertNotNull(hospedajeT.getDetalleServicio());
        Assert.assertTrue(hospedajeT.getDetalleServicio().size() == 3);
        Assert.assertTrue(hospedajeT.getDetalleServicio().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getDetalleServicio().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getDetalleServicio().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of getDetallesReserva method, of class FacturaEntity.
     */
    @Test
    public void testGetDetallesReserva() {
        FacturaEntity hospedajeT = data.get(0);
        hospedajeT.setDetallesReserva(generarDetalleReserva());
        Assert.assertNotNull(hospedajeT.getDetallesReserva());
        Assert.assertTrue(hospedajeT.getDetallesReserva().size() == 3);
        Assert.assertTrue(hospedajeT.getDetallesReserva().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getDetallesReserva().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getDetallesReserva().get(2).getId().equals(new Long(3)));
    }
    
    private List<DetalleReservaEntity> generarDetalleReserva()
    {
        List<DetalleReservaEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            DetalleReservaEntity add = new DetalleReservaEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setDetallesReserva method, of class FacturaEntity.
     */
    @Test
    public void testSetDetallesReserva() {
        FacturaEntity hospedajeT = data.get(0);
        hospedajeT.setDetallesReserva(generarDetalleReserva());
        Assert.assertNotNull(hospedajeT.getDetallesReserva());
        Assert.assertTrue(hospedajeT.getDetallesReserva().size() == 3);
        Assert.assertTrue(hospedajeT.getDetallesReserva().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getDetallesReserva().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getDetallesReserva().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of getHospedaje method, of class FacturaEntity.
     */
    @Test
    public void testGetHospedaje() {
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(new Long(23));
        FacturaEntity factura = new FacturaEntity();
        factura.setHospedaje(hospedaje);
        Assert.assertTrue(factura.getHospedaje().getId().equals(hospedaje.getId()));
    }

    /**
     * Test of setHospedaje method, of class FacturaEntity.
     */
    @Test
    public void testSetHospedaje() {
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(new Long(23));
        FacturaEntity factura = new FacturaEntity();
        factura.setHospedaje(hospedaje);
        Assert.assertTrue(factura.getHospedaje().getId().equals(hospedaje.getId()));
    }

    /**
     * Test of getEstudiante method, of class FacturaEntity.
     */
    @Test
    public void testGetEstudiante() {
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setId(new Long(23));
        FacturaEntity factura = new FacturaEntity();
        factura.setEstudiante(estudiante);
        Assert.assertTrue(factura.getEstudiante().getId().equals(estudiante.getId()));
    }

    /**
     * Test of setEstudiante method, of class FacturaEntity.
     */
    @Test
    public void testSetEstudiante() {
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setId(new Long(23));
        FacturaEntity factura = new FacturaEntity();
        factura.setEstudiante(estudiante);
        Assert.assertTrue(factura.getEstudiante().getId().equals(estudiante.getId()));
    }

    /**
     * Test of getId method, of class FacturaEntity.
     */
    @Test
    public void testGetId() {
        FacturaEntity entidadT = data.get(0);
        FacturaEntity entidad = new FacturaEntity();
        entidad.setId(entidadT.getId());
        Assert.assertTrue(entidad.getId().equals(entidadT.getId()));
    }

    /**
     * Test of setId method, of class FacturaEntity.
     */
    @Test
    public void testSetId() {
        FacturaEntity entidadT = data.get(0);
        FacturaEntity entidad = new FacturaEntity();
        entidad.setId(entidadT.getId());
        Assert.assertTrue(entidad.getId().equals(entidadT.getId()));
    }

    /**
     * Test of getFecha method, of class FacturaEntity.
     */
    @Test
    public void testGetFecha() {
        FacturaEntity entidadT = data.get(0);
        FacturaEntity entidad = new FacturaEntity();
        entidad.setFecha(entidadT.getFecha());
        Assert.assertTrue(entidad.getFecha().equals(entidadT.getFecha()));
    }

    /**
     * Test of setFecha method, of class FacturaEntity.
     */
    @Test
    public void testSetFecha() {
        FacturaEntity entidadT = data.get(0);
        FacturaEntity entidad = new FacturaEntity();
        entidad.setFecha(entidadT.getFecha());
        Assert.assertTrue(entidad.getFecha().equals(entidadT.getFecha()));
    }

    /**
     * Test of getTotal method, of class FacturaEntity.
     */
    @Test
    public void testGetTotal() {
        FacturaEntity entidadT = data.get(0);
        FacturaEntity entidad = new FacturaEntity();
        entidad.setTotal(entidadT.getTotal());
        Assert.assertTrue(entidad.getTotal() == entidadT.getTotal());
    }

    /**
     * Test of setTotal method, of class FacturaEntity.
     */
    @Test
    public void testSetTotal() {
        FacturaEntity entidadT = data.get(0);
        FacturaEntity entidad = new FacturaEntity();
        entidad.setTotal(entidadT.getTotal());
        Assert.assertTrue(entidad.getTotal() == entidadT.getTotal());
    }

    /**
     * Test of getIva method, of class FacturaEntity.
     */
    @Test
    public void testGetIva() {
        FacturaEntity entidadT = data.get(0);
        FacturaEntity entidad = new FacturaEntity();
        entidad.setIva(entidadT.getIva());
        Assert.assertTrue(entidad.getIva() == entidadT.getIva());
    }

    /**
     * Test of setIva method, of class FacturaEntity.
     */
    @Test
    public void testSetIva() {
        FacturaEntity entidadT = data.get(0);
        FacturaEntity entidad = new FacturaEntity();
        entidad.setIva(entidadT.getIva());
        Assert.assertTrue(entidad.getIva() == entidadT.getIva());
    }
    
}
