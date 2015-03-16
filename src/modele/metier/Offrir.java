/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @param vis_matricule : identifiant technique
 * @param rap_num : identifiant technique
 * @param med_depotLegal : identifiant technique
 * @author btssio
 */
@Entity
@Table(name = "OFFRIR")
@IdClass(OffrirPK.class)
public class Offrir implements Serializable {

    //attributs
    @Id
    private String vis_matricule;
    @Id
    private int rap_num;
    @Id
    private String med_depotLegal;

    @Column(name = "OFF_QTE")
    private int quantite;

    //Constructeur
    public Offrir() {
    }

    public Offrir(String vis_matricule, int rap_num, String med_depotLegal, int quantite) {
        this.vis_matricule = vis_matricule;
        this.rap_num = rap_num;
        this.med_depotLegal = med_depotLegal;
        this.quantite = quantite;
    }

    public String getVis_matricule() {
        return vis_matricule;
    }

    public void setVis_matricule(String vis_matricule) {
        this.vis_matricule = vis_matricule;
    }

    public int getRap_num() {
        return rap_num;
    }

    public void setRap_num(int rap_num) {
        this.rap_num = rap_num;
    }

    public String getMed_depotLegal() {
        return med_depotLegal;
    }

    public void setMed_depotLegal(String med_depotLegal) {
        this.med_depotLegal = med_depotLegal;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
/* @return une instance de la classe Offrir
 * @Override Retourne tous les identifiants de la table Offrir
 */
    @Override
    public String toString() {
        return "Offrir{" + "vis_matricule=" + vis_matricule + ", rap_num=" + rap_num + ", med_depotLegal=" + med_depotLegal + ", quantite=" + quantite + '}';
    }

}