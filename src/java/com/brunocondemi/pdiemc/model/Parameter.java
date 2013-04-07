/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Parameter implements Serializable{
    private String name=null;
    private String description=null;
    private Boolean isMultiValue=false;
    private String defaultValue=null;
    private String type=null;
    private String value=null;
    private ArrayList<ParameterValue> values=null;
    private final static String[] types = {"String","Number","Date"};

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    

    public Parameter() {
    }
    public Parameter(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ParameterValue> getValues() {
        return values;
    }

    public void setValues(ArrayList<ParameterValue> values) {
        this.values = values;
    }

    public static String[] getTypes() {
        return types;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsMultiValue() {
        return isMultiValue;
    }

    public void setIsMultiValue(Boolean isMultiValue) {
        this.isMultiValue = isMultiValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

  
    
    
    
    
}
