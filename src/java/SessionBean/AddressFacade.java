/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import Entity.Address;
import Entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address> {
    @PersistenceContext(unitName = "JeWashPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }
    public List<Address> getAllAddressbyCustomer(Customer f){
        
       Query query = em.createNamedQuery("Address.findBycustomerid");
        query.setParameter("customerid",f);
        query.setParameter("addressactif",Boolean.TRUE);
        return query.getResultList();
        
    }
    public Address getAddressbyId(Integer id){
      Query query = em.createNamedQuery("Address.findByAddressid");
        
         query.setParameter("addressid",id);
         
        
        return (Address) query.getSingleResult();
        
    }
}
