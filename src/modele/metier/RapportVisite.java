/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;

import java.util.Date;
import javax.persistence.*;

/**
 * @param matricule : identifiant technique
 * @param numero_rap : identifiant technique
 * @param numero : identifiant technique
 * @param date_rap : identifiant technique
 * @param bilan_rap : identifiant technique
 * @param motif_rap : identifiant technique
 * @author btssio
 */
@Entity
@Table(name="RAPPORT_VISITE")
public class RapportVisite {
    @Id
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="VIS_MATRICULE")
    private Visiteur matricule;
    @Id
    @GeneratedValue
    @Column(name="RAP_NUM", length=38)
    private int numero_rap;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="PRA_NUM")
    private Praticien numero;
    @Column(name="RAP_DATE")
    @Temporal(value=TemporalType.DATE)
    private Date date_rap;
    @Column(name="RAP_BILAN", length=255)
    private String bilan_rap;
    @Column(name="RAP_MOTIF", length=255)
    private String motif_rap;

    public Visiteur getMatricule() {
        return matricule;
    }

    public void setMatricule(Visiteur matricule) {
        this.matricule = matricule;
    }

    public int getNumero_rap() {
        return numero_rap;
    }

    public void setNumero_rap(int numero_rap) {
        this.numero_rap = numero_rap;
    }

    public Praticien getNumero() {
        return numero;
    }

    public void setNumero(Praticien numero) {
        this.numero = numero;
    }

    public Date getDate_rap() {
        return date_rap;
    }

    public void setDate_rap(Date date_rap) {
        this.date_rap = date_rap;
    }

    public String getBilan_rap() {
        return bilan_rap;
    }

    public void setBilan_rap(String bilan_rap) {
        this.bilan_rap = bilan_rap;
    }

    public String getMotif_rap() {
        return motif_rap;
    }

    public void setMotif_rap(String motif_rap) {
        this.motif_rap = motif_rap;
    }
    
/* @return une instance de la classe RapportVisite
 * @Override Retourne tous les identifiants de la table RapportVisite
 */
    @Override
    public String toString() {
        return "RapportVisite{" + "matricule=" + matricule + ", numero_rap=" + numero_rap + ", numero=" + numero + ", date_rap=" + date_rap + ", bilan_rap=" + bilan_rap + ", motif_rap=" + motif_rap + '}';
    }
}
