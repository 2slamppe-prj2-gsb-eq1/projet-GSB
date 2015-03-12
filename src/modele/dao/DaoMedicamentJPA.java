/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.dao;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.Medicament;

public class DaoMedicamentJPA {

    /**
     * selectOne : lire un enregistrement dans la table Secteur
     *
     * @param em : contexte de persistance
     * @param code : identifiant technique
 
     * @return une instance de la classe Secteur
     */
    public static Medicament selectOnebyID(EntityManager em, String depotlegal) throws PersistenceException {
        Medicament unMedicament = null;
        unMedicament = em.find(Medicament.class, depotlegal);
        return unMedicament;
    }
    
  

    /**
     * lire tous les enregistrements de la table Secteur
     *
     * @param em : contexte de persistance
     * @return une collection d'instances de la classe Secteur
     */
    public static List<Medicament> selectAll(EntityManager em) throws PersistenceException {
        List<Medicament> lesMedicaments = null;
        Query query= em.createQuery("select m from Medicament m");
        lesMedicaments = query.getResultList();
        return lesMedicaments;
    }
    
}
