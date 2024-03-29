/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.ui.bean;

import com.brunocondemi.pdiemc.entity.ParametersEntity;
import com.brunocondemi.pdiemc.entity.ProcessEntity;
import com.brunocondemi.pdiemc.logic.ProcessExecutor;
import com.brunocondemi.pdiemc.model.Parameter;
import com.brunocondemi.pdiemc.model.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.PessimisticLockScope;
import javax.persistence.Query;
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
   private com.brunocondemi.pdiemc.model.Process p;
   
   @EJB
   ProcessExecutor processExecutor;
   @PersistenceContext(unitName = "PDIEMCPU")
    private EntityManager em;

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
       
     
           System.out.println("run: "+p.getName());
           processExecutor.runProcess(p.getPath(),null);
      
       
     
       FacesContext context = FacesContext.getCurrentInstance();  
          
        context.addMessage(null, new FacesMessage("Process succesfult submitted"));  
       
       
       
   }
 
   public String view(){
       //this.execute();
        init();
       return "runProcess";
   }

    private void init() {
        p=getProcessByName(processName);
//        p.setName("Kettle Process");
//        p.setDescription("Test Kettle process from web app");
//        p.setActivae(Boolean.TRUE);
//        p.setPath("C:\\kettle\\job.kjb");
//        p.setAuthor("Bruno Condemi");
//        processName=p.getName();
//        Parameter p1 = new Parameter();
//        p1.setName("param1");
//        Parameter p2 = new Parameter();
//        p2.setName("param2");
//        ArrayList<Parameter> list = new ArrayList<Parameter>();
//        list.add(p1);
//        list.add(p2);
//        p.setParameters(list);
    }

    private Process getProcessByName(String processName) {
    
        Query q = em.createNamedQuery("ProcessEntity.findByName");
        q.setParameter("name", processName);
        ProcessEntity pEntity = (ProcessEntity)q.getResultList().get(0);
        
        Query q2= em.createNamedQuery("ParametersEntity.findByProcess");
        q2.setParameter("process", processName);
        List<ParametersEntity> params = q2.getResultList();
        
        Process pr = new Process();
        pr.setName(pEntity.getName());
        pr.setDescription(pEntity.getDescription());
        pr.setActivae(true);
        pr.setAuthor(pEntity.getAuthor());
        pr.setCategory1(pEntity.getCat1());
        pr.setCategory2(pEntity.getCat2());
        pr.setCategory3(pEntity.getCat3());
        pr.setCategory4(pEntity.getCat4());
        pr.setCategory5(pEntity.getCat5());
        pr.setCreationDate(pEntity.getCreationDate());
        pr.setPath("//");
        
        ArrayList<Parameter> pList = new ArrayList<Parameter>();
        Iterator<ParametersEntity> i = params.iterator();
        while(i.hasNext()){
            Parameter cp = new Parameter();
            ParametersEntity pe = i.next();
            cp.setName(pe.getParametersEntityPK().getParameter());
            cp.setDescription(pe.getDescription());
            cp.setValue(pe.getDefValue());
            cp.setType(pe.getType());
            
            pList.add(cp);
            
        }
        pr.setParameters(pList);
        return pr;
        
        
    }
    
}
