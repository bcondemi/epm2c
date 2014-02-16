/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.brunocondemi.pdiemc.filesystem;

import java.io.File;
import java.io.InputStream;

/**
 *
 * @author bruno
 */
public interface IFileSystemManager {
   
    public void addProcess(InputStream inputStream, String fileName);
    public void deleteProcess(String processName);
    public void updateProcess(String processName);
    public File getProcess(String processName);
    
}
