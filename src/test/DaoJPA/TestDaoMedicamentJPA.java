/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoJPA;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.DaoMedicamentJPA;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.Medicament;

/**
 *
 * @author btssio
 */
public class TestDaoMedicamentJPA {

    public static void main(String[] args) {
        EntityManager em;
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();

        //Test de selectAll
        System.out.println("Test de selectAll : \n");
        List<Medicament> lesMedicaments = new ArrayList<Medicament>();
        lesMedicaments = DaoMedicamentJPA.selectAll(em);
        System.out.println("Les medicaments sont : ");
        for (int i = 0; i < lesMedicaments.size(); i++) {
            System.out.println(lesMedicaments.get(i));
        }

        //Test de selectOne
        System.out.println("\nTest du selectOne : \n");
        Medicament unMedicament;
        String depotLegal = "3MYC7";
        unMedicament = DaoMedicamentJPA.selectOnebyID(em, depotLegal);
        System.out.println("Le medicament qui a pour depotLegal : " + depotLegal + " est : \n" + unMedicament);
    }
}