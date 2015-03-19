/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoJPA;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.DaoOffrirJPA;
import modele.dao.DaoPraticienJPA;
import modele.dao.DaoRapportVisiteJPA;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.Offrir;

/**
 *
 * @author btssio
 */
public class TestDaoOffrirJPA {

    public static void main(String[] args) {
        EntityManager em;
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();

        //Test de selectAll
        System.out.println("Test de selectAll : \n");
        List<Offrir> lesOffres = new ArrayList<Offrir>();
        lesOffres = DaoOffrirJPA.SelectAll(em);
        System.out.println("Les Offres sont : ");
        for (int i = 0; i < lesOffres.size(); i++) {
            System.out.println(lesOffres.get(i));
        }

        //Test de selectOne
        System.out.println("\nTest du selectOne : \n");
        Offrir unPra;
        String vis_matricule = "a17";
        int rap_num = 4;
        String med_depotLegal = "3MYC7";

        unPra = DaoOffrirJPA.SelectOne(em, vis_matricule, rap_num, med_depotLegal);
        System.out.println("Le type praticien qui a pour typeCode : " + rap_num + " est : \n" + unPra);
    }
}
