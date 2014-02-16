/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.brunocondemi.pdiemc.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class SimpleConfigurator implements IConfigurator{

    @Override
    public String getKettleHome() {
     return "/Users/bruno/dev/kettle_code" ;
    }

    @Override
    public String getRepositoryHome() {
     return "/Users/bruno/dev/kettle_code" ;
    }

    @Override
    public InputStream getKettleProperties() {
        String ktlHome = this.getKettleHome();
        FileInputStream f=null;
        try {
            f = new FileInputStream(ktlHome+"/"+"kettle.properties");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SimpleConfigurator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
    
    
}
