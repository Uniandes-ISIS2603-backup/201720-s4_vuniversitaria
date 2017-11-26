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
public class EstudianteEntityTest {
    private List<EstudianteEntity> data = new ArrayList<>();
    
    public EstudianteEntityTest() {
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
            EstudianteEntity entity = factory.manufacturePojo(EstudianteEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getReserva method, of class EstudianteEntity.
     */
    @Test
    public void testGetReserva() {
        EstudianteEntity entidadT = data.get(0);
        EstudianteEntity entidad = new EstudianteEntity();
        ReservaEntity e = new ReservaEntity();
        e.setId(new Long(0));
        entidad.setReserva(e);
        entidadT.setReserva(e);
        Assert.assertTrue(entidad.getReserva().equals(entidadT.getReserva()));
    }

    /**
     * Test of setReserva method, of class EstudianteEntity.
     */
    @Test
    public void testSetReserva() {
        EstudianteEntity entidadT = data.get(0);
        EstudianteEntity entidad = new EstudianteEntity();
        ReservaEntity e = new ReservaEntity();
        e.setId(new Long(0));
        entidad.setReserva(e);
        entidadT.setReserva(e);
        Assert.assertTrue(entidad.getReserva().equals(entidadT.getReserva()));
    }

    /**
     * Test of getCalificaciones method, of class EstudianteEntity.
     */
    @Test
    public void testGetCalificaciones() {
        EstudianteEntity estudiante = data.get(0);
        estudiante.setCalificaciones(generarCalificaciones());
        Assert.assertNotNull(estudiante.getCalificaciones());
        Assert.assertTrue(estudiante.getCalificaciones().size() == 3);
        Assert.assertTrue(estudiante.getCalificaciones().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(estudiante.getCalificaciones().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(estudiante.getCalificaciones().get(2).getId().equals(new Long(3)));
    }
    
    private List<CalificacionEntity> generarCalificaciones()
    {
        List<CalificacionEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            CalificacionEntity add = new CalificacionEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setCalificaciones method, of class EstudianteEntity.
     */
    @Test
    public void testSetCalificaciones() {
        EstudianteEntity estudiante = data.get(0);
        estudiante.setCalificaciones(generarCalificaciones());
        Assert.assertNotNull(estudiante.getCalificaciones());
        Assert.assertTrue(estudiante.getCalificaciones().size() == 3);
        Assert.assertTrue(estudiante.getCalificaciones().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(estudiante.getCalificaciones().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(estudiante.getCalificaciones().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of getNombre method, of class EstudianteEntity.
     */
    @Test
    public void testGetNombre() {
        EstudianteEntity entidadT = data.get(0);
        EstudianteEntity entidad = new EstudianteEntity();
        entidad.setNombre(entidadT.getNombre());
        Assert.assertTrue(entidad.getNombre().equals(entidadT.getNombre()));        
    }

    /**
     * Test of setNombre method, of class EstudianteEntity.
     */
    @Test
    public void testSetNombre() {
        EstudianteEntity entidadT = data.get(0);
        EstudianteEntity entidad = new EstudianteEntity();
        entidad.setNombre(entidadT.getNombre());
        Assert.assertTrue(entidad.getNombre().equals(entidadT.getNombre()));   
    }

    /**
     * Test of getCedula method, of class EstudianteEntity.
     */
    @Test
    public void testGetCedula() {
        EstudianteEntity entidadT = data.get(0);
        EstudianteEntity entidad = new EstudianteEntity();
        entidad.setCedula(entidadT.getCedula());
        Assert.assertTrue(entidad.getCedula().equals(entidadT.getCedula()));   
    }

    /**
     * Test of setCedula method, of class EstudianteEntity.
     */
    @Test
    public void testSetCedula() {
        EstudianteEntity entidadT = data.get(0);
        EstudianteEntity entidad = new EstudianteEntity();
        entidad.setCedula(entidadT.getCedula());
        Assert.assertTrue(entidad.getCedula().equals(entidadT.getCedula()));
    }

    /**
     * Test of getOrigen method, of class EstudianteEntity.
     */
    @Test
    public void testGetOrigen() {
        EstudianteEntity entidadT = data.get(0);
        EstudianteEntity entidad = new EstudianteEntity();
        OrigenEntity e = new OrigenEntity();
        e.setId(new Long(0));
        entidad.setOrigen(e);
        entidadT.setOrigen(e);
        Assert.assertTrue(entidad.getOrigen().equals(entidadT.getOrigen()));
    }

    /**
     * Test of setOrigen method, of class EstudianteEntity.
     */
    @Test
    public void testSetOrigen() {
        EstudianteEntity entidadT = data.get(0);
        EstudianteEntity entidad = new EstudianteEntity();
        OrigenEntity e = new OrigenEntity();
        e.setId(new Long(0));
        entidad.setOrigen(e);
        entidadT.setOrigen(e);
        Assert.assertTrue(entidad.getOrigen().equals(entidadT.getOrigen()));
    }

    /**
     * Test of getFacturas method, of class EstudianteEntity.
     */
    @Test
    public void testGetFacturas() {
        EstudianteEntity estudianteT = data.get(0);
        estudianteT.setFacturas(generarFacturas());
        Assert.assertNotNull(estudianteT.getFacturas());
        Assert.assertTrue(estudianteT.getFacturas().size() == 3);
        Assert.assertTrue(estudianteT.getFacturas().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(estudianteT.getFacturas().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(estudianteT.getFacturas().get(2).getId().equals(new Long(3)));
    }
    
    private List<FacturaEntity> generarFacturas()
    {
        List<FacturaEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            FacturaEntity add = new FacturaEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setFacturas method, of class EstudianteEntity.
     */
    @Test
    public void testSetFacturas() {
        EstudianteEntity estudianteT = data.get(0);
        estudianteT.setFacturas(generarFacturas());
        Assert.assertNotNull(estudianteT.getFacturas());
        Assert.assertTrue(estudianteT.getFacturas().size() == 3);
        Assert.assertTrue(estudianteT.getFacturas().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(estudianteT.getFacturas().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(estudianteT.getFacturas().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of equals method, of class EstudianteEntity.
     */
    @Test
    public void testEquals() {
        EstudianteEntity entidadT = data.get(0);
        Assert.assertTrue(entidadT.equals(data.get(0)));
        Assert.assertFalse(entidadT.equals(new ServiciosEntity()));
    }

    /**
     * Test of hashCode method, of class EstudianteEntity.
     */
    @Test
    public void testHashCode() {
        EstudianteEntity entidadT = data.get(0);
        entidadT.setId(new Long(3));
        Assert.assertEquals(data.get(0).hashCode(), entidadT.hashCode());
    }
    
}
