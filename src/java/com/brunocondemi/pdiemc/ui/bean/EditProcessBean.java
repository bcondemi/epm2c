/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.ui.bean;

import com.brunocondemi.pdiemc.entity.ParametersEntity;
import com.brunocondemi.pdiemc.entity.ParametersEntityPK;
import com.brunocondemi.pdiemc.entity.ProcessEntity;
import com.brunocondemi.pdiemc.model.Parameter;
import com.brunocondemi.pdiemc.model.Process;
import com.brunocondemi.pdiemc.ui.utility.ProcessUploadController;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author brunoo
 */
@ManagedBean
@SessionScoped
public class EditProcessBean implements Serializable {

    Process process = new Process();
    Parameter parameter = new Parameter();
    Parameter selectedParametr;
    List<Parameter> parameterList = new ArrayList<Parameter>();
    @PersistenceContext(unitName = "PDIEMCPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public void test(){
        System.out.println("test");
        FacesMessage msg = new FacesMessage("Failed");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
    
    }
    public void upload(FileUploadEvent event) {

        System.out.println(event.getFile().getFileName());

        //FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");

//            FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void addProcess() {
    }

    public EditProcessBean() {
        if (process != null) {
            process = new Process();
        }
        System.out.println("init");
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public List<Parameter> getParameterList() {
        return parameterList;
    }

    public void setParameterList(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    public Parameter getSelectedParametr() {
        return selectedParametr;
    }

    public void setSelectedParametr(Parameter selectedParametr) {
        this.selectedParametr = selectedParametr;
    }

    //Add parameter to internal bean list (HTML table will be updated) 
    public void addParameter() {

        Parameter p = new Parameter();
        p.setName(parameter.getName());
        p.setDescription(parameter.getDescription());
        p.setType(parameter.getType());
        p.setDefaultValue(parameter.getDefaultValue());
        p.setValue(parameter.getValue());
        parameterList.add(p);

    }

    public void save() {
        
        
        try {
            //Set Process Entity from bean
            ProcessEntity pe = new ProcessEntity(process.getName());
            pe.setDescription(process.getDescription());
            pe.setAuthor(process.getAuthor());
            pe.setActive(0);
            pe.setVersion(1);
            //pe.setCreationDate(new Date());
            pe.setCat1(process.getCategory1());
            pe.setCat2(process.getCategory2());
            pe.setCat3(process.getCategory3());
            pe.setCat4(process.getCategory4());
            pe.setCat5(process.getCategory5());
            
            //Start database transaction
            utx.begin();
            //Persist process
            em.persist(pe);
            
            //Loop over parameters
            Iterator<Parameter> i = parameterList.iterator();
            int j=1;
            while(i.hasNext()){
                Parameter cp = i.next();
                ParametersEntity parmEntity = new ParametersEntity();
                ParametersEntityPK pk = new ParametersEntityPK(process.getName(),cp.getName());
                parmEntity.setParametersEntityPK(pk);
                parmEntity.setType(cp.getType());
                parmEntity.setDescription(cp.getDescription());
                parmEntity.setDefValue(cp.getDefaultValue());
                parmEntity.setValue(cp.getValue());
                parmEntity.setSequence(j);
                j++;
                
                //Persist paramaters
                em.persist(parmEntity);
                
            }
           
            //Commit trasaction
            utx.commit();
            
            //UI update
            FacesMessage msg = new FacesMessage("Succesful");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            FacesMessage msg = new FacesMessage("Operation failed");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //throw new RuntimeException(e);
        }
       
    }
}
