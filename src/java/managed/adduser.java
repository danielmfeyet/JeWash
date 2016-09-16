/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managed;

import Entity.Customer;
import SessionBean.CustomerFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author MFEYET Daniel Steven
 */
@ManagedBean
@RequestScoped
public class adduser {
    
  
    
    @EJB
    private CustomerFacade customerFacade;
    
    

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
    public void savecustomer(){
        
    String res="";
    boolean v=false;
       List<Customer> listCust=customerFacade.findAll();
       for(Customer f:listCust){
           if(f.getCustomeremail().equals(c.getCustomeremail())){
               v=true;
               res="Email deja Occupé";
           }else if(f.getCustomerpassword().equals(c.getCustomerpassword())){
               v=true;
               res="Mot de passe no disponible";
           }else if(f.getCustomerphone().equals(c.getCustomerphone())){
               v=true;
               res="Numero deja Present dans Notre Base donnée";
           }
       }
       if(v==false){
           customerFacade.create(c);
           FacesMessage fm = new FacesMessage("Client Enregistrer, un mail vous a été envoyé");
              fm.setSeverity(FacesMessage.SEVERITY_INFO);
              FacesContext.getCurrentInstance().addMessage(null, fm);
       }else{
           FacesMessage fm = new FacesMessage("Enregistrement impossible:"+res);
              fm.setSeverity(FacesMessage.SEVERITY_INFO);
              FacesContext.getCurrentInstance().addMessage(null, fm); 
       }
        this.c= new Customer();
        //envoie mail
        // verificat
    }
    
    /**
     * Creates a new instance of adduser
     */
    public adduser() {
        this.c= new Customer();
    }
    
}
