/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Embeddable
public class OrderarticlePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "orderid")
    private int orderid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "articleid")
    private int articleid;

    public OrderarticlePK() {
    }

    public OrderarticlePK(int orderid, int articleid) {
        this.orderid = orderid;
        this.articleid = articleid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderid;
        hash += (int) articleid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderarticlePK)) {
            return false;
        }
        OrderarticlePK other = (OrderarticlePK) object;
        if (this.orderid != other.orderid) {
            return false;
        }
        if (this.articleid != other.articleid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderarticlePK[ orderid=" + orderid + ", articleid=" + articleid + " ]";
    }
    
}
