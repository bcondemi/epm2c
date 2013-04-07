/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.model;

import java.io.Serializable;

/**
 *
 * @author bruno
 */
public class ProcessCategory implements Serializable{
    private String name=null;
    private String description=null;
   

    public ProcessCategory() {
    }
    
    public ProcessCategory(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
