
package Vue;

// on importe les fonctions public de CtrlAbstrait

import Controleur.CtrlAbstrait;


public abstract class VueAbstrait extends javax.swing.JFrame {
    // associations
    protected CtrlAbstrait controleur=null;
    
    public VueAbstrait(CtrlAbstrait ctrl){
        this.controleur=ctrl;
    }

    public CtrlAbstrait getControleur() {
        return controleur;
    }

    public void setControleur(CtrlAbstrait controleur) {
        this.controleur = controleur;
    }
}
