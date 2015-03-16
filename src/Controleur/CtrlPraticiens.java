/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VuePraticiens;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modele.dao.DaoPraticienJPA;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.Praticien;

/**
 *
 * @author btssio
 */
public class CtrlPraticiens extends CtrlAbstrait {
    private VuePraticiens vue;
    private List<Praticien> lesPraticiens;
    private int indicePraticienCourant;
    private Praticien praticienCourant;
    EntityManager em;
    
    public CtrlPraticiens(VuePraticiens vueCR, VueAbstrait vueA) {
        super(vueA);
        this.vue = vueCR;
        this.vue.setCtrl(this);
        
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
        
        //préparation des combos box
        lesPraticiens = DaoPraticienJPA.selectAll(em);
        remplissageComboBox(lesPraticiens);
        
        
        
        //préparation de l'état initial de l'affichage
        indicePraticienCourant = 0;
        praticienCourant = lesPraticiens.get(indicePraticienCourant);
        afficherPraticien(praticienCourant);
        }

    public final void actualiser() {
        try {
            remplissageComboBox(lesPraticiens);
            indicePraticienCourant = 0;
            praticienCourant = lesPraticiens.get(indicePraticienCourant);
            afficherPraticien(praticienCourant);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlPresence - actualiser - " + ex.getMessage(), "Saisie des présences", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void chercher(){
       String nom= (String) this.vue.getjComboBoxSearch().getSelectedItem();
       String [] libelle = nom.split(" ", 0);
        Praticien unPraticien = DaoPraticienJPA.selectOneByNomPrenom(em, libelle[0], libelle[1]);
        afficherPraticien(unPraticien);
    }
    
    
    
    public void suivant(){
        Praticien lePraticien = null;
        for(int i = 0; i<lesPraticiens.size(); i++){
            Praticien unPraticien = lesPraticiens.get(i);
            if(unPraticien.getNom().equals(this.vue.getjTextFieldNom().getText()) && lePraticien.getPrenom().equals(this.vue.getjTextFieldPrenom().getText())){
               if(i == lesPraticiens.size()-1){
                    lePraticien = lesPraticiens.get(0);
                } else{
                    lePraticien = lesPraticiens.get(i+1);
                }
            }
        }
     }
    
    
     public void precedent(){
        Praticien lePraticien = null;
        for(int i = 0; i<lesPraticiens.size(); i++){
            Praticien unPraticien = lesPraticiens.get(i);
            if(unPraticien.getNom().equals(this.vue.getjTextFieldNom().getText()) && lePraticien.getPrenom().equals(this.vue.getjTextFieldPrenom().getText())){
                if(i == 0){
                    lePraticien = lesPraticiens.get(lesPraticiens.size()-1);
                } else{
                    lePraticien = lesPraticiens.get(i-1);
                }
            }
        }
     }
        
      /**
     *
     * @param lesPraticiens
     */
    public void remplissageComboBox(List<Praticien>lesPraticiens /*LieuExercice*/){
        this.vue.getjComboBoxSearch().addItem("");
        for(int i = 0; i<lesPraticiens.size(); i++){
            Praticien unPraticien = lesPraticiens.get(i);
            this.vue.getjComboBoxSearch().addItem(unPraticien.getNom() + " " + unPraticien.getPrenom());
        }
       
    }
    
    public void afficherPraticien(Praticien unPraticien){ /*Lieu exercice a ajouter */
        this.vue.getjTextFieldNom().setText(unPraticien.getNom());
        this.vue.getjTextFieldPrenom().setText(unPraticien.getPrenom());
        this.vue.getjTextFieldAdresse().setText(unPraticien.getAdresse());
        
        
    } 
       
    public void close(){
        this.vue.setVisible(false);
    }

    public VuePraticiens getVue() {
        return vue;
    }

    public void setVue(VuePraticiens vue) {
        this.vue = vue;
    }
}
