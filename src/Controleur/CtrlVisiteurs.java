/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import java.util.List;
import javax.persistence.EntityManager;
import Vue.*;
import javax.swing.JOptionPane;
import modele.metier.*;
import modele.dao.*;

/**
 *
 * @author btssio
 */
public class CtrlVisiteurs extends CtrlAbstrait{
    private VueVisiteurs vue;
    private List<Visiteur> lesVisiteurs;
    private List<Secteur> lesSecteurs;
    private List<Labo> lesLabos;
    private int indiceVisiteurCourant;
    private Visiteur visiteurCourant;
    EntityManager em;
    
    public CtrlVisiteurs(VueVisiteurs vue, VueAbstrait vueA){
        super(vueA);
        this.vue = vue;
        this.vue.setControleur(this);
        
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
        
        //préparation des combos box
        lesVisiteurs = DaoVisiteurJPA.selectAll(em);
        lesSecteurs = DaoSecteurJPA.selectAll(em);
        lesLabos = DaoLaboJPA.selectAll(em);
        remplissageComboBox(lesVisiteurs, lesSecteurs, lesLabos);
        
        
        //préparation de l'état initial de l'affichage
        indiceVisiteurCourant = 0;
        visiteurCourant = lesVisiteurs.get(indiceVisiteurCourant);
        afficherVisiteur(visiteurCourant);
    }
    
    public final void actualiser() {
        try {
            remplissageComboBox(lesVisiteurs, lesSecteurs, lesLabos);
            indiceVisiteurCourant = 0;
            visiteurCourant = lesVisiteurs.get(indiceVisiteurCourant);
            afficherVisiteur(visiteurCourant);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlPresence - actualiser - " + ex.getMessage(), "Saisie des présences", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void chercher(){
        String nom = (String) this.vue.getjComboBoxChercher().getSelectedItem();
        String [] libelle = nom.split(" ", 0);
        Visiteur unVisiteur = DaoVisiteurJPA.selectOneByNomPrenom(em, libelle[0], libelle[1]);
        afficherVisiteur(unVisiteur);
    }
    
    public void precedent(){
        Visiteur leVisiteur = null;
        for(int i = 0; i<lesVisiteurs.size(); i++){
            Visiteur unVisiteur = lesVisiteurs.get(i);
            if(unVisiteur.getNom().equals(this.vue.getjTextFieldNom().getText()) && unVisiteur.getPrenom().equals(this.vue.getjTextFieldPrenom().getText())){
                if(i == 0){
                    leVisiteur = lesVisiteurs.get(lesVisiteurs.size()-1);
                } else{
                    leVisiteur = lesVisiteurs.get(i-1);
                }
            }
        }
        afficherVisiteur(leVisiteur);
    }
    
    public void suivant(){
        Visiteur leVisiteur = null;
        for(int i = 0; i<lesVisiteurs.size(); i++){
            Visiteur unVisiteur = lesVisiteurs.get(i);
            if(unVisiteur.getNom().equals(this.vue.getjTextFieldNom().getText()) && unVisiteur.getPrenom().equals(this.vue.getjTextFieldPrenom().getText())){
                if(i == lesVisiteurs.size()-1){
                    leVisiteur = lesVisiteurs.get(0);
                } else{
                    leVisiteur = lesVisiteurs.get(i+1);
                }
            }
        }
        afficherVisiteur(leVisiteur);
    }
    
    public void close(){
        this.vue.setVisible(false);
    }
    
    public void remplissageComboBox(List<Visiteur> lesVisiteurs, List<Secteur> lesSecteurs, List<Labo> lesLabos){
        this.vue.getjComboBoxChercher().addItem("");
        for(int i = 0; i<lesVisiteurs.size(); i++){
            Visiteur unVisiteur = lesVisiteurs.get(i);
            this.vue.getjComboBoxChercher().addItem(unVisiteur.getNom() + " " + unVisiteur.getPrenom());
        }
        this.vue.getjComboBoxSecteur().addItem("");
        for(int i = 0; i<lesSecteurs.size(); i++){
            Secteur unSecteur = lesSecteurs.get(i);
            this.vue.getjComboBoxSecteur().addItem(unSecteur.getLibelle());
        }
        this.vue.getjComboBoxLabo().addItem("");
        for(int i = 0; i<lesLabos.size(); i++){
            Labo unLabo = lesLabos.get(i);
            this.vue.getjComboBoxLabo().addItem(unLabo.getNom());
        }
    }
    
    public void afficherVisiteur(Visiteur unVisiteur){
        this.vue.getjTextFieldNom().setText(unVisiteur.getNom());
        this.vue.getjTextFieldPrenom().setText(unVisiteur.getPrenom());
        this.vue.getjTextFieldAdresse().setText(unVisiteur.getAdresse());
        this.vue.getjTextFieldCP().setText(unVisiteur.getCp());
        this.vue.getjTextFieldVille().setText(unVisiteur.getVille());
        if(unVisiteur.getCode_sec() != null){
            this.vue.getjComboBoxSecteur().setSelectedItem(unVisiteur.getCode_sec().getLibelle());
        } else{
            this.vue.getjComboBoxSecteur().setSelectedItem("");
        }
        this.vue.getjComboBoxLabo().setSelectedItem(unVisiteur.getCode_lab().getNom());
    }

    public VueVisiteurs getVue() {
        return vue;
    }

    public void setVue(VueVisiteurs vue) {
        this.vue = vue;
    }
}
