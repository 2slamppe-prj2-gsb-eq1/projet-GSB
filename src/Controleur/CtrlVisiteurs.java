/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
import Vue.VueVisiteurs;
import java.util.List;
import javax.persistence.EntityManager;
import modele.dao.EntityManagerFactorySingleton;
import modele.metier.Visiteur;
import modele.dao.DaoVisiteurJPA;

/**
 *
 * @author btssio
 */
public class CtrlVisiteurs extends CtrlAbstrait{
    private VueVisiteurs vue;
    private List<Visiteur> lesVisiteurs;
    private int indiceVisiteurCourant;
    private Visiteur visiteurCourant;
    EntityManager em;
    
    public CtrlVisiteurs(VueVisiteurs vue, VueAbstrait vueA){
        super(vueA);
        this.vue = vue;
        this.vue.setCtrl(this);
        
        // Gérer la persistance
        em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        em.getTransaction().begin();
        
        //préparation de l'état initial
        lesVisiteurs = DaoVisiteurJPA.selectAll(em);
        indiceVisiteurCourant = 0;
        visiteurCourant = lesVisiteurs.get(indiceVisiteurCourant);
        afficherVisiteur(visiteurCourant);
    }
    
    public void chercher(){
        
    }
    
    public void precedent(){
        
    }
    
    public void suivant(){
        
    }
    
    public void close(){
        
    }
    
    public void afficherVisiteur(Visiteur unVisiteur){
        this.vue.getjTextFieldNom().setText(unVisiteur.getNom());
//        this.getVue().getjTextFieldRue().setText(uneAdresse.getRue());
//        this.getVue().getjTextFieldCdp().setText(uneAdresse.getCp());
//        this.getVue().getjTextFieldVille().setText(uneAdresse.getVille());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueVisiteurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueVisiteurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueVisiteurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueVisiteurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CtrlAbstrait CtrlA = null;
                new VueVisiteurs(CtrlA).setVisible(true);
            }
        });
    }
}
