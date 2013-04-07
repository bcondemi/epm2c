/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.ui.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

import org.primefaces.model.UploadedFile;

/**
 *
 * @author bruno
 */
@ManagedBean
public class ProcessUploadController{
    private UploadedFile file; 
    private String out;
    private final static Logger log = Logger.getLogger(ProcessUploadController.class .getName()); 

    public ProcessUploadController() {
    }

   

    public void  upload(FileUploadEvent event){
        log.info("upload");
        log.info(out);
        log.info(file.getFileName());
       //FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
         if(file != null) {
            log.log(Level.INFO, "upload file:{0}", file.getFileName());
//            FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    

    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }
    
}
