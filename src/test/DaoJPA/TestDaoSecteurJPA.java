/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.DaoJPA;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.DaoSecteurJPA;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.Secteur;

/**
 *
 * @author btssio
 */
public class TestDaoSecteurJPA {

    public static void main(String[] args) {
        EntityManager em;
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();

        //Test de selectAll
        System.out.println("Test de selectAll : \n");
        List<Secteur> lesSecteurs = new ArrayList<Secteur>();
        lesSecteurs = DaoSecteurJPA.selectAll(em);
        System.out.println("Les secteurs sont : ");
        for (int i = 0; i < lesSecteurs.size(); i++) {
            System.out.println(lesSecteurs.get(i));
        }

        //Test de selectOne
        System.out.println("\nTest du selectOne : \n");
        Secteur unSecteur;
        String sec_code = "E";
        unSecteur = DaoSecteurJPA.selectOne(em, sec_code);
        System.out.println("Le secteur qui a pour sec_code : " + sec_code + " est : \n" + unSecteur);
    }
}
