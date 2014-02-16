/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.brunocondemi.pdiemc.config;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author bruno
 */
public interface IConfigurator {
    public String getKettleHome();
    public InputStream getKettleProperties();
    public String getRepositoryHome();
    
    
}
