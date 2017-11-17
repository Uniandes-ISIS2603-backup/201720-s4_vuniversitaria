/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.UbicacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.UniversidadEntity;
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
public class UniversidadPersistenceTest {

    @Inject
    private UniversidadPersistence persistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<UniversidadEntity> data = new ArrayList<UniversidadEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(UniversidadEntity.class.getPackage())
                .addPackage(UniversidadPersistence.class.getPackage())
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
        em.createQuery("delete from UniversidadEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            UniversidadEntity entity = factory.manufacturePojo(UniversidadEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    public UniversidadPersistenceTest() {

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
        UniversidadEntity newEntity = factory.manufacturePojo(UniversidadEntity.class);
        UniversidadEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        UniversidadEntity entity = em.find(UniversidadEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getImagen(), entity.getImagen());
    }

    /**
     * Test of update method, of class UbicacionPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        UniversidadEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        UniversidadEntity newEntity = factory.manufacturePojo(UniversidadEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        UniversidadEntity resp = em.find(UniversidadEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getImagen(), resp.getImagen());
    }

    /**
     * Test of delete method, of class UbicacionPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        UniversidadEntity entity = data.get(0);
        persistence.delete(entity.getId());
        UniversidadEntity deleted = em.find(UniversidadEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class UbicacionPersistence.
     */
    @Test
    public void testFind() throws Exception {
        UniversidadEntity entity = data.get(0);
        UniversidadEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        Assert.assertEquals(entity.getImagen(), newEntity.getImagen());
    }

    /**
     * Test of findAll method, of class UbicacionPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<UniversidadEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (UniversidadEntity ent : list) {
            boolean found = false;
            for (UniversidadEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
