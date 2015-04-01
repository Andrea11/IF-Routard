/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import ifroutard.dao.*;
import static ifroutard.dao.Template.findById;
import ifroutard.model.Pays;
import ifroutard.model.Voyage;
import ifroutard.util.jpaUtil;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author aaccardo
 */
public class VoyageDao extends Template {
    
     /**
     * Trouve le voyage en fonction de son id
     *
     * @param id Id du voyage
     * @return Le voyage
     */
    public static Voyage findId(long id) {
        return (Voyage) findById(Voyage.class, id);
    }

    /**
     * Retrouve tous les voyages
     *
     * @return Toutes les entites de voyage
     */
    public static List<Voyage> all() {
        return all("Voyage");
    }
    

    /**
     * <strong>Only used for TESTS</strong>
     */
    public static void removeAll() {
        List result = all();
        Iterator itr = result.iterator();
        while (itr.hasNext()) {
            delete(itr.next());
        }
    }

    /**
     * Retrouve les voyages par leur code
     *
     * @param code Code d'un voyage
     * @return Les voyages correspondants
     */
    public static List<Voyage> findByCodeVoyage(String code) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Voyage e where upper(e.code) like upper(:code) ORDER BY e.nom");
        q.setParameter("code", code + "%");
        return q.getResultList();
    }

    /**
     * Retourne les voyages par leur nom
     *
     * @param nom Nom du voyage
     * @return les voyages correspondants
     */
    public static List<Voyage> findByNameVoyage(String nom) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Voyage e where upper(e.nom) like upper(:nom) ORDER BY e.nom");
        q.setParameter("nom", nom + "%");
        return q.getResultList();
    }

    /**
     * Retourne les voyages par la durée
     *
     * @param duree La durée du voyage en jours
     * @return les voyages correspondants
     */
    public static List<Voyage> findByDuree(int duree) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Voyage e where e.duree = :duree order by e.nom");
        q.setParameter("duree", duree);
        return q.getResultList();
    }

    /**
     * Retourne les voyages selectionés par les pays traversés
     *
     * @param pays Liste de pays qu'on souhaite visiter
     * @return les voyages correspondants
     */
    public static List<Voyage> findByPays(List<Pays> pays) {
        List<Voyage> tmpVoyage = all();
        Iterator itr = tmpVoyage.iterator();
         while (itr.hasNext()) {
            if (!((Voyage)(itr.next())).getPays().containsAll(pays))
            {
                itr.remove();
            }
         }
        return tmpVoyage;
    }
}
