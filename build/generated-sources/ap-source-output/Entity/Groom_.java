package Entity;

import Entity.Salesorder;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-09-16T13:49:44")
@StaticMetamodel(Groom.class)
public class Groom_ { 

    public static volatile SingularAttribute<Groom, String> groompassword;
    public static volatile SingularAttribute<Groom, BigInteger> groomphone;
    public static volatile SingularAttribute<Groom, String> groompicture;
    public static volatile SingularAttribute<Groom, Integer> idagent;
    public static volatile SingularAttribute<Groom, String> groomfirstname;
    public static volatile SingularAttribute<Groom, String> groomname;
    public static volatile SingularAttribute<Groom, String> groomemail;
    public static volatile SingularAttribute<Groom, String> groomlogin;
    public static volatile ListAttribute<Groom, Salesorder> salesorderList;

}