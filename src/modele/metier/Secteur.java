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
@Table(name="SECTEUR")
public class Secteur {
    @Id
    @GeneratedValue
    @Column(name="SEC_CODE", length=1)
    private String code;
    @Column(name="SEC_LIBELLE", length=15)
    private String libelle;
 
}
