/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author bruno
 */
@Embeddable
public class ParametersEntityPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PROCESS")
    private String process;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PARAMETER")
    private String parameter;

    public ParametersEntityPK() {
    }

    public ParametersEntityPK(String process, String parameter) {
        this.process = process;
        this.parameter = parameter;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (process != null ? process.hashCode() : 0);
        hash += (parameter != null ? parameter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametersEntityPK)) {
            return false;
        }
        ParametersEntityPK other = (ParametersEntityPK) object;
        if ((this.process == null && other.process != null) || (this.process != null && !this.process.equals(other.process))) {
            return false;
        }
        if ((this.parameter == null && other.parameter != null) || (this.parameter != null && !this.parameter.equals(other.parameter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.brunocondemi.pdiemc.entity.ParametersEntityPK[ process=" + process + ", parameter=" + parameter + " ]";
    }
    
}
