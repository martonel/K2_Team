/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kupa Judit
 */
public class fooldalControllerTest {
    
    public fooldalControllerTest() {
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
     * Test of backButton method, of class fooldalController.
     */
    @Test
    public void testBackButton() {
        /*System.out.println("backButton");
        ActionEvent event = null;
        fooldalController instance = new fooldalController();
        instance.backButton(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of elkuld method, of class fooldalController.
     */
    //fooldalController publishing = mock(fooldalController.class);
    
    @Test
    public void testElkuld() {
        //System.out.println("elkuld");
        //ActionEvent event = null;
        //fooldalController instance = new fooldalController();
        
        
    }

    /*
     * Test of getDatas method, of class fooldalController.
     */
    @Test
    public void testGetDatas() {
        System.out.println("getDatasT");
        fooldalController instance = new fooldalController();
        String sor = instance.getDatas();
        System.out.println(sor);
        
        String[] sor2 = sor.split(",");
        String res = sor2[1]+","+ sor2[2]+","+ sor2[3]+","+ sor2[4]+","+ sor2[5]+","+ sor2[6];
        //System.out.println(res);
        String expResult = "unknown,unknown,unknown,unknown,unknown,Rendelés feldolgozás alatt";
        //String result = instance.getDatas();
        assertEquals(expResult, res);
    }
    
}
