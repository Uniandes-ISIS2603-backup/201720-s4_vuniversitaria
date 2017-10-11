/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
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
 * @author a.eslava
 */
@RunWith(Arquillian.class)
public class OrigenPersistenceTest {

    @Inject
    private OrigenPersistence persistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<OrigenEntity> data = new ArrayList<OrigenEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(OrigenEntity.class.getPackage())
                .addPackage(OrigenPersistence.class.getPackage())
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
        em.createQuery("delete from OrigenEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            OrigenEntity entity = factory.manufacturePojo(OrigenEntity.class);
            System.out.println(i);
            em.persist(entity);
            data.add(entity);
        }
    }

    public OrigenPersistenceTest() {

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
     * Test of create method, of class OrigenPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        OrigenEntity newEntity = factory.manufacturePojo(OrigenEntity.class);
        OrigenEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        OrigenEntity entity = em.find(OrigenEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Test of update method, of class OrigenPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        OrigenEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        OrigenEntity newEntity = factory.manufacturePojo(OrigenEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        OrigenEntity resp = em.find(OrigenEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of delete method, of class OrigenPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        OrigenEntity entity = data.get(0);
        persistence.delete(entity.getId());
        OrigenEntity deleted = em.find(OrigenEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class OrigenPersistence.
     */
    @Test
    public void testFind() throws Exception {
        OrigenEntity entity = data.get(0);
        OrigenEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of findAll method, of class OrigenPersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<OrigenEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (OrigenEntity ent : list) {
            boolean found = false;
            for (OrigenEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void entitiesTest() {
        PodamFactory factory = new PodamFactoryImpl();
        OrigenEntity newEntity = factory.manufacturePojo(OrigenEntity.class);
        List<EstudianteEntity> estudiantes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            estudiantes.add(factory.manufacturePojo(EstudianteEntity.class));
        }
        newEntity.setEstudiante(estudiantes);
        assertEquals(newEntity.getEstudiante(), estudiantes);
    }
}
