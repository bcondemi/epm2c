/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "PROCESS", catalog = "", schema = "EPM2C")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessEntity.findAll", query = "SELECT p FROM ProcessEntity p"),
    @NamedQuery(name = "ProcessEntity.findByName", query = "SELECT p FROM ProcessEntity p WHERE p.name = :name"),
    @NamedQuery(name = "ProcessEntity.findByDescription", query = "SELECT p FROM ProcessEntity p WHERE p.description = :description"),
    @NamedQuery(name = "ProcessEntity.findByAuthor", query = "SELECT p FROM ProcessEntity p WHERE p.author = :author"),
    @NamedQuery(name = "ProcessEntity.findByVersion", query = "SELECT p FROM ProcessEntity p WHERE p.version = :version"),
    @NamedQuery(name = "ProcessEntity.findByActive", query = "SELECT p FROM ProcessEntity p WHERE p.active = :active"),
    @NamedQuery(name = "ProcessEntity.findByCreationDate", query = "SELECT p FROM ProcessEntity p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "ProcessEntity.findByCat1", query = "SELECT p FROM ProcessEntity p WHERE p.cat1 = :cat1"),
    @NamedQuery(name = "ProcessEntity.findByCat2", query = "SELECT p FROM ProcessEntity p WHERE p.cat2 = :cat2"),
    @NamedQuery(name = "ProcessEntity.findByCat3", query = "SELECT p FROM ProcessEntity p WHERE p.cat3 = :cat3"),
    @NamedQuery(name = "ProcessEntity.findByCat4", query = "SELECT p FROM ProcessEntity p WHERE p.cat4 = :cat4"),
    @NamedQuery(name = "ProcessEntity.findByCat5", query = "SELECT p FROM ProcessEntity p WHERE p.cat5 = :cat5")})
public class ProcessEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 30)
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "VERSION")
    private Integer version;
    @Column(name = "ACTIVE")
    private Integer active;
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Size(max = 30)
    @Column(name = "CAT1")
    private String cat1;
    @Size(max = 30)
    @Column(name = "CAT2")
    private String cat2;
    @Column(name = "CAT3")
    private String cat3;
    @Size(max = 30)
    @Column(name = "CAT4")
    private String cat4;
    @Size(max = 30)
    @Column(name = "CAT5")
    private String cat5;

    public ProcessEntity() {
    }

    public ProcessEntity(String name) {
        this.name = name;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public String getCat4() {
        return cat4;
    }

    public void setCat4(String cat4) {
        this.cat4 = cat4;
    }

    public String getCat5() {
        return cat5;
    }

    public void setCat5(String cat5) {
        this.cat5 = cat5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessEntity)) {
            return false;
        }
        ProcessEntity other = (ProcessEntity) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.brunocondemi.pdiemc.entity.ProcessEntity[ name=" + name + " ]";
    }
    
}
