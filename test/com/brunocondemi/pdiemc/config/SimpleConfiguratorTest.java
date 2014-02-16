/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.brunocondemi.pdiemc.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author bruno
 */
public class SimpleConfiguratorTest {
    
    public SimpleConfiguratorTest() {
    }

    /**
     * Test of getKettleHome method, of class SimpleConfigurator.
     */
    @Ignore
    public void testGetKettleHome() {
        System.out.println("getKettleHome");
        SimpleConfigurator instance = new SimpleConfigurator();
        String expResult = "";
        String result = instance.getKettleHome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRepositoryHome method, of class SimpleConfigurator.
     */
    @Ignore
    public void testGetRepositoryHome() {
        System.out.println("getRepositoryHome");
        SimpleConfigurator instance = new SimpleConfigurator();
        String expResult = "";
        String result = instance.getRepositoryHome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKettleProperties method, of class SimpleConfigurator.
     */
    @Test
    public void testGetKettleProperties() throws IOException {
        System.out.println("getKettleProperties");
        SimpleConfigurator instance = new SimpleConfigurator();
        //File expResult = new File("/Users/bruno/.kettle/kettle.properties");
        InputStream result = instance.getKettleProperties();
        //assertEquals(expResult, result);
        
        Properties prop = new Properties();
        prop.load(result);
        
        System.out.println("Printing all kettle.properties...");
        prop.list(System.out);
     
       
    }
    
}
