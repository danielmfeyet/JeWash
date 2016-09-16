package Entity;

import Entity.Customer;
import Entity.Salesorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-09-16T13:49:44")
@StaticMetamodel(Paymentaccount.class)
public class Paymentaccount_ { 

    public static volatile SingularAttribute<Paymentaccount, Customer> customerid;
    public static volatile SingularAttribute<Paymentaccount, String> paymentaccounttype;
    public static volatile SingularAttribute<Paymentaccount, Integer> paymentaccountid;
    public static volatile ListAttribute<Paymentaccount, Salesorder> salesorderList;

}