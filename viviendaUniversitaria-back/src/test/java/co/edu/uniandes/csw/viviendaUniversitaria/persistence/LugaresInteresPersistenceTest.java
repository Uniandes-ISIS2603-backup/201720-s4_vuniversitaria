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
 * @author Juan Camilo Sanguino
 */
@RunWith(Arquillian.class)
public class LugaresInteresPersistenceTest {

    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private LugaresInteresPersistence persistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     *
     */
    private List<LugaresInteresEntity> data = new ArrayList<LugaresInteresEntity>();

    public LugaresInteresPersistenceTest() {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(LugaresInteresEntity.class.getPackage())
                .addPackage(LugaresInteresPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
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
        em.createQuery("delete from LugaresInteresEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            LugaresInteresEntity entity = factory.manufacturePojo(LugaresInteresEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findId method, of class LugaresInteresPersistence.
     */
    @org.junit.Test
    public void testFindId() throws Exception {
        LugaresInteresEntity entity = data.get(0);
        LugaresInteresEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of create method, of class LugaresInteresPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        LugaresInteresEntity newEntity = factory.manufacturePojo(LugaresInteresEntity.class);
        LugaresInteresEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        LugaresInteresEntity entity = em.find(LugaresInteresEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of update method, of class LugaresInteresPersistence.
     */
    @org.junit.Test
    public void testUpdate() throws Exception {
        LugaresInteresEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        LugaresInteresEntity newEntity = factory.manufacturePojo(LugaresInteresEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        LugaresInteresEntity resp = em.find(LugaresInteresEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * Test of delete method, of class LugaresInteresPersistence.
     */
    @org.junit.Test
    public void testDelete() throws Exception {
        LugaresInteresEntity entity = data.get(0);
        persistence.delete(entity.getId());
        LugaresInteresEntity deleted = em.find(LugaresInteresEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
