 package modele.metier;

import java.util.Date;
import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @param matricule : identifiant technique
 * @param nom : identifiant technique
 * @param prenom : identifiant technique
 * @param adresse : identifiant technique
 * @param cp : identifiant technique
 * @param ville : identifiant technique
 * @param dateEmbauche : identifiant technique
 * @param code_sec : identifiant technique
 * @param code_lab : identifiant technique
 * @author btssio
 */
@Entity
@Table(name="VISITEUR")
public class Visiteur {
    @Id
    @GeneratedValue
    @Column(name="VIS_MATRICULE", length=10)
    private String matricule;
    @Column(name="VIS_NOM", length=25)
    private String nom;
    @Column(name="VIS_PRENOM", length=50)
    private String prenom;
    @Column(name="VIS_ADRESSE", length=50)
    private String adresse;
    @Column(name="VIS_CP", length=5)
    private String cp;
    @Column(name="VIS_VILLE", length=30)
    private String ville;
    @Column(name="VIS_DATEEMBAUCHE")
    @Temporal(value=TemporalType.DATE)
    private Date dateEmbauche;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="SEC_CODE")
    private Secteur code_sec;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="LAB_CODE")
    private Labo code_lab; 

    public Visiteur(String string, String manu, String hugo, String adresse, String cp, String ville, Date date, String s, String code_lab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Visiteur(String b52, String poilu, String gérard, String _rue_du_Bourg, String string, String nantes, Date parse, Secteur sec, Labo lab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Secteur getCode_sec() {
        return code_sec;
    }

    public void setCode_sec(Secteur code_sec) {
        this.code_sec = code_sec;
    }

    public Labo getCode_lab() {
        return code_lab;
    }

    public void setCode_lab(Labo code_lab) {
        this.code_lab = code_lab;
    }

 /* @return une instance de la classe Visiteur
 * @Override Retourne tous les identifiants de la table Visiteur
 */
    @Override
    public String toString() {
        return "\n\tVisiteur{" + "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + 
                ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", dateEmbauche=" + dateEmbauche + 
                ", code_sec=" + code_sec + ", code_lab=" + code_lab + '}';
    }
    
}

