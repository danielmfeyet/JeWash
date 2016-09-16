/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import Entity.Salesorder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Stateless
public class SalesorderFacade extends AbstractFacade<Salesorder> {
    @PersistenceContext(unitName = "JeWashPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalesorderFacade() {
        super(Salesorder.class);
    }
    
}
