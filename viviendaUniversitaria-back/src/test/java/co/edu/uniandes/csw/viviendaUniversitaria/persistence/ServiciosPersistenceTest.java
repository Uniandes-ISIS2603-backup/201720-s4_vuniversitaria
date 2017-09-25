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
public class ServiciosPersistenceTest {

    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private ServiciosPersistence persistence;

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
    private List<ServiciosEntity> data = new ArrayList<ServiciosEntity>();

    public ServiciosPersistenceTest() {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ServiciosEntity.class.getPackage())
                .addPackage(ServiciosPersistence.class.getPackage())
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
        em.createQuery("delete from ServiciosEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ServiciosEntity entity = factory.manufacturePojo(ServiciosEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findId method, of class ServiciosPersistence.
     */
    @Test
    public void testFindId() throws Exception {
        ServiciosEntity entity = data.get(0);
        ServiciosEntity newEntity = persistence.findId(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Test of create method, of class ServiciosPersistence.
     */
    @Test
    public void testCreate() throws Exception {
        PodamFactory factory = new PodamFactoryImpl();
        ServiciosEntity newEntity = factory.manufacturePojo(ServiciosEntity.class);
        ServiciosEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        ServiciosEntity entity = em.find(ServiciosEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Test of update method, of class ServiciosPersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        ServiciosEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ServiciosEntity newEntity = factory.manufacturePojo(ServiciosEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        ServiciosEntity resp = em.find(ServiciosEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }

    /**
     * Test of delete method, of class ServiciosPersistence.
     */
    @Test
    public void testDelete() throws Exception {
        ServiciosEntity entity = data.get(0);
        persistence.delete(entity.getId());
        ServiciosEntity deleted = em.find(ServiciosEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
