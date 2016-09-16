/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "groom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groom.findAll", query = "SELECT g FROM Groom g"),
    @NamedQuery(name = "Groom.findByIdagent", query = "SELECT g FROM Groom g WHERE g.idagent = :idagent"),
    @NamedQuery(name = "Groom.findByGroomfirstname", query = "SELECT g FROM Groom g WHERE g.groomfirstname = :groomfirstname"),
    @NamedQuery(name = "Groom.findByGroomname", query = "SELECT g FROM Groom g WHERE g.groomname = :groomname"),
    @NamedQuery(name = "Groom.findByGroomphone", query = "SELECT g FROM Groom g WHERE g.groomphone = :groomphone"),
    @NamedQuery(name = "Groom.findByGroomemail", query = "SELECT g FROM Groom g WHERE g.groomemail = :groomemail"),
    @NamedQuery(name = "Groom.findByGroomlogin", query = "SELECT g FROM Groom g WHERE g.groomlogin = :groomlogin"),
    @NamedQuery(name = "Groom.findByGroompassword", query = "SELECT g FROM Groom g WHERE g.groompassword = :groompassword"),
    @NamedQuery(name = "Groom.findByGroompicture", query = "SELECT g FROM Groom g WHERE g.groompicture = :groompicture")})
public class Groom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idagent")
    private Integer idagent;
    @Size(max = 35)
    @Column(name = "groomfirstname")
    private String groomfirstname;
    @Size(max = 35)
    @Column(name = "groomname")
    private String groomname;
    @Column(name = "groomphone")
    private BigInteger groomphone;
    @Size(max = 31)
    @Column(name = "groomemail")
    private String groomemail;
    @Size(max = 30)
    @Column(name = "groomlogin")
    private String groomlogin;
    @Size(max = 30)
    @Column(name = "groompassword")
    private String groompassword;
    @Size(max = 254)
    @Column(name = "groompicture")
    private String groompicture;
    @OneToMany(mappedBy = "idagent")
    private List<Salesorder> salesorderList;

    public Groom() {
    }

    public Groom(Integer idagent) {
        this.idagent = idagent;
    }

    public Integer getIdagent() {
        return idagent;
    }

    public void setIdagent(Integer idagent) {
        this.idagent = idagent;
    }

    public String getGroomfirstname() {
        return groomfirstname;
    }

    public void setGroomfirstname(String groomfirstname) {
        this.groomfirstname = groomfirstname;
    }

    public String getGroomname() {
        return groomname;
    }

    public void setGroomname(String groomname) {
        this.groomname = groomname;
    }

    public BigInteger getGroomphone() {
        return groomphone;
    }

    public void setGroomphone(BigInteger groomphone) {
        this.groomphone = groomphone;
    }

    public String getGroomemail() {
        return groomemail;
    }

    public void setGroomemail(String groomemail) {
        this.groomemail = groomemail;
    }

    public String getGroomlogin() {
        return groomlogin;
    }

    public void setGroomlogin(String groomlogin) {
        this.groomlogin = groomlogin;
    }

    public String getGroompassword() {
        return groompassword;
    }

    public void setGroompassword(String groompassword) {
        this.groompassword = groompassword;
    }

    public String getGroompicture() {
        return groompicture;
    }

    public void setGroompicture(String groompicture) {
        this.groompicture = groompicture;
    }

    @XmlTransient
    public List<Salesorder> getSalesorderList() {
        return salesorderList;
    }

    public void setSalesorderList(List<Salesorder> salesorderList) {
        this.salesorderList = salesorderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idagent != null ? idagent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groom)) {
            return false;
        }
        Groom other = (Groom) object;
        if ((this.idagent == null && other.idagent != null) || (this.idagent != null && !this.idagent.equals(other.idagent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Groom[ idagent=" + idagent + " ]";
    }
    
}
