package Entity;

import Entity.Orderarticle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-09-16T13:49:44")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile SingularAttribute<Article, Integer> articleid;
    public static volatile SingularAttribute<Article, String> articleentitled;
    public static volatile ListAttribute<Article, Orderarticle> orderarticleList;
    public static volatile SingularAttribute<Article, String> articleprice;
    public static volatile SingularAttribute<Article, String> articletype;

}