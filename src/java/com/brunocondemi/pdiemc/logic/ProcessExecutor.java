/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.logic;

import com.brunocondemi.pdiemc.model.Parameter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
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
@Stateless
public class ProcessExecutor implements IProcessExecutor {

    public void runProcess(String path, ArrayList<Parameter> params) {
        LogWriter log = LogWriter.getInstance();
        try {
            KettleEnvironment.init();
        } catch (KettleException ex) {
            Logger.getLogger(ProcessExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        //String file ="C:\\kettle\\job.kjb";
        JobMeta jobMeta = null;
        try {
            jobMeta = new JobMeta(path, null, null);
        } catch (KettleXMLException ex) {
            Logger.getLogger(ProcessExecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Job job = new Job(null, jobMeta);
       
        job.getJobMeta().setArguments(null);
        job.initializeVariablesFrom(null);
        job.getJobMeta().setInternalKettleVariables(job);
        job.copyParametersFrom(job.getJobMeta());
        job.start();
        job.waitUntilFinished();

    }

}
