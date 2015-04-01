/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import static ifroutard.dao.Template.findById;
import ifroutard.model.Pays;
import ifroutard.util.jpaUtil;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author aaccardo
 */
public class PaysDao extends Template {

    /**
     * Trouve le pays en fonction de son id
     *
     * @param id Id du pays
     * @return Le pays
     */
    public static Pays findId(long id) {
        return (Pays) findById(Pays.class, id);
    }

    /**
     * Retrouve tous les pays
     *
     * @return Toutes les entites de pays
     */
    public static List<Pays> all() {
        return all("Pays");
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
     * Retrouve les pays par leur codePays
     *
     * @param codePays Code d'un pays
     * @return Les pays correspondants
     */
    public static List<Pays> findByCodePays(String codePays) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Pays e where upper(e.codePays) like upper(:codePays)");
        q.setParameter("codePays", codePays + "%");
        return q.getResultList();
    }

    /**
     * Retourne les pays par leur nom
     *
     * @param nomPays Nom du pays
     * @return les pays correspondants
     */
    public static List<Pays> findByNamePays(String nomPays) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Pays e where upper(e.nomPays) like upper(:nomPays) ORDER BY e.nomPays");
        q.setParameter("nomPays", nomPays + "%");
        return q.getResultList();
    }

    /**
     * Retourne les pays par la capital
     *
     * @param capital La capital du pays
     * @return les pays correspondants
     */
    public static List<Pays> findByCapital(String capital) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Pays e where upper(e.capital) like upper(:capital) order by e.nomPays");
        q.setParameter("capital", capital + "%");
        return q.getResultList();
    }

    /**
     * Retourne les pays selectionés par la langue principale
     *
     * @param language La langue plus parlée dans le pays
     * @return les pays correspondants
     */
    public static List<Pays> findByLanguage(String language) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Pays e where upper(e.language) like upper(:language) order by e.nomPays");
        q.setParameter("language", language + "%");
        return q.getResultList();
    }
}
