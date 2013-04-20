/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.ui.bean;

import com.brunocondemi.pdiemc.logic.ProcessExecutor;
import com.brunocondemi.pdiemc.model.Parameter;
import com.brunocondemi.pdiemc.model.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettleXMLException;

/**
 *
 * @author bruno
 */
@ManagedBean


public class RunProcessBean {
    
   private List<Parameter> paramList;
   private String processName;
   private Process p;

    public Process getP() {
        return p;
    }

    public void setP(Process p) {
        this.p = p;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
   

    public RunProcessBean() {
        
                     init();
    }

    public List<Parameter> getParamList() {
        return paramList;
    }

    public void setParamList(List<Parameter> paramList) {
        this.paramList = paramList;
    }
   public void execute(){
       System.out.println("run");
       
       if(paramList!=null){
       Iterator<Parameter> i = paramList.iterator();
       while(i.hasNext()){
           System.out.println(i.next().getDefaultValue());
       }
       }
       ProcessExecutor e = new ProcessExecutor();
       try {
           System.out.println("run: "+p.getName());
           e.runProcess(p.getPath());
       } catch (KettleXMLException ex) {
           Logger.getLogger(RunProcessBean.class.getName()).log(Level.SEVERE, null, ex);
       } catch (KettleException ex) {
           Logger.getLogger(RunProcessBean.class.getName()).log(Level.SEVERE, null, ex);
       }
       
     
       FacesContext context = FacesContext.getCurrentInstance();  
          
        context.addMessage(null, new FacesMessage("Process succesfult submitted"));  
       
       
       
   }
 
   public String view(){
       //this.execute();
       return "runProcess";
   }

    private void init() {
        p=new com.brunocondemi.pdiemc.model.Process();
        p.setName("Kettle Process");
        p.setDescription("Test Kettle process from web app");
        p.setActivae(Boolean.TRUE);
        p.setPath("C:\\kettle\\job.kjb");
        p.setAuthor("Bruno Condemi");
        processName=p.getName();
        Parameter p1 = new Parameter();
        p1.setName("param1");
        Parameter p2 = new Parameter();
        p2.setName("param2");
        ArrayList<Parameter> list = new ArrayList<Parameter>();
        list.add(p1);
        list.add(p2);
        p.setParameters(list);
    }
    
}
