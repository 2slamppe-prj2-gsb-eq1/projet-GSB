/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoMetier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import modele.metier.Praticien;
import modele.metier.RapportVisite;
import modele.metier.TypePraticien;
import modele.metier.Visiteur;
import modele.dao.*;
import java.util.Date;

/**
 *
 * @author btssio
 */
public class TestRapportVisite {
    Date date;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        TypePraticien unTypePra = new TypePraticien("CC", "test coucou", "local ");
        Praticien unPra = new Praticien(150, "Hugo", "Manu", "adresse", "cp", "ville", Float.parseFloat("45.2"), unTypePra);
        RapportVisite unRapportVisite = new RapportVisite("sdsd9", 1, unPra, null, null, null);

        System.out.println("Offre : " + unRapportVisite);

        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        TypePraticien unTypePraBis = new TypePraticien("bloup", "test ", "international ");
        Praticien unPraBis = new Praticien(25, "drapeau", "bill", "adresse", "cp", "ville", Float.parseFloat("45.2"), unTypePraBis);
        RapportVisite unRapportVisiteBis = new RapportVisite();
        Visiteur unVisiteur;
        unVisiteur = new Visiteur("12" , "Manu", "Hugo", "adresse", "cp", "ville", "date", "S", "code_lab");
        unRapportVisiteBis.setMatricule(unVisiteur);
        unRapportVisiteBis.setNumero_rap(3);
        unRapportVisiteBis.setNumero(unPraBis);
        unRapportVisiteBis.setDate_rap(sdf.parse("20/11/2012"));
        unRapportVisiteBis.setBilan_rap("c'était cool mais pas trop non plus");
        unRapportVisiteBis.setMotif_rap("plus de médoc");

        System.out.println("offre modifiée : " + unRapportVisiteBis);
    }
}
