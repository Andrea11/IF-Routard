/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import static ifroutard.dao.Template.all;
import static ifroutard.dao.Template.findById;
import ifroutard.model.Circuit;
import ifroutard.model.Pays;
import ifroutard.util.jpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andri
 */
public class CircuitDao extends VoyageDao {

    /**
     * Trouve les circuits en fonction de distance du parcours
     *
     * @param distanceKm Distance en KM minimale du circuit
     * @return Les circuits correspondants
     */
    public static List<Circuit> findByKm(int distanceKm) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Circuit e where e.distanceKm >= :distanceKm order by e.distanceKm asc");
        q.setParameter("distanceKm", distanceKm);
        return q.getResultList();
    }
    
    /**
     * Retrouve tous les circuits
     *
     * @return Toutes les entites de circuit
     */
    public static List<Circuit> allCircuits() {
        return all("Circuit");
    }

}
