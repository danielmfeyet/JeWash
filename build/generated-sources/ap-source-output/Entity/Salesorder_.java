package Entity;

import Entity.Address;
import Entity.Customer;
import Entity.Groom;
import Entity.Orderarticle;
import Entity.Paymentaccount;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-09-16T13:49:44")
@StaticMetamodel(Salesorder.class)
public class Salesorder_ { 

    public static volatile SingularAttribute<Salesorder, BigInteger> ordertotalamount;
    public static volatile SingularAttribute<Salesorder, Date> orderdatecollect;
    public static volatile SingularAttribute<Salesorder, Customer> customerid;
    public static volatile SingularAttribute<Salesorder, Address> addressid;
    public static volatile ListAttribute<Salesorder, Orderarticle> orderarticleList;
    public static volatile SingularAttribute<Salesorder, String> collecthour;
    public static volatile SingularAttribute<Salesorder, Groom> idagent;
    public static volatile SingularAttribute<Salesorder, Address> addAddressid;
    public static volatile SingularAttribute<Salesorder, String> deliveryhour;
    public static volatile SingularAttribute<Salesorder, Paymentaccount> paymentaccountid;
    public static volatile SingularAttribute<Salesorder, Integer> orderid;
    public static volatile SingularAttribute<Salesorder, Date> orderdatedelivery;

}