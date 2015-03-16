/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VuePraticiens;
import javax.persistence.EntityManager;
import modele.dao.DaoPraticienJPA;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.Praticien;

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

    public final void actualiser() {
        
    }
    public void chercher(){
       String nom= (String) this.vue.getjComboBoxSearch().getSelectedItem();
       String [] libelle = nom.split(" ", 0);
        Praticien unPraticien = DaoPraticienJPA.selectOneByNomPrenom(em, libelle[0], libelle[1]);
        afficherPraticien(unPraticien);
    }
     public void precedent(){
        Praticien lePraticien = null;
        for(int i = 0; i<lesPraticiens.size(); i++){
            Praticien unPraticien = lesPraticiens.get(i);
            if(unPraticien.getNom().equals(this.vue.getjTextFieldNom().getText()) && unPatricien.getPrenom().equals(this.vue.getjTextFieldPrenom().getText())){
                if(i == 0){
                    lePraticien = lesPraticiens.get(lesPraticiens.size()-1);
                } else{
                    lePraticien = lesPraticiens.get(i-1);
                }
            }
        }
  

    public VuePraticiens getVue() {
        return vue;
    }

    public void setVue(VuePraticiens vue) {
        this.vue = vue;
    }
}
