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
public class CalificacionEntityTest {
    private List<CalificacionEntity> data = new ArrayList<>();
    
    public CalificacionEntityTest() {
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
            CalificacionEntity entity = factory.manufacturePojo(CalificacionEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class CalificacionEntity.
     */
    @Test
    public void testGetId() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setId(entidadT.getId());
        Assert.assertTrue(entidad.getId().equals(entidadT.getId()));
    }

    /**
     * Test of setId method, of class CalificacionEntity.
     */
    @Test
    public void testSetId() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setId(entidadT.getId());
        Assert.assertTrue(entidad.getId().equals(entidadT.getId()));
    }

    /**
     * Test of getValoracion method, of class CalificacionEntity.
     */
    @Test
    public void testGetValoracion() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setValoracion(entidadT.getValoracion());
        Assert.assertTrue(entidad.getValoracion() == entidadT.getValoracion());
    }

    /**
     * Test of getFecha method, of class CalificacionEntity.
     */
    @Test
    public void testGetFecha() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setFecha(entidadT.getFecha());
        Assert.assertTrue(entidad.getFecha().equals(entidadT.getFecha()));
    }

    /**
     * Test of getComentario method, of class CalificacionEntity.
     */
    @Test
    public void testGetComentario() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setComentario(entidadT.getComentario());
        Assert.assertTrue(entidad.getComentario().equals(entidadT.getComentario()));
    }

    /**
     * Test of getHospedaje method, of class CalificacionEntity.
     */
    @Test
    public void testGetHospedaje() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        HospedajeEntity h  = new HospedajeEntity();
        h.setId(new Long(0));
        entidad.setHospedaje(h);
        entidadT.setHospedaje(h);
        Assert.assertTrue(entidad.getHospedaje().equals(entidadT.getHospedaje()));
    }

    /**
     * Test of getEstudiante method, of class CalificacionEntity.
     */
    @Test
    public void testGetEstudiante() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        EstudianteEntity e  = new EstudianteEntity();
        e.setId(new Long(0));
        entidad.setEstudiante(e);
        entidadT.setEstudiante(e);
        Assert.assertTrue(entidad.getEstudiante().equals(entidadT.getEstudiante()));
    }

    /**
     * Test of setHospedaje method, of class CalificacionEntity.
     */
    @Test
    public void testSetHospedaje() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        HospedajeEntity h  = new HospedajeEntity();
        h.setId(new Long(0));
        entidad.setHospedaje(h);
        entidadT.setHospedaje(h);
        Assert.assertTrue(entidad.getHospedaje().equals(entidadT.getHospedaje()));
    }

    /**
     * Test of setEstudiante method, of class CalificacionEntity.
     */
    @Test
    public void testSetEstudiante() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        EstudianteEntity e  = new EstudianteEntity();
        e.setId(new Long(0));
        entidad.setEstudiante(e);
        entidadT.setEstudiante(e);
        Assert.assertTrue(entidad.getEstudiante().equals(entidadT.getEstudiante()));
    }

    /**
     * Test of setValoracion method, of class CalificacionEntity.
     */
    @Test
    public void testSetValoracion() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setValoracion(entidadT.getValoracion());
        Assert.assertTrue(entidad.getValoracion() == entidadT.getValoracion());
    }

    /**
     * Test of setFecha method, of class CalificacionEntity.
     */
    @Test
    public void testSetFecha() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setFecha(entidadT.getFecha());
        Assert.assertTrue(entidad.getFecha().equals(entidadT.getFecha()));
    }

    /**
     * Test of setComentario method, of class CalificacionEntity.
     */
    @Test
    public void testSetComentario() {
        CalificacionEntity entidadT = data.get(0);
        CalificacionEntity entidad = new CalificacionEntity();
        entidad.setComentario(entidadT.getComentario());
        Assert.assertTrue(entidad.getComentario().equals(entidadT.getComentario()));
    }

    /**
     * Test of equals method, of class CalificacionEntity.
     */
    @Test
    public void testEquals() {
        CalificacionEntity entidadT = data.get(0);
        Assert.assertTrue(entidadT.equals(data.get(0)));
        Assert.assertFalse(entidadT.equals(new ServiciosEntity()));
    }

    /**
     * Test of hashCode method, of class CalificacionEntity.
     */
    @Test
    public void testHashCode() {
        CalificacionEntity entidadT = data.get(0);
        entidadT.setId(new Long(3));
        Assert.assertEquals(data.get(0).hashCode(), entidadT.hashCode());
    }
    
}
