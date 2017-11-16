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
public class ReservaEntityTest {
    private List<ReservaEntity> data = new ArrayList<>();
    
    public ReservaEntityTest() {
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
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDetalleReserva method, of class ReservaEntity.
     */
    @Test
    public void testGetDetalleReserva() {
        ReservaEntity reserva = data.get(0);
        reserva.setDetalleReserva(generarDetalleReserva());
        Assert.assertNotNull(reserva.getDetalleReserva());
        Assert.assertTrue(reserva.getDetalleReserva().size() == 3);
        Assert.assertTrue(reserva.getDetalleReserva().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(reserva.getDetalleReserva().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(reserva.getDetalleReserva().get(2).getId().equals(new Long(3)));
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
     * Test of getHospedaje method, of class ReservaEntity.
     */
    @Test
    public void testGetHospedaje() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        HospedajeEntity e  = new HospedajeEntity();
        e.setId(new Long(0));
        entidad.setHospedaje(e);
        entidadT.setHospedaje(e);
        Assert.assertTrue(entidad.getHospedaje().equals(entidadT.getHospedaje()));
    }

    /**
     * Test of setHospedaje method, of class ReservaEntity.
     */
    @Test
    public void testSetHospedaje() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        HospedajeEntity e  = new HospedajeEntity();
        e.setId(new Long(0));
        entidad.setHospedaje(e);
        entidadT.setHospedaje(e);
        Assert.assertTrue(entidad.getHospedaje().equals(entidadT.getHospedaje()));
    }

    /**
     * Test of getEstudiante method, of class ReservaEntity.
     */
    @Test
    public void testGetEstudiante() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        EstudianteEntity e  = new EstudianteEntity();
        e.setId(new Long(0));
        entidad.setEstudiante(e);
        entidadT.setEstudiante(e);
        Assert.assertTrue(entidad.getEstudiante().equals(entidadT.getEstudiante()));
    }

    /**
     * Test of setEstudiante method, of class ReservaEntity.
     */
    @Test
    public void testSetEstudiante() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        EstudianteEntity e  = new EstudianteEntity();
        e.setId(new Long(0));
        entidad.setEstudiante(e);
        entidadT.setEstudiante(e);
        Assert.assertTrue(entidad.getEstudiante().equals(entidadT.getEstudiante()));
    }

    /**
     * Test of setDetalleReserva method, of class ReservaEntity.
     */
    @Test
    public void testSetDetalleReserva() {
        ReservaEntity hospedajeT = data.get(0);
        hospedajeT.setDetalleReserva(generarDetalleReserva());
        Assert.assertNotNull(hospedajeT.getDetalleReserva());
        Assert.assertTrue(hospedajeT.getDetalleReserva().size() == 3);
        Assert.assertTrue(hospedajeT.getDetalleReserva().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getDetalleReserva().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getDetalleReserva().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of getId method, of class ReservaEntity.
     */
    @Test
    public void testGetId() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setId(entidadT.getId());
        Assert.assertTrue(entidad.getId().equals(entidadT.getId()));
    }

    /**
     * Test of setId method, of class ReservaEntity.
     */
    @Test
    public void testSetId() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setId(entidadT.getId());
        Assert.assertTrue(entidad.getId().equals(entidadT.getId()));
    }

    /**
     * Test of getCedulaHuesped method, of class ReservaEntity.
     */
    @Test
    public void testGetCedulaHuesped() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setCedulaHuesped(entidadT.getCedulaHuesped());
        Assert.assertTrue(entidad.getCedulaHuesped() == entidadT.getCedulaHuesped());
    }

    /**
     * Test of setCedulaHuesped method, of class ReservaEntity.
     */
    @Test
    public void testSetCedulaHuesped() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setCedulaHuesped(entidadT.getCedulaHuesped());
        Assert.assertTrue(entidad.getCedulaHuesped() == entidadT.getCedulaHuesped());
    }

    /**
     * Test of getIdHospedaje method, of class ReservaEntity.
     */
    @Test
    public void testGetIdHospedaje() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setIdHospedaje(entidadT.getIdHospedaje());
        Assert.assertTrue(entidad.getIdHospedaje() == entidadT.getIdHospedaje());
    }

    /**
     * Test of setIdHospedaje method, of class ReservaEntity.
     */
    @Test
    public void testSetIdHospedaje() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setIdHospedaje(entidadT.getIdHospedaje());
        Assert.assertTrue(entidad.getIdHospedaje() == entidadT.getIdHospedaje());
    }

    /**
     * Test of getFechaInicio method, of class ReservaEntity.
     */
    @Test
    public void testGetFechaInicio() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setFechaInicio(entidadT.getFechaInicio());
        Assert.assertTrue(entidad.getFechaInicio().equals(entidadT.getFechaInicio()));
    }

    /**
     * Test of setFechaInicio method, of class ReservaEntity.
     */
    @Test
    public void testSetFechaInicio() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setFechaInicio(entidadT.getFechaInicio());
        Assert.assertTrue(entidad.getFechaInicio().equals(entidadT.getFechaInicio()));
    }

    /**
     * Test of getFechaFin method, of class ReservaEntity.
     */
    @Test
    public void testGetFechaFin() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setFechaFin(entidadT.getFechaFin());
        Assert.assertTrue(entidad.getFechaFin().equals(entidadT.getFechaFin()));
    }

    /**
     * Test of setFechaFin method, of class ReservaEntity.
     */
    @Test
    public void testSetFechaFin() {
        ReservaEntity entidadT = data.get(0);
        ReservaEntity entidad = new ReservaEntity();
        entidad.setFechaFin(entidadT.getFechaFin());
        Assert.assertTrue(entidad.getFechaFin().equals(entidadT.getFechaFin()));
    }
    
}
