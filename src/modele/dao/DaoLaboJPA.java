/*
 * DaoLaboJPA
 */
package modele.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Labo;

public class DaoLaboJPA {

    /**
     * selectOne : lire un enregistrement dans la table Labo
     *
     * @param em : contexte de persistance
     * @param code : identifiant technique
     * @return une instance de la classe Labo
     */
    public static Labo selectOne(EntityManager em, Long code) throws PersistenceException {
        Labo unLabo = null;
        // A COMPLETER
        unLabo = em.find(Labo.class, code);
        return unLabo;
    }
    
 
    public static List<Labo> selectAll(EntityManager em) throws PersistenceException {
        List<Labo> lesLabos = null;
        Query query= em.createQuery("select l from Labo l");
        lesLabos = query.getResultList();
       // A COMPLETER
        return lesLabos;
    }
}
    
   



