/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.CalificacionPersistence;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author kk.penaranda
 */
@RunWith(Arquillian.class)
public class CalificacionPersistenceTest {
    
    @Inject
    private CalificacionPersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<CalificacionEntity> data = new ArrayList<CalificacionEntity>();
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    public CalificacionPersistenceTest() {
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
            CalificacionEntity entity = factory.manufacturePojo(CalificacionEntity.class);

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
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);

        CalificacionEntity entity = em.find(CalificacionEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
        Assert.assertEquals(newEntity.getValoracion(), entity.getValoracion(), 0.02);
    }

    /**
     * Test of update method, of class ArrendadorPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        CalificacionEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        CalificacionEntity resp = em.find(CalificacionEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getComentario(), resp.getComentario());
        Assert.assertEquals(newEntity.getValoracion(), resp.getValoracion(), 0.02);
    }

    /**
     * Test of delete method, of class ArrendadorPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        CalificacionEntity entity = data.get(0);
        persistence.delete(entity.getId());
        CalificacionEntity deleted = em.find(CalificacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class ArrendadorPersistence.
     */
    @Test
    public void testFind() throws Exception {
        CalificacionEntity entity = data.get(0);
        CalificacionEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getValoracion(), entity.getValoracion(), 0.02);
    }

    /**
     * Test of findAll method, of class ArrendadorPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<CalificacionEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CalificacionEntity ent : list) {
            boolean found = false;
            for (CalificacionEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
}