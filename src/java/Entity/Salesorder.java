/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "salesorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salesorder.findAll", query = "SELECT s FROM Salesorder s"),
    @NamedQuery(name = "Salesorder.findByOrderid", query = "SELECT s FROM Salesorder s WHERE s.orderid = :orderid"),
    @NamedQuery(name = "Salesorder.findByOrdertotalamount", query = "SELECT s FROM Salesorder s WHERE s.ordertotalamount = :ordertotalamount"),
    @NamedQuery(name = "Salesorder.findByOrderdatecollect", query = "SELECT s FROM Salesorder s WHERE s.orderdatecollect = :orderdatecollect"),
    @NamedQuery(name = "Salesorder.findByOrderdatedelivery", query = "SELECT s FROM Salesorder s WHERE s.orderdatedelivery = :orderdatedelivery"),
    @NamedQuery(name = "Salesorder.findByCollecthour", query = "SELECT s FROM Salesorder s WHERE s.collecthour = :collecthour"),
    @NamedQuery(name = "Salesorder.findByDeliveryhour", query = "SELECT s FROM Salesorder s WHERE s.deliveryhour = :deliveryhour")})
public class Salesorder implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesorder")
    private List<Orderarticle> orderarticleList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderid")
    private Integer orderid;
    @Column(name = "ordertotalamount")
    private BigInteger ordertotalamount;
    @Column(name = "orderdatecollect")
    @Temporal(TemporalType.DATE)
    private Date orderdatecollect;
    @Column(name = "orderdatedelivery")
    @Temporal(TemporalType.DATE)
    private Date orderdatedelivery;
    @Size(max = 40)
    @Column(name = "collecthour")
    private String collecthour;
    @Size(max = 40)
    @Column(name = "deliveryhour")
    private String deliveryhour;
    @JoinColumn(name = "add_addressid", referencedColumnName = "addressid")
    @ManyToOne(optional = false)
    private Address addAddressid;
    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    @ManyToOne(optional = false)
    private Address addressid;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne(optional = false)
    private Customer customerid;
    @JoinColumn(name = "idagent", referencedColumnName = "idagent")
    @ManyToOne
    private Groom idagent;
    @JoinColumn(name = "paymentaccountid", referencedColumnName = "paymentaccountid")
    @ManyToOne
    private Paymentaccount paymentaccountid;

    public Salesorder() {
    }

    public Salesorder(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public BigInteger getOrdertotalamount() {
        return ordertotalamount;
    }

    public void setOrdertotalamount(BigInteger ordertotalamount) {
        this.ordertotalamount = ordertotalamount;
    }

    public Date getOrderdatecollect() {
        return orderdatecollect;
    }

    public void setOrderdatecollect(Date orderdatecollect) {
        this.orderdatecollect = orderdatecollect;
    }

    public Date getOrderdatedelivery() {
        return orderdatedelivery;
    }

    public void setOrderdatedelivery(Date orderdatedelivery) {
        this.orderdatedelivery = orderdatedelivery;
    }

    public String getCollecthour() {
        return collecthour;
    }

    public void setCollecthour(String collecthour) {
        this.collecthour = collecthour;
    }

    public String getDeliveryhour() {
        return deliveryhour;
    }

    public void setDeliveryhour(String deliveryhour) {
        this.deliveryhour = deliveryhour;
    }

    public Address getAddAddressid() {
        return addAddressid;
    }

    public void setAddAddressid(Address addAddressid) {
        this.addAddressid = addAddressid;
    }

    public Address getAddressid() {
        return addressid;
    }

    public void setAddressid(Address addressid) {
        this.addressid = addressid;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Groom getIdagent() {
        return idagent;
    }

    public void setIdagent(Groom idagent) {
        this.idagent = idagent;
    }

    public Paymentaccount getPaymentaccountid() {
        return paymentaccountid;
    }

    public void setPaymentaccountid(Paymentaccount paymentaccountid) {
        this.paymentaccountid = paymentaccountid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salesorder)) {
            return false;
        }
        Salesorder other = (Salesorder) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Salesorder[ orderid=" + orderid + " ]";
    }

    @XmlTransient
    public List<Orderarticle> getOrderarticleList() {
        return orderarticleList;
    }

    public void setOrderarticleList(List<Orderarticle> orderarticleList) {
        this.orderarticleList = orderarticleList;
    }
    
}
