/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
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
 * @author c.santacruza
 */
@RunWith(Arquillian.class)
public class UbicacionPersistenceTest {

    @Inject
    private UbicacionPersistence persistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<UbicacionEntity> data = new ArrayList<UbicacionEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UbicacionEntity.class.getPackage())
                .addPackage(UbicacionPersistence.class.getPackage())
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
        em.createQuery("delete from EstudianteEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            UbicacionEntity entity = factory.manufacturePojo(UbicacionEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    public UbicacionPersistenceTest() {

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
     * Test of create method, of class UbicacionPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        UbicacionEntity newEntity = factory.manufacturePojo(UbicacionEntity.class);
        UbicacionEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        UbicacionEntity entity = em.find(UbicacionEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of update method, of class UbicacionPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        UbicacionEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        UbicacionEntity newEntity = factory.manufacturePojo(UbicacionEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        UbicacionEntity resp = em.find(UbicacionEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * Test of delete method, of class UbicacionPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        UbicacionEntity entity = data.get(0);
        persistence.delete(entity.getId());
        UbicacionEntity deleted = em.find(UbicacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class UbicacionPersistence.
     */
    @Test
    public void testFind() throws Exception {
        UbicacionEntity entity = data.get(0);
        UbicacionEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of findAll method, of class UbicacionPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<UbicacionEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (UbicacionEntity ent : list) {
            boolean found = false;
            for (UbicacionEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
