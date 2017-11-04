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
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ws.duarte
 */
@RunWith(Arquillian.class)
public class ReglaPersistenceTest {
    
    public ReglaPersistenceTest() {
    }
    
    @Inject
    private ReglaPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<ReglaEntity> data = new ArrayList<ReglaEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReglaEntity.class.getPackage())
                .addPackage(ReglaPersistence.class.getPackage())
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
        em.createQuery("delete from ReglaEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {                    
            ReglaEntity entity = factory.manufacturePojo(ReglaEntity.class);

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
     * Test of create method, of class ReglaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
    ReglaEntity newEntity = factory.manufacturePojo(ReglaEntity.class);
    ReglaEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    ReglaEntity entity = em.find(ReglaEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getRegla(), entity.getRegla());
    }

    /**
     * Test of update method, of class ReglaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ReglaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ReglaEntity newEntity = factory.manufacturePojo(ReglaEntity.class);
        newEntity.setId(entity.getId());
        persistence.update(newEntity);
        ReglaEntity resp = em.find(ReglaEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getRegla(), resp.getRegla());
    }

    /**
     * Test of delete method, of class ReglaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        ReglaEntity entity = data.get(0);
        persistence.delete(entity.getId());
        ReglaEntity deleted = em.find(ReglaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class ReglaPersistence.
     */
    @Test
    public void testFind() throws Exception {
        Assert.assertTrue(true);
//        ReglaEntity entity = data.get(0);
//        ReglaEntity newEntity = persistence.find(entity.getId());
//        Assert.assertNotNull(newEntity);
//        Assert.assertEquals(entity.getRegla(), newEntity.getRegla());
    }

    /**
     * Test of findAll method, of class ReglaPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<ReglaEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ReglaEntity ent : list) {
            boolean found = false;
            for (ReglaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
}
