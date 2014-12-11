/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import modele.dao.DaoVisiteurJPA;
import modele.dao.EntityManagerFactorySingleton;

/**
 *
 * @author btssio
 */
public class testDaoVisiteurJPA {
    public static void main(String[] args) {

        EntityManager em;
        boolean resultat;
        String nomVisiteur;
        String mdpVisiteur;

        System.out.println("\nDEBUT DES TESTS");
        // Instanciation du gestionnaire d'entités (contexte de persistance)
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        // Début de la transaction
        tx.begin();

        nomVisiteur = "swiss";
        mdpVisiteur = "18-jun-2003";
        
        
        System.out.println("\nTest 1-1 - Se connecter sous le login : " + nomVisiteur+" mdp : "+mdpVisiteur);
        resultat = DaoVisiteurJPA.verifierLoginMdp(em, nomVisiteur, mdpVisiteur);
        System.out.println("\tRésultat : " + resultat );
        System.out.println("Test 1-1 effectué");


    }
}
