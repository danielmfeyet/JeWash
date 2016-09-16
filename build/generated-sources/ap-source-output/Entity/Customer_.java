package Entity;

import Entity.Address;
import Entity.Paymentaccount;
import Entity.Salesorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-09-16T13:49:44")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> customeremail;
    public static volatile ListAttribute<Customer, Address> addressList;
    public static volatile ListAttribute<Customer, Paymentaccount> paymentaccountList;
    public static volatile SingularAttribute<Customer, String> customerpicture;
    public static volatile SingularAttribute<Customer, Integer> customerid;
    public static volatile SingularAttribute<Customer, String> customerfirstname;
    public static volatile SingularAttribute<Customer, String> customerphone;
    public static volatile SingularAttribute<Customer, String> customerpassword;
    public static volatile SingularAttribute<Customer, String> customerlogin;
    public static volatile SingularAttribute<Customer, String> customername;
    public static volatile ListAttribute<Customer, Salesorder> salesorderList;

}