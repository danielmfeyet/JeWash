package Entity;

import Entity.Customer;
import Entity.Salesorder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2016-09-16T13:49:44")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Boolean> addressactif;
    public static volatile SingularAttribute<Address, Integer> addressid;
    public static volatile SingularAttribute<Address, Customer> customerid;
    public static volatile ListAttribute<Address, Salesorder> salesorderList1;
    public static volatile SingularAttribute<Address, String> addressname;
    public static volatile SingularAttribute<Address, String> addresscity;
    public static volatile SingularAttribute<Address, String> addressdetail;
    public static volatile SingularAttribute<Address, String> addressneighborhood;
    public static volatile ListAttribute<Address, Salesorder> salesorderList;

}