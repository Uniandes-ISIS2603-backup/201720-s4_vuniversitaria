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
public class HospedajeLugarPersistenceTest {
    
    public HospedajeLugarPersistenceTest() {
    }
    
    @Inject
    private HospedajeLugarPersistence persistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<HospedajeLugarEntity> data = new ArrayList<HospedajeLugarEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HospedajeLugarEntity.class.getPackage())
                .addPackage(HospedajeLugarPersistence.class.getPackage())
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
        em.createQuery("delete from HospedajeLugarEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            HospedajeLugarEntity entity = factory.manufacturePojo(HospedajeLugarEntity.class);

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
    
    @Test
    public void testCreate() throws Exception {
PodamFactory factory = new PodamFactoryImpl();
    HospedajeLugarEntity newEntity = factory.manufacturePojo(HospedajeLugarEntity.class);
    HospedajeLugarEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    HospedajeLugarEntity entity = em.find(HospedajeLugarEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of create method, of class HospedajeLugarPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        HospedajeLugarEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        HospedajeLugarEntity newEntity = factory.manufacturePojo(HospedajeLugarEntity.class);
        newEntity.setId(entity.getId());
        persistence.update(newEntity);
        HospedajeLugarEntity resp = em.find(HospedajeLugarEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getDistancia(), resp.getDistancia());
    }

    /**
     * Test of delete method, of class HospedajeLugarPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        HospedajeLugarEntity entity = data.get(0);
        persistence.delete(entity.getId());
        HospedajeLugarEntity deleted = em.find(HospedajeLugarEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of findId method, of class HospedajeLugarPersistence.
     */
    @Test
    public void testFindId() throws Exception {
        HospedajeLugarEntity entity = data.get(0);
        HospedajeLugarEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getDistancia(), newEntity.getDistancia());
    }

    /**
     * Test of findAll method, of class HospedajeLugarPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<HospedajeLugarEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (HospedajeLugarEntity ent : list) {
            boolean found = false;
            for (HospedajeLugarEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
}
