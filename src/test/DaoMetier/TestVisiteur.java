/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoMetier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import modele.metier.Labo;
import modele.metier.Secteur;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class TestVisiteur {

    public static void main(String[] args) throws ParseException {
        Visiteur vis = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        Labo lab = new Labo("GY", "Gyverni", "Merss Suzanne");
        Secteur sec = new Secteur("N", "Nord");
        vis = new Visiteur("b52", "Poilu", "Gérard", "65 rue du Bourg", "44000", "Nantes", sdf.parse("20/11/2012"), sec, lab);
        System.out.println("Etat du visiteur: " + vis.toString());

        // Test n°2 : wan piece
        System.out.println("\nTest n°2 : wan piece");
        vis.setMatricule("cb03");
        vis.setNom("Gelbro");
        vis.setPrenom("Arthur");
        vis.setAdresse("26 rue de la Liberté");
        vis.setCp("44200");
        vis.setVille("Nantes");
        lab = new Labo("LB", "LaboFrance", "FRANCE");
        sec = new Secteur("S", "Sud");
        vis.setCode_sec(sec);
        vis.setCode_lab(lab);
        System.out.println("Etat du visiteur : " + vis.toString());
    }
}
