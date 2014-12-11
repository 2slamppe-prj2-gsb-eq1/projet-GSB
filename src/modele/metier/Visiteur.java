package modele.metier;

import java.util.Date;
import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
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
    @Column(name="Vis_PRENOM", length=50)
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
    
}
