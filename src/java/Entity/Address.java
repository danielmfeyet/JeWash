/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Address.findByAddressname", query = "SELECT a FROM Address a WHERE a.addressname = :addressname"),
    @NamedQuery(name = "Address.findByAddressneighborhood", query = "SELECT a FROM Address a WHERE a.addressneighborhood = :addressneighborhood"),
    @NamedQuery(name = "Address.findByAddresscity", query = "SELECT a FROM Address a WHERE a.addresscity = :addresscity"),
    @NamedQuery(name = "Address.findByAddressdetail", query = "SELECT a FROM Address a WHERE a.addressdetail = :addressdetail"),
    @NamedQuery(name = "Address.findByAddressactif", query = "SELECT a FROM Address a WHERE a.addressactif = :addressactif"),
    @NamedQuery(name = "Address.findBycustomerid", query = "SELECT a FROM Address a WHERE a.customerid = :customerid and a.addressactif = :addressactif ")
})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addressid")
    private Integer addressid;
    @Size(max = 30)
    @Column(name = "addressname")
    private String addressname;
    @Size(max = 30)
    @Column(name = "addressneighborhood")
    private String addressneighborhood;
    @Size(max = 30)
    @Column(name = "addresscity")
    private String addresscity;
    @Size(max = 255)
    @Column(name = "addressdetail")
    private String addressdetail;
    @Column(name = "addressactif")
    private Boolean addressactif;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne(optional = false)
    private Customer customerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addAddressid")
    private List<Salesorder> salesorderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressid")
    private List<Salesorder> salesorderList1;

    public Address() {
    }

    public Address(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    public String getAddressneighborhood() {
        return addressneighborhood;
    }

    public void setAddressneighborhood(String addressneighborhood) {
        this.addressneighborhood = addressneighborhood;
    }

    public String getAddresscity() {
        return addresscity;
    }

    public void setAddresscity(String addresscity) {
        this.addresscity = addresscity;
    }

    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail;
    }

    public Boolean getAddressactif() {
        return addressactif;
    }

    public void setAddressactif(Boolean addressactif) {
        this.addressactif = addressactif;
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

    @XmlTransient
    public List<Salesorder> getSalesorderList1() {
        return salesorderList1;
    }

    public void setSalesorderList1(List<Salesorder> salesorderList1) {
        this.salesorderList1 = salesorderList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Address[ addressid=" + addressid + " ]";
    }
    
}
