/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Offrir;

/**
 *
 * @author btssio
 */
public class DaoOffrirJPA {
    
    public static Offrir SelectOne(EntityManager em, String matricule) throws PersistenceException {
        Offrir unOffrir=null;
        unOffrir=em.find(Offrir.class, matricule);
        return unOffrir;
    }
    
    public static List<Offrir> SelectAll(EntityManager em) throws PersistenceException {
        List<Offrir> desOffrirs=null;
        Query query = em.createQuery("select v from Offrir v");
        desOffrirs=query.getResultList();
        return desOffrirs;
    }
}
