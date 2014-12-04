/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Vue.VueAbstrait;
/**
 *
 * @author btssio
 */
public abstract class CtrlAbstrait {
    // associations
    protected VueAbstrait vue=null;
    
    public CtrlAbstrait(VueAbstrait vue){
        this.vue=vue;
    }
    
    public VueAbstrait getVue(){
        return vue;
    }
}
