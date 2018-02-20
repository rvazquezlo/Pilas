/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RVAZQUEZLO
 */
public class RevisorParentesisTest {
    
    public RevisorParentesisTest() {
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
     * Test of getAnalizar method, of class RevisorParentesis.
     */
    @Test
    public void testGetAnalizar() {
        System.out.println("getAnalizar");
        RevisorParentesis instance = null;
        String expResult = "";
        String result = instance.getAnalizar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnalizar method, of class RevisorParentesis.
     */
    @Test
    public void testSetAnalizar() {
        System.out.println("setAnalizar");
        String analizar = "3+(";
        RevisorParentesis instance = null;
        instance.setAnalizar(analizar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class RevisorParentesis.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RevisorParentesis instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class RevisorParentesis.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        RevisorParentesis instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class RevisorParentesis.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        RevisorParentesis instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of analizaString method, of class RevisorParentesis.
     */
    @Test
    public void testAnalizaString() {
        System.out.println("analizaString");
        RevisorParentesis instance = null;
        boolean expResult = true;
        boolean result = instance.analizaString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
