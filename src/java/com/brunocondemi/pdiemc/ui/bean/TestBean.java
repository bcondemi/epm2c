/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.ui.bean;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author bruno
 */
@ManagedBean
public class TestBean {
    private String name;

    public TestBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void doTest(){
        System.out.println("test chiamata");
    }
    
}
