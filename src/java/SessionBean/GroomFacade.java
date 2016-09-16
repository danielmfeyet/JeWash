/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBean;

import Entity.Groom;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Stateless
public class GroomFacade extends AbstractFacade<Groom> {
    @PersistenceContext(unitName = "JeWashPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroomFacade() {
        super(Groom.class);
    }
    
}
