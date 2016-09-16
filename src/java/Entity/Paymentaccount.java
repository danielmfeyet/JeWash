/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "paymentaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymentaccount.findAll", query = "SELECT p FROM Paymentaccount p"),
    @NamedQuery(name = "Paymentaccount.findByPaymentaccountid", query = "SELECT p FROM Paymentaccount p WHERE p.paymentaccountid = :paymentaccountid"),
    @NamedQuery(name = "Paymentaccount.findByPaymentaccounttype", query = "SELECT p FROM Paymentaccount p WHERE p.paymentaccounttype = :paymentaccounttype")})
public class Paymentaccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentaccountid")
    private Integer paymentaccountid;
    @Size(max = 30)
    @Column(name = "paymentaccounttype")
    private String paymentaccounttype;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne(optional = false)
    private Customer customerid;
    @OneToMany(mappedBy = "paymentaccountid")
    private List<Salesorder> salesorderList;

    public Paymentaccount() {
    }

    public Paymentaccount(Integer paymentaccountid) {
        this.paymentaccountid = paymentaccountid;
    }

    public Integer getPaymentaccountid() {
        return paymentaccountid;
    }

    public void setPaymentaccountid(Integer paymentaccountid) {
        this.paymentaccountid = paymentaccountid;
    }

    public String getPaymentaccounttype() {
        return paymentaccounttype;
    }

    public void setPaymentaccounttype(String paymentaccounttype) {
        this.paymentaccounttype = paymentaccounttype;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
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
        hash += (paymentaccountid != null ? paymentaccountid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentaccount)) {
            return false;
        }
        Paymentaccount other = (Paymentaccount) object;
        if ((this.paymentaccountid == null && other.paymentaccountid != null) || (this.paymentaccountid != null && !this.paymentaccountid.equals(other.paymentaccountid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Paymentaccount[ paymentaccountid=" + paymentaccountid + " ]";
    }
    
}
