/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managed;

import Entity.Customer;
import Entity.MD5;
import SessionBean.CustomerFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MFEYET Daniel Steven
 */
@ManagedBean
@RequestScoped
public class login implements Serializable {
    @EJB
    private CustomerFacade customerFacade;

     public List<Customer> listcustomer; 
     
    private Customer c;

    public CustomerFacade getCustomerFacade() {
        return customerFacade;
    }

    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }
    
   public String saveUser(){
        listcustomer=customerFacade.findAll();
String pageCon= null;
        boolean loggedIn=false;
        boolean statut = false;
    for(Customer cu:listcustomer){
        if(cu.getCustomeremail().equals(c.getCustomeremail()) && cu.getCustomerpassword().equals(c.getCustomerpassword())){
             HttpSession hs= Util.getSession();
             
              
               hs.setAttribute("customer",cu);
             
               pageCon="Order.xhtml";
        }
    }       
      if(pageCon==null){
           FacesMessage fm = new FacesMessage("Parametre de connexion incorecte,");
              fm.setSeverity(FacesMessage.SEVERITY_ERROR);
              FacesContext.getCurrentInstance().addMessage(null, fm);
                pageCon="index.xhtml";
      }  
      return pageCon;
    }
    /**
     * Creates a new instance of adduser
     */
    public login() {
        this.c= new Customer();
    }
    
}
