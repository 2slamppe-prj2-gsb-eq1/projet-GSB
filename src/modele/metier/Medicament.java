/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.metier;

import javax.persistence.*;

/**
 * @param depotlegal : identifiant technique
 * @param nomcommercial : identifiant technique
 * @param code : identifiant technique
 * @param composition : identifiant technique
 * @param effets : identifiant technique
 * @param contrindic : identifiant technique
 * @param prix : identifiant technique
 * @author btssio
 */
@Entity
@Table(name="MEDICAMENT")
public class Medicament {
    @Id
    @Column(name="MED_DEPOTLEGAL", length=10)
    private String depotlegal;
    @Column(name="MED_NOMCOMMERCIAL", length=25)
    private String nomcommercial;
    @Column(name="FAM_CODE", length=3)
    private String code;
    @Column(name="MED_COMPOSITION", length=255)
    private String composition;
    @Column(name="MED_EFFETS", length=255)
    private String effets;
    @Column(name="MED_CONTREINDIC", length=255)
    private String contrindic;
    @Column(name="MED_PRIXECHANTILLON")
    private float prix;

    public Medicament() {
    }
    
    public String getDepotlegal() {
        return depotlegal;
    }

    public void setDepotlegal(String depotlegal) {
        this.depotlegal = depotlegal;
    }

    public String getNomcommercial() {
        return nomcommercial;
    }

    public void setNomcommercial(String nomcommercial) {
        this.nomcommercial = nomcommercial;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getEffets() {
        return effets;
    }

    public void setEffets(String effets) {
        this.effets = effets;
    }

    public String getContrindic() {
        return contrindic;
    }

    public void setContrindic(String contrindic) {
        this.contrindic = contrindic;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
 /* @return une instance de la classe Medicament
  * @Override Retourne tous les identifiants de la table Medicament
 */
    @Override
    public String toString() {
        return "Medicament{" + "depotlegal=" + depotlegal + ", nomcommercial=" + nomcommercial + ", code=" + code + ", composition=" + composition + ", effets=" + effets + ", contrindic=" + contrindic + ", prix=" + prix + '}';
    }
}
