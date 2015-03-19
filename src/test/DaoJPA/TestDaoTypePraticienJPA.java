/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoJPA;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.DaoTypePraticienJPA;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.TypePraticien;

/**
 *
 * @author btssio
 */
public class TestDaoTypePraticienJPA {

    public static void main(String[] args) {
        EntityManager em;
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();

        //Test de selectAll
        System.out.println("Test de selectAll : \n");
        List<TypePraticien> lesTypePra = new ArrayList<TypePraticien>();
        lesTypePra = DaoTypePraticienJPA.selectAll(em);
        System.out.println("Les Types praticiens sont : ");
        for (int i = 0; i < lesTypePra.size(); i++) {
            System.out.println(lesTypePra.get(i));
        }

        //Test de selectOne
        System.out.println("\nTest du selectOne : \n");
        TypePraticien unTypePra;
        String typeCode = "MV";
        unTypePra = DaoTypePraticienJPA.selectOne(em, typeCode);
        System.out.println("Le type praticien qui a pour typeCode : " + typeCode + " est : \n" + unTypePra);
    }
}
