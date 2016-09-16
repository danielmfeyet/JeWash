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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid = :customerid"),
    @NamedQuery(name = "Customer.findByCustomerfirstname", query = "SELECT c FROM Customer c WHERE c.customerfirstname = :customerfirstname"),
    @NamedQuery(name = "Customer.findByCustomername", query = "SELECT c FROM Customer c WHERE c.customername = :customername"),
    @NamedQuery(name = "Customer.findByCustomerphone", query = "SELECT c FROM Customer c WHERE c.customerphone = :customerphone"),
    @NamedQuery(name = "Customer.findByCustomeremail", query = "SELECT c FROM Customer c WHERE c.customeremail = :customeremail"),
    @NamedQuery(name = "Customer.findByCustomerlogin", query = "SELECT c FROM Customer c WHERE c.customerlogin = :customerlogin"),
    @NamedQuery(name = "Customer.findByCustomerpassword", query = "SELECT c FROM Customer c WHERE c.customerpassword = :customerpassword"),
    @NamedQuery(name = "Customer.findByCustomerpicture", query = "SELECT c FROM Customer c WHERE c.customerpicture = :customerpicture")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customerid")
    private Integer customerid;
    @Size(max = 30)
    @Column(name = "customerfirstname")
    private String customerfirstname;
    @Size(max = 14)
    @Column(name = "customername")
    private String customername;
    @Size(max = 30)
    @Column(name = "customerphone")
    private String customerphone;
    @Size(max = 35)
    @Column(name = "customeremail")
    private String customeremail;
    @Size(max = 30)
    @Column(name = "customerlogin")
    private String customerlogin;
    
    @Column(name = "customerpassword")
    private String customerpassword;
    @Size(max = 254)
    @Column(name = "customerpicture")
    private String customerpicture;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Address> addressList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Paymentaccount> paymentaccountList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Salesorder> salesorderList;

    public Customer() {
    }

    public Customer(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomerfirstname() {
        return customerfirstname;
    }

    public void setCustomerfirstname(String customerfirstname) {
        this.customerfirstname = customerfirstname;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getCustomerlogin() {
        return customerlogin;
    }

    public void setCustomerlogin(String customerlogin) {
        this.customerlogin = customerlogin;
    }

    public String getCustomerpassword() {
        return customerpassword;
    }

    public void setCustomerpassword(String customerpassword) {
        this.customerpassword = MD5.crypt(customerpassword);
    }

    public String getCustomerpicture() {
        return customerpicture;
    }

    public void setCustomerpicture(String customerpicture) {
        this.customerpicture = customerpicture;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @XmlTransient
    public List<Paymentaccount> getPaymentaccountList() {
        return paymentaccountList;
    }

    public void setPaymentaccountList(List<Paymentaccount> paymentaccountList) {
        this.paymentaccountList = paymentaccountList;
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
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Customer[ customerid=" + customerid + " ]";
    }
    
}
