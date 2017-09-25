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
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
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
 * @author kk.penaranda
 */
public class ArrendadorEntityTest {
    /**
     * Constructor por defecto
     */
    public ArrendadorEntityTest(){
        
    }
    
    @Inject
    UserTransaction utx;
    private List<ArrendadorEntity> data = new ArrayList<ArrendadorEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArrendadorEntity.class.getPackage())
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
        data = new ArrayList<ArrendadorEntity>();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ArrendadorEntity entity = factory.manufacturePojo(ArrendadorEntity.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetIdArrendador() {
        ArrendadorEntity arrendador = data.get(0);
        ArrendadorEntity nuevoArrendador = new ArrendadorEntity();
        nuevoArrendador.setId(arrendador.getId());
        Assert.assertTrue(nuevoArrendador.getId().equals(arrendador.getId()));
    }

    @Test
    public void testSetIdArrendador() {
        ArrendadorEntity entityArrendador = data.get(0);
        ArrendadorEntity arrendador = new ArrendadorEntity();
        arrendador.setId(entityArrendador.getId());
        Assert.assertTrue(arrendador.getId().equals(entityArrendador.getId()));
    }

    @Test
    public void testGetNombreArrendador() {
        ArrendadorEntity arrendador = data.get(0);
        ArrendadorEntity nuevo = new ArrendadorEntity();
        nuevo.setNombre(arrendador.getNombre());
        Assert.assertTrue(nuevo.getNombre().equals(arrendador.getNombre()));
    }

    @Test
    public void testSetNombre() {
        ArrendadorEntity arrendador = data.get(0);
        ArrendadorEntity nuevo = new ArrendadorEntity();
        nuevo.setNombre(arrendador.getNombre());
        Assert.assertTrue(nuevo.getNombre().equals(arrendador.getNombre()));
    }
    
    @Test
    public void testGetHospedaje() {
        ArrendadorEntity arrendador = data.get(0);
        arrendador.setHospedajes(generarHospedaje());
        Assert.assertNotNull(arrendador.getHospedajes());
        Assert.assertTrue(arrendador.getHospedajes().size() == 3);
        Assert.assertTrue(arrendador.getHospedajes().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(arrendador.getHospedajes().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(arrendador.getHospedajes().get(2).getId().equals(new Long(3)));

    }
    
    private List<HospedajeEntity> generarHospedaje()
    {
        List<HospedajeEntity> hospedajes = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            HospedajeEntity add = new HospedajeEntity();
            add.setId(new Long(i));
            hospedajes.add(add);
        }
        return hospedajes;
    }

    @Test
    public void testSetHospedajes() {
        ArrendadorEntity arrendador = data.get(0);
        arrendador.setHospedajes(generarHospedaje());
        Assert.assertNotNull(arrendador.getHospedajes());
        Assert.assertTrue(arrendador.getHospedajes().size() == 2);
        Assert.assertTrue(arrendador.getHospedajes().get(0).getId().equals(new Long(1)));
        Assert.assertTrue(arrendador.getHospedajes().get(1).getId().equals(new Long(2)));
        Assert.assertTrue(arrendador.getHospedajes().get(2).getId().equals(new Long(3)));

    }

}
