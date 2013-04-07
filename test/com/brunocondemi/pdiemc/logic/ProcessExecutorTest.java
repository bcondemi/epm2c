/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bruno
 */
public class ProcessExecutorTest {
    
    public ProcessExecutorTest() {
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
     * Test of runProcess method, of class ProcessExecutor.
     */
    @Test
    public void testRunProcess() throws Exception {
        System.out.println("runProcess");
        Process p = null;
        ProcessExecutor instance = new ProcessExecutor();
        instance.runProcess("C:\\kettle\\job.kjb");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}