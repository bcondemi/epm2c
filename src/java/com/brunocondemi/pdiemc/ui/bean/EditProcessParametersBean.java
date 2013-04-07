/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.ui.bean;

import com.brunocondemi.pdiemc.model.Parameter;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author bruno
 */
@ManagedBean
public class EditProcessParametersBean {
    private Parameter parameter;
    private List<String> types = new ArrayList<String>();

    public EditProcessParametersBean() {
        types.add("LITTERAL");
        types.add("NUMERIC");
        types.add("DATE");
    }

    public Parameter getParameter() {
        return parameter;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
    
    public void addParameterToProcess(String processName){
        System.out.println("Add parameter");
    }
    
    
}
