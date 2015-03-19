/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoMetier;


import modele.metier.Labo;
import modele.metier.Medicament;

/**
 *
 * @author btssio
 */
public class TestMedicament {

    public static void main(String[] args) {
        Medicament medicament = null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        medicament = new Medicament("TES", "TUESPORAL", "HO+CH+FG", "douleur", "Non", "3.00");
        System.out.println("Etat du medicament: " + medicament);

        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        medicament.setDepotlegal("XD");
        medicament.setNomcommercial("Bichiot");
        medicament.setComposition("LO");
        medicament.setEffets("DOULEUR");
        medicament.setContrindic("OUI");
        System.out.println("Etat du medicament: " + medicament);
    }
}