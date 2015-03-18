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
     * selectOne : lire un enregistrement dans la table Offrir
     * selectALL: Lire tous les enregistrements dans la table Offrir
     * @param em : contexte de persistance
     * @param vis_matricule : identifiant technique
     * @return une instance de la classe Offrir
     */
public class DaoOffrirJPA {
    
    public static Offrir SelectOne(EntityManager em, String vis_matricule) throws PersistenceException {
        Offrir unOffrir=null;
        unOffrir=em.find(Offrir.class, vis_matricule);
        return unOffrir;
    }
    
    public static List<Offrir> SelectAll(EntityManager em) throws PersistenceException {
        List<Offrir> desOffrirs=null;
        Query query = em.createQuery("select v from Offrir v");
        desOffrirs=query.getResultList();
        return desOffrirs;
    }
    
    public static List<Offrir> selectOneByRapNum(EntityManager em, int rap_num) throws PersistenceException {
        List<Offrir> desOffrirs=null;
        Query query = em.createQuery("select v from Offrir v where v.rap_num = :rap_num ");
        query.setParameter("rap_num", rap_num);
        desOffrirs=query.getResultList();
        return desOffrirs;
    }
}
