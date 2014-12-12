/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controleur.CtrlAbstrait;

/**
 *
 * @author btssio
 */
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
