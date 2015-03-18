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
import modele.metier.Praticien;

/**
     * selectOne : lire un enregistrement dans la table Praticien
     * @param em : contexte de persistance
     * @param nom : identifiant technique
     * @return une instance de la classe Praticien
     */
public class DaoPraticienJPA {
    
    public static Praticien selectOne(EntityManager em, String nom)throws PersistenceException {
     
        Praticien unPraticien=null;
        unPraticien=em.find(Praticien.class, nom);
        return unPraticien;
        
    }  
    
    
    public static Praticien selectOneByNomPrenom(EntityManager em, String nom, String prenom) throws PersistenceException {
        Praticien praticien = null;
        Query query = em.createQuery("select pra from Praticien pra where pra.nom = :nom and pra.prenom = :prenom");
        query.setParameter("nom", nom);
        query.setParameter("prenom", prenom);
        praticien = (Praticien) query.getSingleResult();
        return praticien;
    }
    
    
      public static Praticien selectOneByID(EntityManager em, String numero) throws PersistenceException {
        Praticien praticien = null;
        Query query = em.createQuery("select pra from Praticien pra where pra.numero = :numero");
        query.setParameter("numero", numero);
        praticien = (Praticien) query.getSingleResult();
        return praticien;
    }
        /**
     * lire tous les enregistrements de la table Praticien
     * selectALL: Lire tous les enregistrements dans la table Praticien
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe Praticien
     */
    
    public static List<Praticien> selectAll(EntityManager em) throws PersistenceException {
        List<Praticien> lesPraticiens = null;
        Query query= em.createQuery("select pra from Praticien pra");
        lesPraticiens = query.getResultList();
        return lesPraticiens;
    }
    
        /**
     * lire tous les enregistrements de la table Praticien
     * selectALL: Lire tous les enregistrements dans la table Praticien
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe Praticien
     */
    
    public static List<Praticien> selectAllOrderPraNum(EntityManager em) throws PersistenceException {
        List<Praticien> lesPraticiens = null;
        Query query= em.createQuery("select pra from Praticien pra order by pra.numero");
        lesPraticiens = query.getResultList();
        return lesPraticiens;
    }
    
    public static Praticien selectNum(EntityManager em, String nom, String prenom) throws PersistenceException {
        Praticien praticien = null;
        Query query = em.createQuery("select pra.numero from Praticien pra where pra.nom = :nom and pra.prenom = :prenom");
        query.setParameter("nom", nom);
        query.setParameter("prenom", prenom);
        praticien = (Praticien) query.getSingleResult();
        return praticien;
    }
    
}
