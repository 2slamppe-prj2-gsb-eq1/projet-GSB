/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoMetier;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class TestTypePraticien {

    public static void main(String[] args) {
        TypePraticien unTypePra = null;
        //Test n°1: instanciation et accesseurs
        System.out.println("\nTest n°1: instanciation et accesseurs");
        unTypePra = new TypePraticien("CC", "test coucou", "local ");
        System.out.println("Etat du TypePraticien: " + unTypePra);

        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : One Piece");
        unTypePra.setCode("PC");
        unTypePra.setLibelle("retest coucou");
        unTypePra.setLieu("Local Jol");
        System.out.println("Etat du type : " + unTypePra);
    }
}
