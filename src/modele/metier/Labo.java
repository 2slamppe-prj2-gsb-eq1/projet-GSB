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
@Table(name="LABO")

public class Labo {
    @Id
    @GeneratedValue
    @Column(name="LAB_CODE", length=2)
    private String code;
    @Column(name="LAB_NOM", length=10)
    private String nom;
    @Column(name="LAB_CHEFVENTE", length=20)
    private String chefVente;
    
}
