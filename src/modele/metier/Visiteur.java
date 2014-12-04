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
    private Date dateEmbauche;
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REFRESH})
    @Column(name="SEC_CODE", length=1)
    @JoinColumn(name="SEC_CODE")
    private String code;
    //@Transient
    //@Column(name="LAB_CODE")
    
}
