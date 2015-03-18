/*
 * DaoVisiteurJPA
 */
package modele.dao;

import java.text.*;
import java.util.*;
import javax.persistence.*;
import modele.metier.Visiteur;


public class DaoVisiteurJPA {

    /**
     * selectOne : lire un enregistrement dans la table Visiteur
     * @param em : contexte de persistance
     * @param matricule : identifiant technique
     * @return une instance de la classe Visiteur
     */
    public static Visiteur selectOne(EntityManager em, String matricule) throws PersistenceException {
        Visiteur unVisiteur = null;
        unVisiteur = em.find(Visiteur.class, matricule);
        return unVisiteur;
    }
    
    
    /**
     * selectOneL : lire un enregistrement dans la table Visiteur
     * @param em : contexte de persistance
     * @param login : nom du visiteur
     * @return une instance de la classe Visiteur
     */
    public static Visiteur selectOneByLogin(EntityManager em, String login) throws PersistenceException {
        Visiteur visiteur = null;
        Query query = em.createQuery("select v from Visiteur v where v.nom = :login");
        query.setParameter("login", login);
        visiteur = (Visiteur) query.getSingleResult();
        return visiteur;
    }

    /**
     * selectOneL : lire un enregistrement dans la table Visiteur
     * @param em : contexte de persistance
     * @param nom : nom du visiteur
     * @param prenom : prenom du visiteur
     * @return une instance de la classe Visiteur
     */
    public static Visiteur selectOneByNomPrenom(EntityManager em, String nom, String prenom) throws PersistenceException {
        Visiteur visiteur = null;
        Query query = em.createQuery("select v from Visiteur v where v.nom = :nom and v.prenom = :prenom");
        query.setParameter("nom", nom);
        query.setParameter("prenom", prenom);
        visiteur = (Visiteur) query.getSingleResult();
        return visiteur;
    }
    
    /**
     * lire tous les enregistrements de la table Visiteur
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe visiteur
     */
    public static List<Visiteur> selectAll(EntityManager em) throws PersistenceException {
        List<Visiteur> lesVisiteurs = null;
        Query query= em.createQuery("select v from Visiteur v");
        lesVisiteurs = query.getResultList();
        return lesVisiteurs;
    }
    
    /**
     * Vérifier le login d'un Visiteur
     * @param em : contexte de persistance
     * @param login: nom du visiteur
     * @param mdp: date d'embauche avec format JJ-MMM-AA
     * @return une valeur boolean
     */
    public static boolean verifierLoginMdp(EntityManager em,  String login, String mdp) throws PersistenceException {
        boolean ok=false;
        Visiteur unVisiteur = selectOneByLogin(em, login);
        Format formatter = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        String dateEmbauche = formatter.format(unVisiteur.getDateEmbauche());
        
        if(dateEmbauche.toLowerCase().equals(mdp)){
            ok=true;
        }
        
        return ok;
    }


}
