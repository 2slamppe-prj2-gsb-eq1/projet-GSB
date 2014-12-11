/*
 * DaoSecteurJpa

 */
package modele.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Secteur;

public class DaoSecteurJPA {

    /**
     * selectOne : lire un enregistrement dans la table Secteur
     *
     * @param em : contexte de persistance
     * @param code : identifiant technique
     * @return une instance de la classe Secteur
     */
    public static Secteur selectOne(EntityManager em, Long code) throws PersistenceException {
        Secteur unSecteur = null;
        unSecteur = em.find(Secteur.class, code);
        return unSecteur;
    }
    
  

    /**
     * lire tous les enregistrements de la table Secteur
     *
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe Secteur
     */
    public static List<Secteur> selectAll(EntityManager em) throws PersistenceException {
        List<Secteur> lesSecteurs = null;
        Query query= em.createQuery("select s from Secteur s");
        lesSecteurs = query.getResultList();
        return lesSecteurs;
    }
    
}


