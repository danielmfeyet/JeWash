/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "orderarticle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderarticle.findAll", query = "SELECT o FROM Orderarticle o"),
    @NamedQuery(name = "Orderarticle.findByOrderid", query = "SELECT o FROM Orderarticle o WHERE o.orderarticlePK.orderid = :orderid"),
    @NamedQuery(name = "Orderarticle.findByArticleid", query = "SELECT o FROM Orderarticle o WHERE o.orderarticlePK.articleid = :articleid"),
    @NamedQuery(name = "Orderarticle.findByQuantity", query = "SELECT o FROM Orderarticle o WHERE o.quantity = :quantity")})
public class Orderarticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderarticlePK orderarticlePK;
    @Column(name = "quantity")
    private BigInteger quantity;
    @JoinColumn(name = "articleid", referencedColumnName = "articleid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "orderid", referencedColumnName = "orderid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Salesorder salesorder;

    public Orderarticle() {
    }

    public Orderarticle(OrderarticlePK orderarticlePK) {
        this.orderarticlePK = orderarticlePK;
    }

    public Orderarticle(int orderid, int articleid) {
        this.orderarticlePK = new OrderarticlePK(orderid, articleid);
    }

    public OrderarticlePK getOrderarticlePK() {
        return orderarticlePK;
    }

    public void setOrderarticlePK(OrderarticlePK orderarticlePK) {
        this.orderarticlePK = orderarticlePK;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Salesorder getSalesorder() {
        return salesorder;
    }

    public void setSalesorder(Salesorder salesorder) {
        this.salesorder = salesorder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderarticlePK != null ? orderarticlePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderarticle)) {
            return false;
        }
        Orderarticle other = (Orderarticle) object;
        if ((this.orderarticlePK == null && other.orderarticlePK != null) || (this.orderarticlePK != null && !this.orderarticlePK.equals(other.orderarticlePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Orderarticle[ orderarticlePK=" + orderarticlePK + " ]";
    }
    
}
