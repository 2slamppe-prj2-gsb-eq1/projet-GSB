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
     * @param numero : identifiant technique
     * @return une instance de la classe Praticien
     */
public class DaoPraticienJPA {
    
    public static Praticien selectOne(EntityManager em, int numero)throws PersistenceException {
     
        Praticien unPraticien=null;
        unPraticien=em.find(Praticien.class, numero);
        return unPraticien;
        
    }  
    
        /**
     * lire tous les enregistrements de la table Praticien
     * selectALL: Lire tous les enregistrements dans la table Praticien
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe Praticien
     */
    
    public static List<Praticien> selectAll(EntityManager em) throws PersistenceException {
        List<Praticien> lesPraticiens = null;
        Query query= em.createQuery("select v from Praticien v");
        lesPraticiens = query.getResultList();
        return lesPraticiens;
    }
    
    
}
