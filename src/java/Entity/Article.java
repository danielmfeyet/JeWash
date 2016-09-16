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
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByArticleid", query = "SELECT a FROM Article a WHERE a.articleid = :articleid"),
    @NamedQuery(name = "Article.findByArticleentitled", query = "SELECT a FROM Article a WHERE a.articleentitled = :articleentitled"),
    @NamedQuery(name = "Article.findByArticleprice", query = "SELECT a FROM Article a WHERE a.articleprice = :articleprice"),
    @NamedQuery(name = "Article.findByArticletype", query = "SELECT a FROM Article a WHERE a.articletype = :articletype")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "articleid")
    private Integer articleid;
    @Size(max = 30)
    @Column(name = "articleentitled")
    private String articleentitled;
    @Size(max = 30)
    @Column(name = "articleprice")
    private String articleprice;
    @Size(max = 14)
    @Column(name = "articletype")
    private String articletype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<Orderarticle> orderarticleList;

    public Article() {
    }

    public Article(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getArticleentitled() {
        return articleentitled;
    }

    public void setArticleentitled(String articleentitled) {
        this.articleentitled = articleentitled;
    }

    public String getArticleprice() {
        return articleprice;
    }

    public void setArticleprice(String articleprice) {
        this.articleprice = articleprice;
    }

    public String getArticletype() {
        return articletype;
    }

    public void setArticletype(String articletype) {
        this.articletype = articletype;
    }

    @XmlTransient
    public List<Orderarticle> getOrderarticleList() {
        return orderarticleList;
    }

    public void setOrderarticleList(List<Orderarticle> orderarticleList) {
        this.orderarticleList = orderarticleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleid != null ? articleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.articleid == null && other.articleid != null) || (this.articleid != null && !this.articleid.equals(other.articleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Article[ articleid=" + articleid + " ]";
    }
    
}
