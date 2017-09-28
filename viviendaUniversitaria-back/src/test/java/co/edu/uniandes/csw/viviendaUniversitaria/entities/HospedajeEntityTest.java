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
public class HospedajeEntityTest {
    
    @Inject
    UserTransaction utx;
    private List<HospedajeEntity> data = new ArrayList<HospedajeEntity>();
    
    public HospedajeEntityTest() {
    }
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HospedajeEntity.class.getPackage())
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
        data = new ArrayList<HospedajeEntity>();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            HospedajeEntity entity = factory.manufacturePojo(HospedajeEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class HospedajeEntity.
     */
    @Test
    public void testGetId() {
        HospedajeEntity hospedajeT = data.get(0);
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(hospedajeT.getId());
        Assert.assertTrue(hospedaje.getId().equals(hospedajeT.getId()));
    }

    /**
     * Test of setId method, of class HospedajeEntity.
     */
    @Test
    public void testSetId() {
        HospedajeEntity hospedajeT = data.get(0);
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setId(hospedajeT.getId());
        Assert.assertTrue(hospedaje.getId().equals(hospedajeT.getId()));
    }

    /**
     * Test of getTipoArrendamiento method, of class HospedajeEntity.
     */
    @Test
    public void testGetTipoArrendamiento() {
        HospedajeEntity hospedajeT = data.get(0);
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setTipoArrendamiento(hospedajeT.getTipoArrendamiento());
        Assert.assertTrue(hospedaje.getTipoArrendamiento().equals(hospedajeT.getTipoArrendamiento()));
    }

    /**
     * Test of setTipoArrendamiento method, of class HospedajeEntity.
     */
    @Test
    public void testSetTipoArrendamiento() {
        HospedajeEntity hospedajeT = data.get(0);
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setTipoArrendamiento(hospedajeT.getTipoArrendamiento());
        Assert.assertTrue(hospedaje.getTipoArrendamiento().equals(hospedajeT.getTipoArrendamiento()));
    }

    /**
     * Test of getDescripcion method, of class HospedajeEntity.
     */
    @Test
    public void testGetDescripcion() {
        HospedajeEntity hospedajeT = data.get(0);
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setDescripcion(hospedajeT.getDescripcion());
        Assert.assertTrue(hospedaje.getDescripcion().equals(hospedajeT.getDescripcion()));
    }

    /**
     * Test of setDescripcion method, of class HospedajeEntity.
     */
    @Test
    public void testSetDescripcion() {
        HospedajeEntity hospedajeT = data.get(0);
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setDescripcion(hospedajeT.getDescripcion());
        Assert.assertTrue(hospedaje.getDescripcion().equals(hospedajeT.getDescripcion()));
    }

    /**
     * Test of getValoracion method, of class HospedajeEntity.
     */
    @Test
    public void testGetValoracion() {
        HospedajeEntity hospedajeT = data.get(0);
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setValoracion(hospedajeT.getValoracion());
        Assert.assertTrue(hospedaje.getValoracion() == (hospedajeT.getValoracion()));
    }

    /**
     * Test of setValoracion method, of class HospedajeEntity.
     */
    @Test
    public void testSetValoracion() {
        HospedajeEntity hospedajeT = data.get(0);
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setValoracion(hospedajeT.getValoracion());
        Assert.assertTrue(hospedaje.getValoracion() == (hospedajeT.getValoracion()));
    }

    /**
     * Test of getReglas method, of class HospedajeEntity.
     */
    @Test
    public void testGetReglas() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setReglas(generarReglas());
        Assert.assertNotNull(hospedajeT.getReglas());
        Assert.assertTrue(hospedajeT.getReglas().size() == 3);
        Assert.assertTrue(hospedajeT.getReglas().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getReglas().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getReglas().get(2).getId().equals(new Long(3)));
    }
    
    private List<ReglaEntity> generarReglas()
    {
        List<ReglaEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            ReglaEntity add = new ReglaEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setReglas method, of class HospedajeEntity.
     */
    @Test
    public void testSetReglas() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setReglas(generarReglas());
        Assert.assertNotNull(hospedajeT.getReglas());
        Assert.assertTrue(hospedajeT.getReglas().size() == 3);
        Assert.assertTrue(hospedajeT.getReglas().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getReglas().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getReglas().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of getServicios method, of class HospedajeEntity.
     */
    @Test
    public void testGetServicios() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setServicios(generarServicios());
        Assert.assertNotNull(hospedajeT.getServicios());
        Assert.assertTrue(hospedajeT.getServicios().size() == 3);
        Assert.assertTrue(hospedajeT.getServicios().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getServicios().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getServicios().get(2).getId().equals(new Long(3)));
    }
    
    private List<ServiciosEntity> generarServicios()
    {
        List<ServiciosEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            ServiciosEntity add = new ServiciosEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setServicios method, of class HospedajeEntity.
     */
    @Test
    public void testSetServicios() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setServicios(generarServicios());
        Assert.assertNotNull(hospedajeT.getServicios());
        Assert.assertTrue(hospedajeT.getServicios().size() == 3);
        Assert.assertTrue(hospedajeT.getServicios().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getServicios().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getServicios().get(2).getId().equals(new Long(3)));        
    }

    /**
     * Test of getHospedajesLugares method, of class HospedajeEntity.
     */
    @Test
    public void testGetHospedajesLugares() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setHospedajesLugares(generarHospedajeLigar());
        Assert.assertNotNull(hospedajeT.getHospedajesLugares());
        Assert.assertTrue(hospedajeT.getHospedajesLugares().size() == 3);
        Assert.assertTrue(hospedajeT.getHospedajesLugares().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getHospedajesLugares().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getHospedajesLugares().get(2).getId().equals(new Long(3))); 
    }
    
    private List<HospedajeLugarEntity> generarHospedajeLigar()
    {
        List<HospedajeLugarEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            HospedajeLugarEntity add = new HospedajeLugarEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setHospedajesLugares method, of class HospedajeEntity.
     */
    @Test
    public void testSetHospedajesLugares() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setHospedajesLugares(generarHospedajeLigar());
        Assert.assertNotNull(hospedajeT.getHospedajesLugares());
        Assert.assertTrue(hospedajeT.getHospedajesLugares().size() == 3);
        Assert.assertTrue(hospedajeT.getHospedajesLugares().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getHospedajesLugares().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getHospedajesLugares().get(2).getId().equals(new Long(3))); 
    }

    /**
     * Test of getReservas method, of class HospedajeEntity.
     */
    @Test
    public void testGetReservas() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setReservas(generarReservas());
        Assert.assertNotNull(hospedajeT.getReservas());
        Assert.assertTrue(hospedajeT.getReservas().size() == 3);
        Assert.assertTrue(hospedajeT.getReservas().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getReservas().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getReservas().get(2).getId().equals(new Long(3))); 
    }
    
    private List<ReservaEntity> generarReservas()
    {
        List<ReservaEntity> ret = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            ReservaEntity add = new ReservaEntity();
            add.setId(new Long(i));
            ret.add(add);
        }
        return ret;
    }

    /**
     * Test of setReservas method, of class HospedajeEntity.
     */
    @Test
    public void testSetReservas() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setReservas(generarReservas());
        Assert.assertNotNull(hospedajeT.getReservas());
        Assert.assertTrue(hospedajeT.getReservas().size() == 3);
        Assert.assertTrue(hospedajeT.getReservas().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getReservas().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getReservas().get(2).getId().equals(new Long(3))); 
    }

    /**
     * Test of getCalificaciones method, of class HospedajeEntity.
     */
    @Test
    public void testGetCalificaciones() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setCalificaciones(generarCalificaciones());
        Assert.assertNotNull(hospedajeT.getCalificaciones());
        Assert.assertTrue(hospedajeT.getCalificaciones().size() == 3);
        Assert.assertTrue(hospedajeT.getCalificaciones().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getCalificaciones().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getCalificaciones().get(2).getId().equals(new Long(3)));
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
     * Test of setCalificaciones method, of class HospedajeEntity.
     */
    @Test
    public void testSetCalificaciones() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setCalificaciones(generarCalificaciones());
        Assert.assertNotNull(hospedajeT.getCalificaciones());
        Assert.assertTrue(hospedajeT.getCalificaciones().size() == 3);
        Assert.assertTrue(hospedajeT.getCalificaciones().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getCalificaciones().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getCalificaciones().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of getArrendador method, of class HospedajeEntity.
     */
    @Test
    public void testGetArrendador() {
        ArrendadorEntity arrendador = new ArrendadorEntity();
        arrendador.setId(new Long(235411521));
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setArrendador(arrendador);
        Assert.assertTrue(hospedaje.getArrendador().getId().equals(arrendador.getId()));
    }

    /**
     * Test of setArrendador method, of class HospedajeEntity.
     */
    @Test
    public void testSetArrendador() {
        ArrendadorEntity arrendador = new ArrendadorEntity();
        arrendador.setId(new Long(23));
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setArrendador(arrendador);
        Assert.assertTrue(hospedaje.getArrendador().getId().equals(arrendador.getId()));
    }

    /**
     * Test of getUbicacion method, of class HospedajeEntity.
     */
    @Test
    public void testGetUbicacion() {
        UbicacionEntity ubicacion = new UbicacionEntity();
        ubicacion.setId(new Long(23));
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setUbicacion(ubicacion);
        Assert.assertTrue(hospedaje.getUbicacion().getId().equals(ubicacion.getId()));
    }

    /**
     * Test of setUbicacion method, of class HospedajeEntity.
     */
    @Test
    public void testSetUbicacion() {
        UbicacionEntity ubicacion = new UbicacionEntity();
        ubicacion.setId(new Long(23));
        HospedajeEntity hospedaje = new HospedajeEntity();
        hospedaje.setUbicacion(ubicacion);
        Assert.assertTrue(hospedaje.getUbicacion().getId().equals(ubicacion.getId()));
    }

    /**
     * Test of getFacturas method, of class HospedajeEntity.
     */
    @Test
    public void testGetFacturas() {
         HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setFacturas(generarFacturas());
        Assert.assertNotNull(hospedajeT.getFacturas());
        Assert.assertTrue(hospedajeT.getFacturas().size() == 3);
        Assert.assertTrue(hospedajeT.getFacturas().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getFacturas().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getFacturas().get(2).getId().equals(new Long(3)));
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
     * Test of setFacturas method, of class HospedajeEntity.
     */
    @Test
    public void testSetFacturas() {
        HospedajeEntity hospedajeT = data.get(0);
        hospedajeT.setFacturas(generarFacturas());
        Assert.assertNotNull(hospedajeT.getFacturas());
        Assert.assertTrue(hospedajeT.getFacturas().size() == 3);
        Assert.assertTrue(hospedajeT.getFacturas().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(hospedajeT.getFacturas().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(hospedajeT.getFacturas().get(2).getId().equals(new Long(3)));
    }

    /**
     * Test of equals method, of class HospedajeEntity.
     */
    @Test
    public void testEquals() {
        HospedajeEntity hospedajeT=  data.get(0);
        Assert.assertTrue(hospedajeT.equals(data.get(0)));
    }

    /**
     * Test of hashCode method, of class HospedajeEntity.
     */
    @Test
    public void testHashCode() {
        HospedajeEntity hospedajeT = data.get(0);
        Long id = new Long(3);
        hospedajeT.setId(new Long(3));
        Assert.assertEquals(id, new Long(hospedajeT.hashCode()));
    }
    
}
