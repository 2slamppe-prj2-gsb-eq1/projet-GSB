/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoMetier;

import modele.metier.Praticien;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class TestPraticien {

    public static void main(String[] args) {
        Praticien unPra = null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        TypePraticien unTypePra = new TypePraticien("CC", "test coucou", "local ");
        unPra = new Praticien(150, "Hugo", "Manu", "adresse", "cp", "ville", Float.parseFloat("45.2"), unTypePra);
        System.out.println("Etat du Praticien: " + unPra.toString());

        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        unPra.setNumero("20");
        unPra.setNom("Arthur");
        unPra.setPrenom("Gueno");
        unPra.setAdresse("adr2");
        unPra.setCp("cp2");
        unPra.setVille("ville2");
        unPra.setcoef(Float.parseFloat("50"));
        TypePraticien unTypePra2 = new TypePraticien("PC", "test pas coucou", "Local Jol");
        unPra.setTypePraticien(unTypePra2);
        System.out.println("Etat du type : " + unPra.toString());
    }
}