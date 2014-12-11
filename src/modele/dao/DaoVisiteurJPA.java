/*
 * DaoClientJPA
 * @author nbourgeois
 * @version 08/11/2014
 */
package modele.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Visiteur;


public class DaoVisiteurJPA {

    /**
     * selectOne : lire un enregistrement dans la table CLIENT
     *
     * @param em : contexte de persistance
     * @param matricule : identifiant technique
     * @return une instance de la classe Client
     */
    public static Visiteur selectOne(EntityManager em, Long matricule) throws PersistenceException {
        Visiteur unVisiteur = null;
        unVisiteur = em.find(Visiteur.class, matricule);
        return unVisiteur;
    }
    

    /**
     * lire tous les enregistrements de la table CLIENT
     *
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe Client
     */
    public static List<Visiteur> selectAll(EntityManager em) throws PersistenceException {
        List<Visiteur> lesVisiteurs = null;
        Query query= em.createQuery("select c from Visiteur c");
        lesVisiteurs = query.getResultList();
        return lesVisiteurs;
    }


}
