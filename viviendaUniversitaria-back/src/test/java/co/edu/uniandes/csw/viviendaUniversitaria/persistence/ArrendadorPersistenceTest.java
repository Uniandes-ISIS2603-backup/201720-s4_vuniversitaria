/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ArrendadorEntity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author kk.penaranda
 */
@RunWith(Arquillian.class)
public class ArrendadorPersistenceTest {
    
    @Inject
    private ArrendadorPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<ArrendadorEntity> data = new ArrayList<ArrendadorEntity>();
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ArrendadorEntity.class.getPackage())
                .addPackage(ArrendadorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public ArrendadorPersistenceTest() {
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
        em.createQuery("delete from ArrendadorEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ArrendadorEntity entity = factory.manufacturePojo(ArrendadorEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
 
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ArrendadorPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        ArrendadorEntity newEntity = factory.manufacturePojo(ArrendadorEntity.class);
        ArrendadorEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);

        ArrendadorEntity entity = em.find(ArrendadorEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    /**
     * Test of update method, of class ArrendadorPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ArrendadorEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ArrendadorEntity newEntity = factory.manufacturePojo(ArrendadorEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        ArrendadorEntity resp = em.find(ArrendadorEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }

    /**
     * Test of delete method, of class ArrendadorPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        ArrendadorEntity entity = data.get(0);
        persistence.delete(entity.getId());
        ArrendadorEntity deleted = em.find(ArrendadorEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class ArrendadorPersistence.
     */
    @Test
    public void testFind() throws Exception {
        ArrendadorEntity entity = data.get(0);
        ArrendadorEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of findAll method, of class ArrendadorPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<ArrendadorEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ArrendadorEntity ent : list) {
            boolean found = false;
            for (ArrendadorEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
}