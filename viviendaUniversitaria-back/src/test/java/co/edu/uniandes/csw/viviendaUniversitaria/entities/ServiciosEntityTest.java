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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author jc.sanguino10
 */
public class ServiciosEntityTest {
    private List<ServiciosEntity> data = new ArrayList<>();
    
    public ServiciosEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 2; i++) {
           ServiciosEntity entity = factory.manufacturePojo(ServiciosEntity.class);
            HospedajeEntity hospedaje = factory.manufacturePojo(HospedajeEntity.class);
            ArrayList<DetalleServicioEntity> muestraDetalleServico = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                DetalleServicioEntity detalleSer = factory.manufacturePojo(DetalleServicioEntity.class);
                muestraDetalleServico.add(detalleSer);                       
            }
            entity.setDetalleServicio(muestraDetalleServico);
            entity.setHospedaje(hospedaje);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDetalleServicio method, of class ServiciosEntity.
     */
    @Test
    public void testGetDetalleServicio() {
        ServiciosEntity muestra = data.get(0);
        muestra.setDetalleServicio(data.get(1).getDetalleServicio());
        assertEquals(muestra.getDetalleServicio().size(), data.get(1).getDetalleServicio().size());
    }

    /**
     * Test of setDetalleServicio method, of class ServiciosEntity.
     */
    @Test
    public void testSetDetalleServicio() {
        ServiciosEntity muestra = data.get(0);
        muestra.setDetalleServicio(data.get(1).getDetalleServicio());
        assertEquals(muestra.getDetalleServicio().size(), data.get(1).getDetalleServicio().size());
    }

    /**
     * Test of getHospedaje method, of class ServiciosEntity.
     */
    @Test
    public void testGetHospedaje() {
        ServiciosEntity muestra = data.get(0);
        muestra.setHospedaje(data.get(1).getHospedaje());
        assertEquals(muestra.getHospedaje().getId(), data.get(1).getHospedaje().getId());
    }

    /**
     * Test of setHospedaje method, of class ServiciosEntity.
     */
    @Test
    public void testSetHospedaje() {
        ServiciosEntity muestra = data.get(0);
        muestra.setHospedaje(data.get(1).getHospedaje());
        assertEquals(muestra.getHospedaje().getId(), data.get(1).getHospedaje().getId());
    }

    /**
     * Test of getDescripcion method, of class ServiciosEntity.
     */
    @Test
    public void testGetDescripcion() {
        ServiciosEntity muestra = data.get(0);
        muestra.setDescripcion(data.get(1).getDescripcion());
        assertEquals(muestra.getDescripcion(), data.get(1).getDescripcion());
    }

    /**
     * Test of setDescripcion method, of class ServiciosEntity.
     */
    @Test
    public void testSetDescripcion() {
        ServiciosEntity muestra = data.get(0);
        muestra.setDescripcion(data.get(1).getDescripcion());
        assertEquals(muestra.getDescripcion(), data.get(1).getDescripcion());
    }

    /**
     * Test of getCosto method, of class ServiciosEntity.
     */
    @Test
    public void testGetCosto() {
        ServiciosEntity muestra = data.get(0);
        muestra.setCosto(10000);
        assertTrue((muestra.getCosto()-10000)==0 );
    }

    /**
     * Test of setCosto method, of class ServiciosEntity.
     */
    @Test
    public void testSetCosto() {
        ServiciosEntity muestra = data.get(0);
        muestra.setCosto(10000);
        assertTrue((muestra.getCosto()-10000)==0 );
    }
    
}
