/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import javax.persistence.*;


/**
 *@param code_lab : identifiant technique
 * @param nom : identifiant technique
 * @param chefVente : identifiant technique
 * @author btssio
 */
@Entity
@Table(name="LABO")

public class Labo {
    @Id
    @GeneratedValue
    @Column(name="LAB_CODE", length=2)
    private String code_lab;
    @Column(name="LAB_NOM", length=10)
    private String nom;
    @Column(name="LAB_CHEFVENTE", length=20)
    private String chefVente;

    public String getCode_lab() {
        return code_lab;
    }

    public void setCode_lab(String code_lab) {
        this.code_lab = code_lab;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getChefVente() {
        return chefVente;
    }

    public void setChefVente(String chefVente) {
        this.chefVente = chefVente;
    }
    
    
    
}
