/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VueConnexion;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.EntityManagerFactorySingleton;
import modele.dao.DaoVisiteurJPA;

/**
 *
 * @author btssio
 */
public class CtrlConnexion extends CtrlAbstrait{
    public VueConnexion vue;
    public boolean connexion;
    EntityManager em;
    
    public CtrlConnexion(VueConnexion vue, VueAbstrait vueA) {
        super(vueA);
        this.vue = vue;
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
    }
    public void valider(){
        
        // récupération du login et mot de passe pour vérification
        String login = vue.getjTextFieldLogin().getText();
        String mdp = vue.getjPasswordFieldMdp().getText();
        
        //vérification vers la bdd oracle en JPA
        connexion = DaoVisiteurJPA.verifierLoginMdp(em, login, mdp);
        if(connexion){
            
        } else{
            
        }       
    }
    
    public void quitter(){
        
    }
}
