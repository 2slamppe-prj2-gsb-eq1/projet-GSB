/*
 * DaoVisiteurJPA
 */
package modele.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Visiteur;


public class DaoVisiteurJPA {

    /**
     * selectOne : lire un enregistrement dans la table Visiteur
     *
     * @param em : contexte de persistance
     * @param matricule : identifiant technique
     * @return une instance de la classe Visiteur
     */
    public static Visiteur selectOne(EntityManager em, Long matricule) throws PersistenceException {
        Visiteur unVisiteur = null;
        unVisiteur = em.find(Visiteur.class, matricule);
        return unVisiteur;
    }
    

    /**
     * lire tous les enregistrements de la table Visiteur
     *
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe visiteur
     */
    public static List<Visiteur> selectAll(EntityManager em) throws PersistenceException {
        List<Visiteur> lesVisiteurs = null;
        Query query= em.createQuery("select v from Visiteur v");
        lesVisiteurs = query.getResultList();
        return lesVisiteurs;
    }


}
