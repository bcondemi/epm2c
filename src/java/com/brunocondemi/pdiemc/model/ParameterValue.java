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
public class ParameterValue<T> implements Serializable{
    private T t;
    public ParameterValue() {
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
}
