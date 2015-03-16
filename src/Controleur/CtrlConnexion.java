/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VueConnexion;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import modele.dao.DaoVisiteurJPA;
import modele.dao.EntityManagerFactorySingleton;

/**
 *
 * @author btssio
 */
public class CtrlConnexion extends CtrlAbstrait{
    public VueConnexion vue;
    public boolean connexion;
    private String login;
    EntityManager em;
    
    public CtrlConnexion(VueConnexion vue, VueAbstrait vueA) {
        super(vueA);
        this.vue = vue;
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
    }
    public void valider(){
        
        // récupération du login et mot de passe pour vérification
        String login = getLogin();
        String mdp = vue.getjPasswordFieldMdp().getText();
        
        //vérification vers la bdd oracle en JPA
        connexion = DaoVisiteurJPA.verifierLoginMdp(em, login, mdp);
        if(connexion){
            //System.out.print("connexion réussi");
            CtrlPrincipal ctrlP = new CtrlPrincipal();
            ctrlP.action(EnumAction.AFFICHER_MENU);
            
            // Supprime l'affichage de la vue Connexion
            // this.getVue().setVisible(false);
        } else{
            // Affichage du message d'erreur
            JOptionPane.showMessageDialog(this.vue, "Erreur du login ou du mot de passe", "Connexion non établi", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void quitter(){
        CtrlPrincipal ctrlP = new CtrlPrincipal();
        ctrlP.action(EnumAction.MENU_FICHIER_QUITTER);
    }

    public VueConnexion getVue() {
        return vue;
    }

    public void setVue(VueConnexion vue) {
        this.vue = vue;
    }

    public static String getLogin() {
        return login;
    }
    
}
