/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReservaEntity;
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
 * @author je.bejarano10
 */
@RunWith(Arquillian.class)
public class ReservaPersistenceTest {
    
    @Inject
    private ReservaPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<ReservaEntity> data = new ArrayList<ReservaEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReservaEntity.class.getPackage())
                .addPackage(ReservaPersistence.class.getPackage())
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
        em.createQuery("delete from ReservaEntity").executeUpdate();
    }


 private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {                    
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    public ReservaPersistenceTest() {
        
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
     * Test of create method, of class ReservaPersistence.
     */
    @Test
    public void testCreate() throws Exception {
PodamFactory factory = new PodamFactoryImpl();
    ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);
    ReservaEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    ReservaEntity entity = em.find(ReservaEntity.class, result.getId());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of update method, of class ReservaPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ReservaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        ReservaEntity resp = em.find(ReservaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of delete method, of class ReservaPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        ReservaEntity entity = data.get(0);
        persistence.delete(entity.getId());
        ReservaEntity deleted = em.find(ReservaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class ReservaPersistence.
     */
    @Test
    public void testFind() throws Exception {
        ReservaEntity entity = data.get(0);
        ReservaEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of findAll method, of class ReservaPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<ReservaEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ReservaEntity ent : list) {
            boolean found = false;
            for (ReservaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
