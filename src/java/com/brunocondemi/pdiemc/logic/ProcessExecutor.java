/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.logic;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettleXMLException;
import org.pentaho.di.core.logging.LogWriter;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;

/**
 *
 * @author bruno
 */
public class ProcessExecutor {
    public void runProcess(String path) throws KettleXMLException, KettleException{
         LogWriter log = LogWriter.getInstance();
         KettleEnvironment.init();
         
  
  //String file ="C:\\kettle\\job.kjb";
    JobMeta jobMeta = new JobMeta(path, null,null);
    Job job = new Job(null, jobMeta);
    job.getJobMeta().setArguments(null);
    job.initializeVariablesFrom(null);
    job.getJobMeta().setInternalKettleVariables(job);
   job.copyParametersFrom(job.getJobMeta());
     job.start();
      job.waitUntilFinished();
      
        
    }
    
}
