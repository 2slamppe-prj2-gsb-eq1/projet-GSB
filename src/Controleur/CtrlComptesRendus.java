/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VueComptesRendus;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.*;
import modele.dao.*;

/**
 *
 * @author btssio
 */
public class CtrlComptesRendus extends CtrlAbstrait {
    private VueComptesRendus vue;
    EntityManager em;
    private List<RapportVisite> lesRapportsVisites;
    private List<Praticien> lesPraticiens;
    private Visiteur leVisiteur;
    private String loginVisiteur;
    
    public CtrlComptesRendus(VueComptesRendus vueCR, VueAbstrait vueA) {
        super(vueA);
        this.vue = vueCR;
        this.vue.setCtrl(this);
        
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
        
        // récupération des praticiens pour l'affichage dans la combobox praticien
        lesPraticiens = DaoPraticienJPA.selectAll(em);
        
        // ajout d'un item vide dans la combobox praticien
        this.vue.getjComboBoxPracticien().addItem("");
        
        // boucle pour placer tous les praticiens dans la combobox praticien
        for(int i = 0; i<lesPraticiens.size(); i++){
            Praticien lePraticien = lesPraticiens.get(i);
            // ajout du nom et du prénom du praticien dans la combobox praticien
            this.vue.getjComboBoxPracticien().addItem(lePraticien.getNom() + " " + lePraticien.getPrenom());
        }
        
        // récupération du login du visiteur
        // System.out.println(loginVisiteur);
        //leVisiteur = DaoVisiteurJPA.selectOneByLogin(em, loginVisiteur);
        leVisiteur = DaoVisiteurJPA.selectOneByLogin(em, "swiss");
        // récupération des rapports visites
        lesRapportsVisites = DaoRapportVisiteJPA.selectOneByVisiteur(em, leVisiteur);
        System.out.println(lesRapportsVisites);
        
        // Ne pas afficher le bouton sauvegarder
        this.vue.getjButtonSauvegarder().setVisible(false);
    }

    public void actualiser() {
        
    }
    
    public void nouveauRapport(){
        this.vue.getjButtonSauvegarder().setVisible(true);
    }
    
    public void sauvegarderRapport(){
        this.vue.getjButtonSauvegarder().setVisible(false);
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
