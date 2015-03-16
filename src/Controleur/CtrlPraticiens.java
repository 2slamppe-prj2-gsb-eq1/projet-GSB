/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VuePraticiens;
import javax.persistence.EntityManager;
import modele.dao.EntityManagerFactorySingleton;

/**
 *
 * @author btssio
 */
public class CtrlPraticiens extends CtrlAbstrait {
    private VuePraticiens vue;
    EntityManager em;
    
    public CtrlPraticiens(VuePraticiens vueCR, VueAbstrait vueA) {
        super(vueA);
        this.vue = vueCR;
        this.vue.setCtrl(this);
        
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
    }

    public void actualiser() {
        
    }

    public VuePraticiens getVue() {
        return vue;
    }

    public void setVue(VuePraticiens vue) {
        this.vue = vue;
    }
}
