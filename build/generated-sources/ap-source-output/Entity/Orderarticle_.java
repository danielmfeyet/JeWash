package Entity;

import Entity.Article;
import Entity.OrderarticlePK;
import Entity.Salesorder;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-09-16T13:49:44")
@StaticMetamodel(Orderarticle.class)
public class Orderarticle_ { 

    public static volatile SingularAttribute<Orderarticle, Article> article;
    public static volatile SingularAttribute<Orderarticle, OrderarticlePK> orderarticlePK;
    public static volatile SingularAttribute<Orderarticle, BigInteger> quantity;
    public static volatile SingularAttribute<Orderarticle, Salesorder> salesorder;

}