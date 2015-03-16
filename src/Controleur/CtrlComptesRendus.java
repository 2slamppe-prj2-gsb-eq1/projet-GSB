/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VueComptesRendus;
import javax.persistence.EntityManager;
import modele.dao.EntityManagerFactorySingleton;

/**
 *
 * @author btssio
 */
public class CtrlComptesRendus extends CtrlAbstrait {
    private VueComptesRendus vue;
    EntityManager em;
    
    public CtrlComptesRendus(VueComptesRendus vueCR, VueAbstrait vueA) {
        super(vueA);
        this.vue = vueCR;
        this.vue.setCtrl(this);
        
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
    }

    public void actualiser() {
        
    }
    
    public void nouveauRapport(){
        this.vue.getjButtonNew().setVisible(false);
    }
    
    public void close(){
        this.vue.setVisible(false);
    }

    public VueComptesRendus getVue() {
        return vue;
    }

    public void setVue(VueComptesRendus vue) {
        this.vue = vue;
    }
    
}
