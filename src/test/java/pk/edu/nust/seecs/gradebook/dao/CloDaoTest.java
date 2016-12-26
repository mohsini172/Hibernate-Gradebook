/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.edu.nust.seecs.gradebook.dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pk.edu.nust.seecs.gradebook.entity.Clo;

/**
 *
 * @author mohsini
 */
public class CloDaoTest {
    
    public CloDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addClo method, of class CloDao.
     */
    @org.junit.Test
    public void testAddClo() {
        System.out.println("addClo");
        Clo clo = new Clo();
        clo.setBtLevel("sdvds");
        clo.setDescription("sdfdsaf");
        clo.setName("dsfdf");
        clo.setPlo("adfsa");
        CloDao instance = new CloDao();
        instance.addClo(clo);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deleteClo method, of class CloDao.
     */
    @org.junit.Test
    public void testDeleteClo() {
        System.out.println("deleteClo");
        int cloid = 0;
        CloDao instance = new CloDao();
//        List<Clo> clos = instance.getAllClos();
//        if(clos.size()>0){
//            clo
//        }
        instance.deleteClo(cloid);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateClo method, of class CloDao.
     */
    @org.junit.Test
    public void testUpdateClo() {
        System.out.println("updateClo");
        Clo clo = null;
        CloDao instance = new CloDao();
        instance.updateClo(clo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllClos method, of class CloDao.
     */
    @org.junit.Test
    public void testGetAllClos() {
        System.out.println("getAllClos");
        CloDao instance = new CloDao();
        List<Clo> expResult = null;
        List<Clo> result = instance.getAllClos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCloById method, of class CloDao.
     */
    @org.junit.Test
    public void testGetCloById() {
        System.out.println("getCloById");
        int cloid = 0;
        CloDao instance = new CloDao();
        Clo expResult = null;
        Clo result = instance.getCloById(cloid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
