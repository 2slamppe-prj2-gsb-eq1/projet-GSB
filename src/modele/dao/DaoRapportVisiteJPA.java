/*
 * DaoSecteurJpa

 */
package modele.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.RapportVisite;
import modele.metier.Visiteur;

public class DaoRapportVisiteJPA {

    /**
     * selectOne : lire un enregistrement dans la table RapportVisite
     * @param em : contexte de persistance
     * @param matricule : identifiant technique
     * @return une instance de la classe RapportVisite
     */
    public static RapportVisite selectOnebyID(EntityManager em, String matricule) throws PersistenceException {
        RapportVisite unRapportVisite = null;
        unRapportVisite = em.find(RapportVisite.class, matricule);
        return unRapportVisite;
    }
    
  

    /**
     * lire tous les enregistrements de la table RapportVisite
     * selectAll: lire tous les enregistrements dans la table RapportVisite
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe RapportVisite
     */
    public static List<RapportVisite> selectAll(EntityManager em) throws PersistenceException {
        List<RapportVisite> lesRapportVisites = null;
        Query query= em.createQuery("select rv from RapportVisite rv");
        lesRapportVisites = query.getResultList();
        return lesRapportVisites;
    }
    
    /**
     * lire tous les enregistrements de la table RapportVisite en fonction du Visiteur
     *
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe Secteur
     */
    public static List<RapportVisite> selectOneByVisiteur(EntityManager em, Visiteur leVisiteur) throws PersistenceException {
        List<RapportVisite> lesRapportVisites = null;
        Query query= em.createQuery("select rv from RapportVisite rv where rv.matricule = :matricule");
        query.setParameter("matricule", leVisiteur);
        lesRapportVisites = query.getResultList();
        return lesRapportVisites;
    }
    
}
