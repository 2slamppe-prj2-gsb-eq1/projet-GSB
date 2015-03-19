/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;

import javax.persistence.*;

/**
 * @param code_sec : identifiant technique
 * @param libelle : identifiant technique
 * @author btssio
 */
@Entity
@Table(name="SECTEUR")
public class Secteur {
    @Id
    @GeneratedValue
    @Column(name="SEC_CODE", length=1)
    private String code_sec;
    @Column(name="SEC_LIBELLE", length=15)
    private String libelle;

    public Secteur(String n, String nord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCode_sec() {
        return code_sec;
    }

    public void setCode_sec(String code_sec) {
        this.code_sec = code_sec;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
