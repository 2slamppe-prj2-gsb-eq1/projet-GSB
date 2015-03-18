/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VueComptesRendus;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.*;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.*;

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
    private int indiceRapportVisiteCourant;
    private RapportVisite leRapportViste;
    
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
        this.vue.getjComboBoxPraticien().addItem("");
        
        // boucle pour placer tous les praticiens dans la combobox praticien
        for(int i = 0; i<lesPraticiens.size(); i++){
            Praticien lePraticien = lesPraticiens.get(i);
            // ajout du nom et du prénom du praticien dans la combobox praticien
            this.vue.getjComboBoxPraticien().addItem(lePraticien.getNom() + " " + lePraticien.getPrenom());
        }
        
        // récupération du login du visiteur
        // leVisiteur = DaoVisiteurJPA.selectOneByLogin(em, loginVisiteur);
        
        // récupération des rapports visites
        // lesRapportsVisites = DaoRapportVisiteJPA.selectOneByVisiteur(em, leVisiteur);
        lesRapportsVisites = DaoRapportVisiteJPA.selectAll(em);
        
        indiceRapportVisiteCourant = 0;
        leRapportViste = lesRapportsVisites.get(indiceRapportVisiteCourant);
        afficherCompteRendu(leRapportViste);
        
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
    
    public void afficherCompteRendu(RapportVisite leRapportViste){
        this.vue.getjTextFieldNumRapport().setText(leRapportViste.getNumero_rap()+"");
        this.vue.getjComboBoxPraticien().setSelectedItem(leRapportViste.getNumero().getNom()+" "+leRapportViste.getNumero().getPrenom());
        
        // on crée l'objet en passant en paramétre une chaîne representant le format 
        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy" ); 
        //on crée la chaîne à partir de la date  
        String dateString = formatter.format(leRapportViste.getDate_rap());
        
        this.vue.getjTextFieldDateRapport().setText(dateString);
        
        this.vue.getjTextFieldMotifVis().setText(leRapportViste.getMotif_rap());
        this.vue.getjTextAreaBilan().setText(leRapportViste.getBilan_rap());
    }
    
    public void suivant(){
        if (indiceRapportVisiteCourant == lesRapportsVisites.size()-1) {
            indiceRapportVisiteCourant = 0;
        } else {
            indiceRapportVisiteCourant = indiceRapportVisiteCourant + 1;
        }
        afficherCompteRendu(lesRapportsVisites.get(indiceRapportVisiteCourant));
    }
    
    public void precedent(){
        if (indiceRapportVisiteCourant == 0) {
            indiceRapportVisiteCourant = lesRapportsVisites.size()-1;
        } else {
            indiceRapportVisiteCourant = indiceRapportVisiteCourant - 1;
        }
        afficherCompteRendu(lesRapportsVisites.get(indiceRapportVisiteCourant));
    }
    
    public void DetailsPraticien(){
        CtrlPrincipal ctrlP = new CtrlPrincipal();
        ctrlP.action(this.vue.getjComboBoxPraticien().getSelectedItem()+"");
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
