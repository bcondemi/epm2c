/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.filesystem;

import com.brunocondemi.pdiemc.config.SimpleConfigurator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author bruno
 */
public class IntegratedFileSystem implements IFileSystemManager {

    @Override
    public void addProcess(InputStream inputStream, String fileName) {
      
        System.out.println("Processing file: "+fileName);
        SimpleConfigurator sc = new SimpleConfigurator();
        String tmpFile = sc.getRepositoryHome()+"out.tmp";
        System.out.println("Generating temp file: "+tmpFile);
        File outputFile = new File(tmpFile);
        OutputStream out=null;
        try {
            //Create temp output file
            out= new FileOutputStream(outputFile);
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            //Extract the file
            System.out.println("File was generated");
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(IntegratedFileSystem.class.getName()).log(Level.SEVERE, null, ex);
            try {
                inputStream.close();
                out.close();
            } catch (IOException ex1) {
                Logger.getLogger(IntegratedFileSystem.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        try {
            inputStream.close();
            out.close();

        } catch (IOException ex) {
            Logger.getLogger(IntegratedFileSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        unzipProcess(outputFile.getAbsolutePath(),sc.getRepositoryHome()+"/"+fileName);
        

    }

    @Override
    public void deleteProcess(String processName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProcess(String processName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File getProcess(String processName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public void unzipProcess(String zipFile, String outputFolder){
 
       System.out.println("Unzip the file");
       byte[] buffer = new byte[1024];
 
     try{
 
    	//create output directory is not exists
    	File folder = new File(outputFolder);
    	if(!folder.exists()){
    	       System.out.println("Directory "+outputFolder+"doesn't exist it will be created");	
            folder.mkdir();
    	}
 
    	//get the zip file content
    	ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        
    	//get the zipped file list entry
    	ZipEntry ze = zis.getNextEntry();
 
    	while(ze!=null){
 
    	   String fileName = ze.getName();
           File newFile = new File(outputFolder + File.separator + fileName);
 
            //create all non exists folders
            //else you will hit FileNotFoundException for compressed folder
            new File(newFile.getParent()).mkdirs();
 
            FileOutputStream fos = new FileOutputStream(newFile);             
 
            int len;
            while ((len = zis.read(buffer)) > 0) {
       		fos.write(buffer, 0, len);
            }
 
            fos.close();   
            ze = zis.getNextEntry();
    	}
 
        zis.closeEntry();
    	zis.close();
 
    }catch(IOException ex){
       ex.printStackTrace(); 
    }
   }    
}


