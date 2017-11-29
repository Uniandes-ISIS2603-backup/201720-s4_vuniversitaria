///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.edu.uniandes.csw.viviendaUniversitaria.persistence;
//
//import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
//import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeLugarEntity;
//import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
//import java.util.ArrayList;
//import java.util.List;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.UserTransaction;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import uk.co.jemos.podam.api.PodamFactory;
//import uk.co.jemos.podam.api.PodamFactoryImpl;
//
///**
// *
// * @author jc.sanguino10
// */
//@RunWith(Arquillian.class)
//public class HospedajeLugarPersistenceTest {
//
//    @Inject
//    private HospedajeLugarPersistence persistence;
//    /**
//     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
//     * datos por fuera de los métodos que se están probando.
//     */
//    @PersistenceContext
//    private EntityManager em;
//
//    /**
//     * Variable para martcar las transacciones del em anterior cuando se
//     * crean/borran datos para las pruebas.
//     */
//    @Inject
//    UserTransaction utx;
//    /**
//     * atributo para guardar los datos de prueba
//     */
//    private List<HospedajeLugarEntity> data = new ArrayList<>();
//
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addPackage(HospedajeLugarEntity.class.getPackage())
//                .addPackage(HospedajeLugarPersistence.class.getPackage())
//                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
//                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
//    }
//
//    public HospedajeLugarPersistenceTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        try {
//            utx.begin();
//            em.joinTransaction();
//            clearData();
//            insertData();
//            utx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                utx.rollback();
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//        }
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of create method, of class HospedajeLugarPersistence.
//     */
//    @Test
//    public void testCreate() throws Exception {
//        PodamFactory factory = new PodamFactoryImpl();
//        HospedajeLugarEntity newEntity = factory.manufacturePojo(HospedajeLugarEntity.class);
//        HospedajeLugarEntity result = persistence.create(newEntity);
//
//        Assert.assertNotNull(result);
//        HospedajeLugarEntity entity = persistence.find(result.getHospedaje().getId(), result.getLugarInteres().getId());
//        Assert.assertNotNull(entity);
//        Assert.assertEquals(newEntity.getDistancia(), entity.getDistancia());
//    }
//
//    /**
//     * Test of find method, of class HospedajeLugarPersistence.
//     */
//    @Test
//    public void testFind() throws Exception {
//        HospedajeLugarEntity entity = data.get(0);
//        HospedajeLugarEntity newEntity = persistence.find(entity.getHospedaje().getId(), entity.getLugarInteres().getId());
//        Assert.assertNotNull(newEntity);
//        Assert.assertEquals(entity.getDistancia(), newEntity.getDistancia());
//    }
//
//    /**
//     * Test of findAll method, of class HospedajeLugarPersistence.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        HospedajeLugarEntity entity = data.get(0);
//        List<HospedajeLugarEntity> newEntity = persistence.findAll(entity.getHospedaje().getId());
//        Assert.assertNotNull(newEntity);
//    }
//
//    /**
//     * Test of update method, of class HospedajeLugarPersistence.
//     */
//    @Test
//    public void testUpdate() throws Exception {
//        HospedajeLugarEntity entity = data.get(0);
//        PodamFactory factory = new PodamFactoryImpl();
//        HospedajeLugarEntity newEntity = factory.manufacturePojo(HospedajeLugarEntity.class);
//
//        newEntity.setDistancia(entity.getDistancia());
//
//        persistence.update(newEntity);
//
//        HospedajeLugarEntity resp = persistence.find(entity.getHospedaje().getId(), entity.getLugarInteres().getId());
//
//        Assert.assertEquals(newEntity.getDistancia(), resp.getDistancia());
//    }
//
//    /**
//     * Test of delete method, of class HospedajeLugarPersistence.
//     */
//    @Test
//    public void testDelete() throws Exception {
//        HospedajeLugarEntity entity = data.get(0);
//        persistence.delete(entity.getHospedaje().getId(), entity.getLugarInteres().getId());
//        HospedajeLugarEntity newEntity = persistence.find(entity.getHospedaje().getId(), entity.getLugarInteres().getId());
//        Assert.assertNull(newEntity);
//
//    }
//
//    private void clearData() {
//        em.createQuery("delete from HospedajeLugarEntity").executeUpdate();
//    }
//
//    private void insertData() {
//        PodamFactory factory = new PodamFactoryImpl();
//        for (int i = 0; i < 3; i++) {
//            HospedajeLugarEntity entity = factory.manufacturePojo(HospedajeLugarEntity.class);
//            LugaresInteresEntity lugar = factory.manufacturePojo(LugaresInteresEntity.class);
//            HospedajeEntity hospedaje = factory.manufacturePojo(HospedajeEntity.class);
//            entity.setHospedaje(hospedaje);
//            entity.setLugarInteres(lugar);
//            em.persist(entity);
//            data.add(entity);
//        }
//    }
//}
