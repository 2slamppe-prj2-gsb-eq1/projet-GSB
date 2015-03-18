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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
    private List<Offrir> lesOffres;
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
        // récupération des rapports visites
        // lesRapportsVisites = DaoRapportVisiteJPA.selectOneByVisiteur(em, leVisiteur);
        lesRapportsVisites = DaoRapportVisiteJPA.selectAll(em);
        
        indiceRapportVisiteCourant = 0;
        leRapportViste = lesRapportsVisites.get(indiceRapportVisiteCourant);
        afficherCompteRendu(leRapportViste);
    }
    
    public void nouveauRapport(){
        this.vue.getjTextFieldNumRapport().setText("(Nouv.)");
        this.vue.getjComboBoxPraticien().setEnabled(true);
        this.vue.getjComboBoxPraticien().setSelectedItem("");
        this.vue.getjTextFieldDateRapport().setEditable(true);
        this.vue.getjTextFieldDateRapport().setText("");
        this.vue.getjTextFieldMotifVis().setEditable(true);
        this.vue.getjTextFieldMotifVis().setText("");
        this.vue.getjTextAreaBilan().setEditable(true);
        this.vue.getjTextAreaBilan().setText("");
        DefaultTableModel model = (DefaultTableModel) this.vue.getjTableOffre().getModel();
        while(model.getRowCount() != 0){
            model.removeRow(0);
        }
        this.vue.getjButtonSauvegarder().setVisible(true);
    }
    
    public void sauvegarderRapport(){
        System.out.println(this.vue.getjComboBoxPraticien().getSelectedItem());
        System.out.println(this.vue.getjTextFieldDateRapport().getText());
        System.out.println(this.vue.getjTextFieldMotifVis().getText());
        System.out.println(this.vue.getjTextAreaBilan().getText());
        //this.vue.getjComboBoxPraticien().setEnabled(false);
        //this.vue.getjTextFieldDateRapport().setEditable(false);
        //this.vue.getjTextFieldMotifVis().setEditable(false);
        //this.vue.getjTextAreaBilan().setEditable(false);
        //this.vue.getjButtonSauvegarder().setVisible(false);
        //actualiser();
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
        
        List<Offrir> lesOffres = DaoOffrirJPA.selectOneByRapNum(em, leRapportViste.getNumero_rap());
        
        DefaultTableModel model = (DefaultTableModel) this.vue.getjTableOffre().getModel();
        
        for(int i = 0; i<lesOffres.size(); i++){
            model.addRow(new Object[]{lesOffres.get(i).getMed_depotLegal(), lesOffres.get(i).getQuantite()});
        }
    }
    
    public void suivant(){
        if (indiceRapportVisiteCourant == lesRapportsVisites.size()-1) {
            indiceRapportVisiteCourant = 0;
        } else {
            indiceRapportVisiteCourant = indiceRapportVisiteCourant + 1;
        }
        DefaultTableModel model = (DefaultTableModel) this.vue.getjTableOffre().getModel();
        while(model.getRowCount() != 0){
            model.removeRow(0);
        }
        afficherCompteRendu(lesRapportsVisites.get(indiceRapportVisiteCourant));
        
    }
    
    public void precedent(){
        if (indiceRapportVisiteCourant == 0) {
            indiceRapportVisiteCourant = lesRapportsVisites.size()-1;
        } else {
            indiceRapportVisiteCourant = indiceRapportVisiteCourant - 1;
        }
        DefaultTableModel model = (DefaultTableModel) this.vue.getjTableOffre().getModel();
        while(model.getRowCount() != 0){
            model.removeRow(0);
        }
        afficherCompteRendu(lesRapportsVisites.get(indiceRapportVisiteCourant));
    }
    
    public void DetailsPraticien(){
        if(this.vue.getjComboBoxPraticien().getSelectedItem() != ""){
            CtrlPrincipal ctrlP = new CtrlPrincipal();
            ctrlP.action(this.vue.getjComboBoxPraticien().getSelectedItem()+"");
        } else{
            JOptionPane.showMessageDialog(this.vue, "Veuillez choisir un Praticien", "Erreur Praticien", 
                    JOptionPane.WARNING_MESSAGE);
        }
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
