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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author kk.penaranda
 */
@RunWith(Arquillian.class)
public class CalificacionEntityTest {
    
    /**
     * Constructor por defecto
     */
    public CalificacionEntityTest(){
        
    }
    
    @Inject
    UserTransaction utx;
    private List<CalificacionEntity> data = new ArrayList<CalificacionEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
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
        data = new ArrayList<CalificacionEntity>();
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

    @Test
    public void testGetIdCalificacion() {
        CalificacionEntity calificacion = data.get(0);
        CalificacionEntity nueva = new CalificacionEntity();
        nueva.setId(calificacion.getId());
        Assert.assertTrue(nueva.getId().equals(calificacion.getId()));
    }

    
    @Test
    public void testSetIdCalificacion() {
        CalificacionEntity entity = data.get(0);
        CalificacionEntity nueva = new CalificacionEntity();
        nueva.setId(entity.getId());
        Assert.assertTrue(nueva.getId().equals(entity.getId()));
    }

    @Test
    public void testGetValoracion() {
        CalificacionEntity calificacion = data.get(0);
        CalificacionEntity nuevo = new CalificacionEntity();
        nuevo.setValoracion(calificacion.getValoracion());
        Assert.assertTrue(nuevo.getValoracion()==(calificacion.getValoracion()));
    }

    @Test
    public void testSetValoracion() {
        CalificacionEntity calificacion = data.get(0);
        CalificacionEntity nuevo = new CalificacionEntity();
        nuevo.setValoracion(calificacion.getValoracion());
        Assert.assertTrue(nuevo.getValoracion()==(calificacion.getValoracion()));
    }
    
     @Test
    public void testGetComentario() {
        CalificacionEntity calificacion = data.get(0);
        CalificacionEntity nuevo = new CalificacionEntity();
        nuevo.setComentario(calificacion.getComentario());
        Assert.assertTrue(nuevo.getComentario().equals(calificacion.getComentario()));
    }

    @Test
    public void testSetComentario() {
        CalificacionEntity calificacion = data.get(0);
        CalificacionEntity nuevo = new CalificacionEntity();
        nuevo.setComentario(calificacion.getComentario());
        Assert.assertTrue(nuevo.getComentario().equals(calificacion.getComentario()));
    }
    
     @Test
    public void testGetFecha() {
        CalificacionEntity calificacion = data.get(0);
        CalificacionEntity nuevo = new CalificacionEntity();
        nuevo.setFecha(calificacion.getFecha());
        Assert.assertTrue(nuevo.getFecha().equals(calificacion.getFecha()));
    }

    @Test
    public void testSetFecha() {
        CalificacionEntity calificacion = data.get(0);
        CalificacionEntity nuevo = new CalificacionEntity();
        nuevo.setFecha(calificacion.getFecha());
        Assert.assertTrue(nuevo.getFecha().equals(calificacion.getFecha()));
    }
    
    @Test
    public void testGetHospedaje() {
        CalificacionEntity calificacion = data.get(0);
        calificacion.setHospedaje(generarHospedaje());
        Assert.assertNotNull(calificacion.getHospedaje());
        Assert.assertTrue(calificacion.getHospedaje().getId().equals(new Long(1)));

    }
    
    private HospedajeEntity generarHospedaje()
    {
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(Long.parseLong("1"));
        return hospedaje;
    }

    @Test
    public void testSetHospedaje() {
        CalificacionEntity calificacion = data.get(0);
        calificacion.setHospedaje(generarHospedaje());
        Assert.assertNotNull(calificacion.getHospedaje());
        Assert.assertTrue(calificacion.getHospedaje().getId().equals(new Long(1)));

    }
    
    @Test
    public void testGetEstudiante() {
        CalificacionEntity calificacion = data.get(0);
        calificacion.setEstudiante(generarEstudiante());
        Assert.assertNotNull(calificacion.getEstudiante());
        Assert.assertTrue(calificacion.getEstudiante().getCedula().equals(new Long(1)));

    }
    
    private EstudianteEntity generarEstudiante()
    {
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setCedula(Long.parseLong("1"));
        return estudiante;
    }

    /**
     * Test of setHospedajesLugares method, of class HospedajeEntity.
     */
    @Test
    public void testSetEstudiante() {
        CalificacionEntity calificacion = data.get(0);
        calificacion.setEstudiante(generarEstudiante());
        Assert.assertNotNull(calificacion.getEstudiante());
        Assert.assertTrue(calificacion.getEstudiante().getCedula().equals(new Long(1)));

    }
    
    
   
}
