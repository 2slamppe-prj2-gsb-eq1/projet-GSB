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
@Table(name="TYPE_PRATICIEN")
public class TypePraticien {
    @Id
    @Column(name="TYP_CODE", length=3)
    private String code;
    @Column(name="TYP_LIBELLE", length=25)
    private String libelle;
    @Column(name="TYP_LIEU", length=35)
    private String lieu;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        return "TypePraticien{" + "code=" + code + ", libelle=" + libelle + ", lieu=" + lieu + '}';
    }
    
}
