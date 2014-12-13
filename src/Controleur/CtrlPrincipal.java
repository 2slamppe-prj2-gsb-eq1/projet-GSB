package Controleur;

import static Controleur.EnumAction.*;
import Vue.VueAbstrait;
import Vue.VueConnexion;
import Vue.VueMenu;
import Vue.VueVisiteurs;
import javax.swing.JOptionPane;

/**
 * Controleur principal (ou frontal) - un lien vers chaque contrôleur de base
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class CtrlPrincipal {

    private CtrlConnexion ctrlConnexion = null;
    private CtrlMenu ctrlMenu = null;
    private CtrlVisiteurs ctrlVisiteurs = null;
    VueAbstrait vueA = null;
    CtrlAbstrait ctrlA = null;
    VueConnexion vueC = new VueConnexion(ctrlA);

    /**
     * action par défaut action au démarrage de l'application
     */
    public void action() {
        if (ctrlConnexion == null) {
            ctrlConnexion = new CtrlConnexion(vueC, vueA);
        }
        ctrlConnexion.getVue().setEnabled(true);
        ctrlConnexion.getVue().setVisible(true);
    }

    public void action(EnumAction action) {
        switch (action) {
            case AFFICHER_MENU: // activation de vueMenu depuis vueConnexion
                afficherMenu();
                break;
            case VISITEUR_AFFICHER: // activation de vueVisiteurs depuis vueMenu
                afficherVisiteurs();
                break;
            case MENU_FICHIER_QUITTER: // fin de l'application depuis vueMenu
                menuFichierQuitter();
                break;
        }

    }

    /**
     * Fin définitive de l'application La demande de confirmation est gérée par
     * le contrôleur spécialisé
     */
    private void menuFichierQuitter() {
        System.exit(0);
    }

    /**
     * Transition vueMenu / vuePresence
     */
    private void afficherMenu() {
        if (ctrlConnexion == null) {
            ctrlConnexion = new CtrlConnexion(vueC, vueA);
        }
        VueMenu vueM = new VueMenu(ctrlA);
        ctrlMenu = new CtrlMenu(vueM, vueA);
        // vuPresence est une fenêtre modale :
        // -> vueMenu reste visible, mais n'est pas active
        ctrlConnexion.getVue().setEnabled(false);
        ctrlConnexion.getVue().setVisible(false);
        ctrlMenu.getVue().setVisible(true);
    }
    
    private void afficherVisiteurs(){
        if (ctrlMenu == null) {
            VueMenu vueM = new VueMenu(ctrlA);
            ctrlMenu = new CtrlMenu(vueM, vueA);
        }
        if (ctrlVisiteurs == null) {
            VueVisiteurs vueV = new VueVisiteurs(ctrlA);
            ctrlVisiteurs = new CtrlVisiteurs(vueV, vueA);
        } else {
            // si la le contrôleur et sa vue existent déjà
            // il faut rafraîchir le contenu à partir de la base de données
            ctrlVisiteurs.actualiser();
        }
        // vuPresence est une fenêtre modale :
        // -> vueMenu reste visible, mais n'est pas active
        ctrlMenu.getVue().setEnabled(false);
        ctrlMenu.getVue().setVisible(false);
        ctrlVisiteurs.getVue().setVisible(true);
    }
}
