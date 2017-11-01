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
public class HospedajePersistenceTest {

    public HospedajePersistenceTest() {
    }

    @Inject
    private HospedajePersistence persistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<HospedajeEntity> data = new ArrayList<HospedajeEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HospedajeEntity.class.getPackage())
                .addPackage(HospedajePersistence.class.getPackage())
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
        em.createQuery("delete from HospedajeEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            HospedajeEntity entity = factory.manufacturePojo(HospedajeEntity.class);

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
     * Test of create method, of class HospedajePersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        HospedajeEntity newEntity = factory.manufacturePojo(HospedajeEntity.class);
        HospedajeEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        HospedajeEntity entity = em.find(HospedajeEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
    }

    /**
     * Test of update method, of class HospedajePersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        HospedajeEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        HospedajeEntity newEntity = factory.manufacturePojo(HospedajeEntity.class);
        newEntity.setId(entity.getId());
        persistence.update(newEntity);
        HospedajeEntity resp = em.find(HospedajeEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion());
    }

    /**
     * Test of delete method, of class HospedajePersistence.
     */
    @Test
    public void testDelete() throws Exception {
        HospedajeEntity entity = data.get(0);
        persistence.delete(entity.getId());
        HospedajeEntity deleted = em.find(HospedajeEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of findId method, of class HospedajePersistence.
     */
    @Test
    public void testFindId() throws Exception {
        HospedajeEntity entity = data.get(0);
        HospedajeEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getDescripcion(), newEntity.getDescripcion());
    }

    /**
     * Test of findAll method, of class HospedajePersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<HospedajeEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (HospedajeEntity ent : list) {
            boolean found = false;
            for (HospedajeEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
