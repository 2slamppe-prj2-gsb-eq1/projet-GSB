/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueConnexion;
import Vue.VueAbstrait;

/**
 *
 * @author btssio
 */
public class CtrlConnexion extends CtrlAbstrait{
    public VueConnexion vue;
    
    public CtrlConnexion(VueConnexion vue, VueAbstrait vueA){
        super(vueA);
        this.vue = vue;
        this.vue.setCtrl(this);
    }
    public void valider(){

    }
    
    public void quitter(){
        
    }
}
