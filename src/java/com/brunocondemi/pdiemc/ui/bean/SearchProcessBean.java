/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.ui.bean;

import com.brunocondemi.pdiemc.entity.ProcessEntity;
import java.util.List;
import com.brunocondemi.pdiemc.model.Process;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.remoteType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author bruno
 */
@ManagedBean
public class SearchProcessBean {

    private com.brunocondemi.pdiemc.model.Process currentProcess;
    private List<Process> processList;
    @PersistenceContext(unitName = "PDIEMCPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public SearchProcessBean() {
        initForTest();
    }

    public com.brunocondemi.pdiemc.model.Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        this.currentProcess = currentProcess;
    }

    public List<com.brunocondemi.pdiemc.model.Process> getProcessList() {
        Query query = em.createQuery("SELECT e FROM ProcessEntity e");

        List<Process> response = new ArrayList<Process>();

        List<ProcessEntity> pe = (List<ProcessEntity>) query.getResultList();
        Iterator i = pe.iterator();
        while (i.hasNext()) {
            Process p = new Process();
            ProcessEntity sp = (ProcessEntity) i.next();
            p.setName(sp.getName());
            p.setDescription(sp.getDescription());
            p.setAuthor(sp.getAuthor());
            //p.setActivae(sp.getActive().);
            p.setCategory1(sp.getCat1());
            p.setCategory2(sp.getCat2());
            p.setCategory3(sp.getCat3());
            p.setCategory4(sp.getCat4());
            p.setCategory5(sp.getCat5());


            response.add(p);
        }

        return response;
    }

    public void setProcessList(List<Process> processList) {
        this.processList = processList;
    }

    public void add() {
    }

    public void delete() {
        try {
            utx.begin();
            Query q = em.createNamedQuery("ProcessEntity.findByName", ProcessEntity.class);
            q.setParameter("name", currentProcess.getName());
            ProcessEntity pe = (ProcessEntity)q.getSingleResult();
            em.remove(pe);
            utx.commit();
           
        } catch (NotSupportedException ex) {
            Logger.getLogger(SearchProcessBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(SearchProcessBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(SearchProcessBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(SearchProcessBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(SearchProcessBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(SearchProcessBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(SearchProcessBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void find() {
        this.getProcessList();
    }

    public void run() {
    }

    public String close() {
        return "/index";
    }

    private void initForTest() {

        processList = new ArrayList<Process>();

        com.brunocondemi.pdiemc.model.Process p = new com.brunocondemi.pdiemc.model.Process();
        //p.setName("ETL Process 1");
        p.setName("C:\\kettle\\job.kjb");

        com.brunocondemi.pdiemc.model.Process p2 = new com.brunocondemi.pdiemc.model.Process();
        p2.setName("ETL Process 2");

        com.brunocondemi.pdiemc.model.Process p3 = new com.brunocondemi.pdiemc.model.Process();
        p3.setName("ETL Process 3");

        this.processList.add(p);
        this.processList.add(p2);
        this.processList.add(p3);



    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public void persist1(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
