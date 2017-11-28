/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author ws.duarte
 */
@RunWith(Arquillian.class)
public class DetalleServicioPersistenceTest {
    
    public DetalleServicioPersistenceTest() {
    }
    
    @Inject
    private DetalleServicioPersistence persistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<DetalleServicioEntity> data = new ArrayList<DetalleServicioEntity>();

    @Deployment
    public static JavaArchive createDeployment() { 
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DetalleServicioEntity.class.getPackage())
                .addPackage(DetalleServicioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
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
        em.createQuery("delete from DetalleServicioEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DetalleServicioEntity entity = factory.manufacturePojo(DetalleServicioEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class DetalleServicioPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        DetalleServicioEntity newEntity = factory.manufacturePojo(DetalleServicioEntity.class);
        DetalleServicioEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        DetalleServicioEntity entity = em.find(DetalleServicioEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getSubTotal(), entity.getSubTotal());
    }

    /**
     * Test of update method, of class DetalleServicioPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        DetalleServicioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        DetalleServicioEntity newEntity = factory.manufacturePojo(DetalleServicioEntity.class);
        newEntity.setId(entity.getId());
        persistence.update(newEntity);
        DetalleServicioEntity resp = em.find(DetalleServicioEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getSubTotal(), resp.getSubTotal());
    }

    /**
     * Test of delete method, of class DetalleServicioPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        DetalleServicioEntity entity = data.get(0);
        persistence.delete(entity.getId());
        DetalleServicioEntity deleted = em.find(DetalleServicioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class DetalleServicioPersistence.
     */
    @Test
    public void testFind() throws Exception {
        DetalleServicioEntity entity = data.get(0);
        DetalleServicioEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getSubTotal(), entity.getSubTotal());
    }

    /**
     * Test of findAll method, of class DetalleServicioPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<DetalleServicioEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (DetalleServicioEntity ent : list) {
            boolean found = false;
            for (DetalleServicioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
}
