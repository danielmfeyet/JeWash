/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByAdministratorid", query = "SELECT a FROM Administrator a WHERE a.administratorid = :administratorid"),
    @NamedQuery(name = "Administrator.findByAdministratorname", query = "SELECT a FROM Administrator a WHERE a.administratorname = :administratorname"),
    @NamedQuery(name = "Administrator.findByAdministratorlogin", query = "SELECT a FROM Administrator a WHERE a.administratorlogin = :administratorlogin"),
    @NamedQuery(name = "Administrator.findByAdministratorpassword", query = "SELECT a FROM Administrator a WHERE a.administratorpassword = :administratorpassword")})
public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "administratorid")
    private Integer administratorid;
    @Size(max = 35)
    @Column(name = "administratorname")
    private String administratorname;
    @Size(max = 35)
    @Column(name = "administratorlogin")
    private String administratorlogin;
    @Size(max = 35)
    @Column(name = "administratorpassword")
    private String administratorpassword;

    public Administrator() {
    }

    public Administrator(Integer administratorid) {
        this.administratorid = administratorid;
    }

    public Integer getAdministratorid() {
        return administratorid;
    }

    public void setAdministratorid(Integer administratorid) {
        this.administratorid = administratorid;
    }

    public String getAdministratorname() {
        return administratorname;
    }

    public void setAdministratorname(String administratorname) {
        this.administratorname = administratorname;
    }

    public String getAdministratorlogin() {
        return administratorlogin;
    }

    public void setAdministratorlogin(String administratorlogin) {
        this.administratorlogin = administratorlogin;
    }

    public String getAdministratorpassword() {
        return administratorpassword;
    }

    public void setAdministratorpassword(String administratorpassword) {
        this.administratorpassword = administratorpassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administratorid != null ? administratorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.administratorid == null && other.administratorid != null) || (this.administratorid != null && !this.administratorid.equals(other.administratorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Administrator[ administratorid=" + administratorid + " ]";
    }
    
}
