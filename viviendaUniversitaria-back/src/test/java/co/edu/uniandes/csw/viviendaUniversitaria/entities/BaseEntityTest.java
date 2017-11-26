/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ws.duarte
 */
public class BaseEntityTest {
    private List<BaseEntityImpl> data = new ArrayList<>();
    
    public BaseEntityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        clearData();
        insertData();
    }
    
    private void clearData() {
        data = new ArrayList<>();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            BaseEntityImpl entity = factory.manufacturePojo(BaseEntityImpl.class);
            data.add(entity);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class BaseEntity.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetId() throws Exception {
        BaseEntity baseT = data.get(0);
        BaseEntity base = new BaseEntityImpl();
        base.setId(baseT.getId());
        Assert.assertTrue(base.getId().equals(baseT.getId()));
    }

    /**
     * Test of setId method, of class BaseEntity.
     * @throws java.lang.Exception
     */
    @Test
    public void testSetId() throws Exception {
        BaseEntity baseT = data.get(0);
        BaseEntity base = new BaseEntityImpl();
        base.setId(baseT.getId());
        Assert.assertTrue(base.getId().equals(baseT.getId()));
    }

    /**
     * Test of equals method, of class BaseEntity.
     * @throws java.lang.Exception
     */
    @Test
    public void testEquals() throws Exception {
        BaseEntity base = new BaseEntityImpl();
        base.setId(null);
        Assert.assertFalse(base.equals(null));
        Assert.assertFalse(base.equals(new String()));
        Assert.assertFalse(base.equals(base));
        base.setId(Long.MIN_VALUE);
        Assert.assertTrue(base.equals(base));
    }

    /**
     * Test of hashCode method, of class BaseEntity.
     * @throws java.lang.Exception
     */
    @Test
    public void testHashCode() throws Exception {
        BaseEntity base = new BaseEntityImpl();
        base.setId(null);
        base.hashCode();
        base.setId(new Long(0));
        Assert.assertTrue(base.hashCode() == new Long(0).hashCode());
    }

    public class BaseEntityImpl extends BaseEntity {
    }
    
}
