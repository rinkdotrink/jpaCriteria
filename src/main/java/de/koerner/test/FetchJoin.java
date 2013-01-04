/*
 * (c) Bernd Müller & Harald Wehr, www.jpainfo.de
 */

package de.koerner.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.koerner.model.Kunde;

public class FetchJoin {

    public static void main(String[] args) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "bank");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Kunde> query = cb.createQuery(Kunde.class);
        
        Root<Kunde> kunde = query.from(Kunde.class);
        kunde.fetch(Kunde_.wohnort);
        
        query.select(kunde);
   
        Query q = em.createQuery(query); 
        List<Object[]> result = q.getResultList();
        
        OutputHelper.outputList(result);

        em.close();
        emf.close();
    }
    
 
}
