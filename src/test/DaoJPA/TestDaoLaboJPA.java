/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoJPA;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.DaoLaboJPA;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.Labo;

/**
 *
 * @author btssio
 */
public class TestDaoLaboJPA {

    public static void main(String[] args) {
        EntityManager em;
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();

        //Test de selectAll
        System.out.println("Test de selectAll : \n");
        List<Labo> lesLabos = new ArrayList<Labo>();
        lesLabos = DaoLaboJPA.selectAll(em);
        System.out.println("Les labos sont : ");
        for (int i = 0; i < lesLabos.size(); i++) {
            System.out.println(lesLabos.get(i));
        }

        //Test de selectOne
        System.out.println("\nTest du selectOne : \n");
        Labo unLabo;
        String lab_code = "BC";
        unLabo = DaoLaboJPA.selectOne(em, lab_code);
        System.out.println("Le labo qui a pour lab_code : " + lab_code + " est : \n" + unLabo);
    }
}
