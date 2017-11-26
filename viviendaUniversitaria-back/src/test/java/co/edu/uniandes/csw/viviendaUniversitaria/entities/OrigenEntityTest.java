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
public class OrigenEntityTest {
    private List<OrigenEntity> data = new ArrayList<>();
    
    public OrigenEntityTest() {
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
            OrigenEntity entity = factory.manufacturePojo(OrigenEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class OrigenEntity.
     */
    @Test
    public void testGetName() {
        OrigenEntity entidadT = data.get(0);
        OrigenEntity entidad = new OrigenEntity();
        entidad.setName(entidadT.getName());
        Assert.assertTrue(entidad.getName().equals(entidadT.getName()));
    }

    /**
     * Test of setName method, of class OrigenEntity.
     */
    @Test
    public void testSetName() {
        OrigenEntity entidadT = data.get(0);
        OrigenEntity entidad = new OrigenEntity();
        entidad.setName(entidadT.getName());
        Assert.assertTrue(entidad.getName().equals(entidadT.getName()));
    }

    /**
     * Test of getEstudiantes method, of class OrigenEntity.
     */
    @Test
    public void testGetEstudiantes() {
        OrigenEntity origen = data.get(0);
        origen.setEstudiante(generarEstudiantes());
        Assert.assertNotNull(origen.getEstudiantes());
        Assert.assertTrue(origen.getEstudiantes().size() == 3);
        Assert.assertTrue(origen.getEstudiantes().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(origen.getEstudiantes().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(origen.getEstudiantes().get(2).getId().equals(new Long(3)));
    }

    private List<EstudianteEntity> generarEstudiantes()
    {
        List<EstudianteEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            EstudianteEntity add = new EstudianteEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }
    
    /**
     * Test of setEstudiante method, of class OrigenEntity.
     */
    @Test
    public void testSetEstudiante() {
        OrigenEntity origen = data.get(0);
        origen.setEstudiante(generarEstudiantes());
        Assert.assertNotNull(origen.getEstudiantes());
        Assert.assertTrue(origen.getEstudiantes().size() == 3);
        Assert.assertTrue(origen.getEstudiantes().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(origen.getEstudiantes().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(origen.getEstudiantes().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of equals method, of class OrigenEntity.
     */
    @Test
    public void testEquals() {
        OrigenEntity origen=   data.get(0);
        Assert.assertTrue(origen.equals(data.get(0)));
        Assert.assertFalse(origen.equals(new ServiciosEntity()));
    }

    /**
     * Test of hashCode method, of class OrigenEntity.
     */
    @Test
    public void testHashCode() {
        OrigenEntity origen = data.get(0);
        origen.setId(new Long(3));
        Assert.assertEquals(data.get(0).hashCode(), origen.hashCode());
    }
    
}
