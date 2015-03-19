/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoMetier;

import modele.dao.DaoVisiteurJPA;
import modele.metier.Offrir;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class TestOffrir {

    public static void main(String[] args) {
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        Offrir uneOffre = new Offrir("CC", 4, "test coucou", 0);
        uneOffre = new Offrir("zzz", 11, "3MYC7", 85);
        System.out.println("Offre : " + uneOffre);

        // Test n°2 : Onepiece
        System.out.println("\nTest n°2 : One PIece");

        uneOffre.setMatricule("Nami");
        uneOffre.setNumero_rap("3");
        uneOffre.setDepotlegal("OUI");
        uneOffre.setQuantite(3);
        Offrir uneOffreBis = new Offrir("a117", 2, "ftuy54", 6);
        System.out.println("offre modifiée : " + uneOffreBis);
    }
}