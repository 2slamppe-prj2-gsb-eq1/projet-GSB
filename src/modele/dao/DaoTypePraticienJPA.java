/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import modele.metier.TypePraticien;

 /**
     * selectOne : lire un enregistrement dans la table TypePraticien
     * selectAll: Lire tous les enregistrements dans la table TypePraticien
     * @param em : contexte de persistance
     * @param code : identifiant technique
     * @return une instance de la classe TypePraticien
     */
public class DaoTypePraticienJPA {
    
    public static TypePraticien selectOne(EntityManager em, String code) throws PersistenceException {
        TypePraticien unTypePraticien = null;
        unTypePraticien = em.find(TypePraticien.class, code);
        return unTypePraticien;
    }
    
    public static List<TypePraticien> selectAll(EntityManager em)throws PersistenceException {
        List<TypePraticien> lesTypePraticiens=null;
        Query query=em.createQuery("select v from TypePraticien v");
        lesTypePraticiens=query.getResultList();
        return lesTypePraticiens;
    }
    
}
