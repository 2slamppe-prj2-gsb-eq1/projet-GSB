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
public class Offrir {
    @Id
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="VIS_MATRICULE")
    private Visiteur matricule;
    @Id
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="RAP_NUM")
    private RapportVisite numero_rap;
    @Id
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="MED_DEPOTLEGAL")
    private Medicament depotlegal;
    @Column(name="OFF_QTE", length=38)
    private int quantite;

    public Visiteur getMatricule() {
        return matricule;
    }

    public void setMatricule(Visiteur matricule) {
        this.matricule = matricule;
    }

    public RapportVisite getNumero_rap() {
        return numero_rap;
    }

    public void setNumero_rap(RapportVisite numero_rap) {
        this.numero_rap = numero_rap;
    }

    public Medicament getDepotlegal() {
        return depotlegal;
    }

    public void setDepotlegal(Medicament depotlegal) {
        this.depotlegal = depotlegal;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Offrir{" + "matricule=" + matricule + ", numero_rap=" + numero_rap + ", depotlegal=" + depotlegal + ", quantite=" + quantite + '}';
    }
}
