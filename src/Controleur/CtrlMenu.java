/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VueMenu;
import javax.persistence.EntityManager;
import modele.dao.DaoVisiteurJPA;
import modele.dao.EntityManagerFactorySingleton;

/**
 *
 * @author btssio
 */
public class CtrlMenu extends CtrlAbstrait{
    public VueMenu vue;
    public boolean connexion;
    EntityManager em;
    
    public CtrlMenu(VueMenu vue, VueAbstrait vueA) {
        super(vueA);
        this.vue = vue;
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
    }
    
    public void afficherVisiteur(){
        CtrlPrincipal ctrlP = new CtrlPrincipal();
        ctrlP.action(EnumAction.VISITEUR_AFFICHER);
        
        // Supprime l'affichage de la vue Menu
        // this.getVue().setVisible(false);
    }
    
    public void close(){
        this.vue.setVisible(false);
    }

    public VueMenu getVue() {
        return vue;
    }

    public void setVue(VueMenu vue) {
        this.vue = vue;
    }
    
    public void afficherComptesRendus(){
        CtrlPrincipal ctrlP = new CtrlPrincipal();
        ctrlP.action(EnumAction.COMPTESRENDUS_AFFICHER); 
    }
    
}
