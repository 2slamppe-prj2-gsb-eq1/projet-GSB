/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;


import javax.persistence.EntityTransaction;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.DaoVisiteurJPA;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class testDaoVisiteurJPA {
    public static void main(String[] args) {
        testVerifierLoginMdp();
        testSelectAll();
    }
    public static void testVerifierLoginMdp(){
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
        System.out.print("\tRésultat : " + resultat );
        System.out.println("Test 1-1 effectué");
    }

    public static void testSelectAll() {
        EntityManager em;
        List<Visiteur> lesVisiteurs;
        int indiceVisiteurCourant;
        Visiteur visiteurCourant;
        
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
        
        // Test 1 - Select All
        lesVisiteurs = DaoVisiteurJPA.selectAll(em);
        System.out.println("\nTest 2-1 - SelectAll :");
        System.out.print("\t" + lesVisiteurs);
        System.out.println("Test 2-1 effectué");
        
        // Test 2 - 1 Visiteur du Select All
        System.out.println("\nTest 2-2 - Affichage du Visiteur d'indice 1 :");
        indiceVisiteurCourant = 1;
        visiteurCourant = lesVisiteurs.get(indiceVisiteurCourant);
        System.out.print("\t" + visiteurCourant);
        System.out.println("Test 2-2 effectué");
    }
}
