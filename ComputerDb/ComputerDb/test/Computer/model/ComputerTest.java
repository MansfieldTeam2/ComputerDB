/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Computer.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author boca
 */
public class ComputerTest {
    
    public ComputerTest() {
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
     * Test of getModel method, of class Computer.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        Computer instance = new Computer();
        String expResult = "";
        String result = instance.getModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setModel method, of class Computer.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        String model = "";
        Computer instance = new Computer();
        instance.setModel(model);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getId method, of class Computer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Computer instance = new Computer();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setId method, of class Computer.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Computer instance = new Computer();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getModelNumber method, of class Computer.
     */
    @Test
    public void testGetModelNumber() {
        System.out.println("getModelNumber");
        Computer instance = new Computer();
        String expResult = "";
        String result = instance.getModelNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setModelNumber method, of class Computer.
     */
    @Test
    public void testSetModelNumber() {
        System.out.println("setModelNumber");
        String modelNumber = "";
        Computer instance = new Computer();
        instance.setModelNumber(modelNumber);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getModelType method, of class Computer.
     */
    @Test
    public void testGetModelType() {
        System.out.println("getModelType");
        Computer instance = new Computer();
        String expResult = "";
        String result = instance.getModelType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setModelType method, of class Computer.
     */
    @Test
    public void testSetModelType() {
        System.out.println("setModelType");
        String modelType = "";
        Computer instance = new Computer();
        instance.setModelType(modelType);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getCost method, of class Computer.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Computer instance = new Computer();
        double expResult = 0.0;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCost method, of class Computer.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        double cost = 0.0;
        Computer instance = new Computer();
        instance.setCost(cost);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}
