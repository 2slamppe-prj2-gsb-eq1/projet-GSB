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
 *
 * @author btssio
 */
public class DaoPraticien {
    
    public static Praticien selectOne(EntityManager em, int numero)throws PersistenceException {
     
        Praticien unPraticien=null;
        unPraticien=em.find(Praticien.class, numero);
        return unPraticien;
        
    }  
    
        /**
     * lire tous les enregistrements de la table Visiteur
     *
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe visiteur
     */
    
    public static List<Praticien> selectAll(EntityManager em) throws PersistenceException {
        List<Praticien> lesPraticiens = null;
        Query query= em.createQuery("select v from Praticien v");
        lesPraticiens = query.getResultList();
        return lesPraticiens;
    }
    
    
}
