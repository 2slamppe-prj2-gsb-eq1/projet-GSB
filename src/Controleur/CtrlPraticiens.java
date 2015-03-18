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
public class CtrlPraticiens extends CtrlAbstrait {

    private VuePraticiens vue;
    private List<Praticien> lesPraticiens;
    private List<Praticien> lesPraticiensAll;
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
        lesPraticiens = DaoPraticienJPA.selectAllOrderPraNum(em);
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
            System.out.println(indicePraticienCourant);
            praticienCourant = lesPraticiens.get(indicePraticienCourant);
            afficherPraticien(praticienCourant);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlPresence - actualiser - " + ex.getMessage(), "Saisie des présences", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void chercher() {
        String nom = (String) this.vue.getjComboBoxSearch().getSelectedItem();
        String[] libelle = nom.split(" ", 0);
        System.out.println(libelle[0] + " " + libelle[1]);
        Praticien unPraticien = DaoPraticienJPA.selectOneByNomPrenom(em, libelle[0], libelle[1]);
        afficherPraticien(unPraticien);
    }

    public void suivant() {
        String numeroString = (String) this.vue.getjTextFieldNum().getText();
        indicePraticienCourant = Integer.parseInt(numeroString)-1;
        
        if (indicePraticienCourant == lesPraticiens.size()-1) {
            indicePraticienCourant = 0;
        } else {
            indicePraticienCourant = indicePraticienCourant + 1;
        }
        afficherPraticien(lesPraticiens.get(indicePraticienCourant));

    }

    public void precedent() {
        String numeroString = (String) this.vue.getjTextFieldNum().getText();
        indicePraticienCourant = Integer.parseInt(numeroString)-1;
        
        if (indicePraticienCourant == 0) {
            indicePraticienCourant = lesPraticiens.size()-1;
        } else {
            indicePraticienCourant = indicePraticienCourant - 1;
        }
        afficherPraticien(lesPraticiens.get(indicePraticienCourant));
    }

    /**
     *
     * @param lesPraticiens
     */
    public void remplissageComboBox(List<Praticien> lesPraticiens /*LieuExercice*/) {
        Praticien premierPraticien = lesPraticiens.get(0);
        this.vue.getjComboBoxSearch().addItem(premierPraticien.getNom() + " " + premierPraticien.getPrenom());
        for (int i = 1; i < lesPraticiens.size(); i++) {
            Praticien unPraticien = lesPraticiens.get(i);
            this.vue.getjComboBoxSearch().addItem(unPraticien.getNom() + " " + unPraticien.getPrenom());
        }

    }

    public void afficherPraticien(Praticien unPraticien) { /*Lieu exercice a ajouter */

        this.vue.getjTextFieldNum().setText(unPraticien.getNumero());
        this.vue.getjTextFieldNom().setText(unPraticien.getNom());
        this.vue.getjTextFieldPrenom().setText(unPraticien.getPrenom());
        this.vue.getjTextFieldAdresse().setText(unPraticien.getAdresse());
        this.vue.getjTextFieldVilleCP().setText(unPraticien.getCp());
        this.vue.getjTextFieldVilleNom().setText(unPraticien.getVille());
        this.vue.getjTextFieldCoefNot().setText(unPraticien.getCoef());
        
        TypePraticien unTypePraticien=DaoTypePraticienJPA.selectOne(em, unPraticien.getCode());
        this.vue.getjTextFieldLieux().setText(unTypePraticien.getLibelle());
    }

    
    public void close() {
        this.vue.setVisible(false);
    }

    public VuePraticiens getVue() {
        return vue;
    }

    public void setVue(VuePraticiens vue) {
        this.vue = vue;
    }
}
