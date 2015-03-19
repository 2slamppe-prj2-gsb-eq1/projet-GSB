/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;

import javax.persistence.*;

/**
 * @param numero : identifiant technique
 * @param nom : identifiant technique
 * @param prenom : identifiant technique
 * @param adresse : identifiant technique
 * @param cp : identifiant technique
 * @param ville : identifiant technique
 * @param coef : identifiant technique
 * @param code : identifiant technique
 * @author btssio
 */
@Entity
@Table(name="PRATICIEN")
public class Praticien {
    @Id
    @GeneratedValue
    @Column(name="PRA_NUM", length=38)
    private String numero;
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
    private String coef;
    @Column(name="TYP_CODE", length=3)
    private String code;

    public Praticien() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public String getCoef() {
        return coef;
    }

    public void setCoef(String coef) {
        this.coef = coef;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
/* @return une instance de la classe Praticien
 * @Override Retourne tous les identifiants de la table Praticien
 */
    @Override
    public String toString() {
        return "Praticien{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", coef=" + coef + ", code=" + code + '}';
    }

    public void setTypePraticien(TypePraticien unTypePra2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setcoef(float parseFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
