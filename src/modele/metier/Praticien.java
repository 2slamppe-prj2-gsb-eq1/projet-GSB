/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;

import javax.persistence.*;

/**
 *
 * @author btssio
 */
@Entity
@Table(name="PRATICIEN")
public class Praticien {
    @Id
    @GeneratedValue
    @Column(name="PRA_NUM", length=38)
    private int numero;
    @Column(name="PRA_NOM", length=25)
    private String nom;
    @Column(name="PRA_PRENOM", length=30)
    private String prenom;
    @Column(name="PRA_ADRESSE", length=50)
    private String adresse;
    @Column(name="PRA_CP", length=5)
    private String cp;
    @Column(name="PRA_VILLE", length=25)
    private String ville;
    @Column(name="PRA_COEFNOTORIETE")
    private float coef;
    @Column(name="TYP_CODE", length=3)
    private String code;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Praticien{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", coef=" + coef + ", code=" + code + '}';
    }
}
