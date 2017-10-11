/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
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
 * @author a.eslava
 */
@RunWith(Arquillian.class)
public class EstudiantePersistenceTest {
    
    @Inject
    private EstudiantePersistence persistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<EstudianteEntity> data = new ArrayList<EstudianteEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EstudianteEntity.class.getPackage())
                .addPackage(EstudiantePersistence.class.getPackage())
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
            EstudianteEntity entity = factory.manufacturePojo(EstudianteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    public EstudiantePersistenceTest() {
        
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
     * Test of create method, of class EstudiantePersistence.
     */
    @Test
    public void testCreate() throws Exception {
PodamFactory factory = new PodamFactoryImpl();
    EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
    EstudianteEntity result = persistence.create(newEntity);

    Assert.assertNotNull(result);
    EstudianteEntity entity = em.find(EstudianteEntity.class, result.getCedula());
    Assert.assertNotNull(entity);
    Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    /**
     * Test of update method, of class EstudiantePersistence.
     */
    @Test
    public void testUpdate() throws Exception {
        EstudianteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);

        newEntity.setCedula(entity.getCedula());

        persistence.update(newEntity);

        EstudianteEntity resp = em.find(EstudianteEntity.class, entity.getCedula());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }

    /**
     * Test of delete method, of class EstudiantePersistence.
     */
    @Test
    public void testDelete() throws Exception {
        EstudianteEntity entity = data.get(0);
        persistence.delete(entity.getCedula());
        EstudianteEntity deleted = em.find(EstudianteEntity.class, entity.getCedula());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class EstudiantePersistence.
     */
    @Test
    public void testFind() throws Exception {
        EstudianteEntity entity = data.get(0);
        EstudianteEntity newEntity = persistence.find(entity.getCedula());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
    }

    /**
     * Test of findAll method, of class EstudiantePersistence.
     */
    @Test
    public void testFindAll() throws Exception {
        List<EstudianteEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (EstudianteEntity ent : list) {
            boolean found = false;
            for (EstudianteEntity entity : data) {
                if (ent.getCedula().equals(entity.getCedula())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
@Test
    public void equalsHashTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
        
        assertTrue(newEntity.equals(newEntity));
        assertEquals(newEntity.hashCode(), newEntity.hashCode());
        
        EstudianteEntity tipo=null;
        assertFalse(newEntity.equals(tipo));
        
  
        OrigenEntity newOrigenEntity = factory.manufacturePojo(OrigenEntity.class);
        assertFalse(newEntity.equals(newOrigenEntity));
        
          EstudianteEntity newEntity2 = factory.manufacturePojo(EstudianteEntity.class);
        newEntity2.setCedula(newEntity.getCedula());
        assertTrue(newEntity.equals(newEntity2));
        
        newEntity2.setCedula(newEntity.getCedula()+1);
        assertFalse(newEntity.equals(newEntity2));
    }
    
    @Test
    public void entitiesTest() {
        PodamFactory factory = new PodamFactoryImpl();
        OrigenEntity newOrigenEntity = factory.manufacturePojo(OrigenEntity.class);
        EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
        ReservaEntity newReservaEntity = factory.manufacturePojo(ReservaEntity.class);

        List<FacturaEntity> facturas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            facturas.add(factory.manufacturePojo(FacturaEntity.class));
        }
        List<CalificacionEntity> calificaciones = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            calificaciones.add(factory.manufacturePojo(CalificacionEntity.class));
        }

        newEntity.setOrigen(newOrigenEntity);
        assertEquals(newEntity.getOrigen(), newOrigenEntity);
        newEntity.setFacturas(facturas);
        assertEquals(newEntity.getFacturas(), facturas);
        newEntity.setReserva(newReservaEntity);
        assertEquals(newEntity.getReserva(), newReservaEntity);
        newEntity.setCalificaciones(calificaciones);
        assertEquals(newEntity.getCalificaciones(), calificaciones);

    }

}
