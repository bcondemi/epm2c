/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "PARAMETERS", catalog = "", schema = "EPM2C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParametersEntity.findAll", query = "SELECT p FROM ParametersEntity p"),
    @NamedQuery(name = "ParametersEntity.findByProcess", query = "SELECT p FROM ParametersEntity p WHERE p.parametersEntityPK.process = :process"),
    @NamedQuery(name = "ParametersEntity.findByParameter", query = "SELECT p FROM ParametersEntity p WHERE p.parametersEntityPK.parameter = :parameter"),
    @NamedQuery(name = "ParametersEntity.findByDescription", query = "SELECT p FROM ParametersEntity p WHERE p.description = :description"),
    @NamedQuery(name = "ParametersEntity.findByDefValue", query = "SELECT p FROM ParametersEntity p WHERE p.defValue = :defValue"),
    @NamedQuery(name = "ParametersEntity.findByValue", query = "SELECT p FROM ParametersEntity p WHERE p.value = :value"),
    @NamedQuery(name = "ParametersEntity.findBySequence", query = "SELECT p FROM ParametersEntity p WHERE p.sequence = :sequence"),
    @NamedQuery(name = "ParametersEntity.findByType", query = "SELECT p FROM ParametersEntity p WHERE p.type = :type")})
public class ParametersEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParametersEntityPK parametersEntityPK;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "DEF_VALUE")
    private String defValue;
    @Size(max = 255)
    @Column(name = "VALUE")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEQUENCE")
    private int sequence;
    @Size(max = 10)
    @Column(name = "TYPE")
    private String type;

    public ParametersEntity() {
    }

    public ParametersEntity(ParametersEntityPK parametersEntityPK) {
        this.parametersEntityPK = parametersEntityPK;
    }

    public ParametersEntity(ParametersEntityPK parametersEntityPK, int sequence) {
        this.parametersEntityPK = parametersEntityPK;
        this.sequence = sequence;
    }

    public ParametersEntity(String process, String parameter) {
        this.parametersEntityPK = new ParametersEntityPK(process, parameter);
    }

    public ParametersEntityPK getParametersEntityPK() {
        return parametersEntityPK;
    }

    public void setParametersEntityPK(ParametersEntityPK parametersEntityPK) {
        this.parametersEntityPK = parametersEntityPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefValue() {
        return defValue;
    }

    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parametersEntityPK != null ? parametersEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametersEntity)) {
            return false;
        }
        ParametersEntity other = (ParametersEntity) object;
        if ((this.parametersEntityPK == null && other.parametersEntityPK != null) || (this.parametersEntityPK != null && !this.parametersEntityPK.equals(other.parametersEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.brunocondemi.pdiemc.entity.ParametersEntity[ parametersEntityPK=" + parametersEntityPK + " ]";
    }
    
}
