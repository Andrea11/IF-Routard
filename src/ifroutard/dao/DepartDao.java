/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import static ifroutard.dao.ClientDao.all;
import static ifroutard.dao.Template.findById;
import ifroutard.model.Depart;
import ifroutard.util.jpaUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author aaccardo
 */
public class DepartDao extends Template {

    /**
     * Trouve le départ en fonction de son id
     *
     * @param id Id du départ
     * @return Le départ
     */
    public static Depart findById(long id) {
        return (Depart) findById(Depart.class, id);
    }

    /**
     * Retrouve tous les départs
     *
     * @return Toutes les entites de départ
     */
    public static List<Depart> all() {
        return all("Depart");
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
     * Retrouve les départs par leur codeDepart
     *
     * @param codeDepart Code d'un départ
     * @return Le départ
     */
    public static List<Depart> findByCodeDep(String codeDepart) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Depart e where e.codeDepart like :codeDepart");
        q.setParameter("codeDepart", codeDepart + "%");
        return q.getResultList();
    }

    /**
     * Retourne les départs par leur prix
     *
     * @param prixMin Le prix minimum du départ
     * @param prixMax Le prix maximum du départ
     * @return les départ correspondants
     */
    public static List<Depart> findByPrice(int prixMin, int prixMax) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Depart e where e.prix <= :prixMax and e.prix >= :prixMin order by e.prix asc");
        q.setParameter("prixMax", prixMax);
        q.setParameter("prixMin", prixMin);
        return q.getResultList();
    }

    /**
     * Retourne les départs par leur prix
     *
     * @param prix Le prix maximum du départ
     * @return les départ correspondants
     */
    public static List<Depart> findByPrice(int prix) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Depart e where e.prix <= :prixMax order by e.prix asc");
        q.setParameter("prixMax", prix);
        return q.getResultList();
    }

    /**
     * Retourne les départs par leur date
     *
     * @param dateDepart La date du départ
     * @return Les départs correspondants
     */
    public static List<Depart> findByDate(Date dateDepart) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Depart e where e.dateDepart = :dateDepart");
        q.setParameter("dateDepart", dateDepart);
        return q.getResultList();
    }

    /**
     * Retourne les départs par leur lieu de départ
     *
     * @param lieuDepart Le lieu de départ du départ
     * @return Les départs correspondants
     */
    public static List<Depart> findByDepart(String lieuDepart) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Depart e where upper(e.lieuDepart) like upper(:lieuDepart)");
        q.setParameter("lieuDepart", lieuDepart + "%");
        return q.getResultList();
    }

    /**
     * Retourne les départs par leur lieu d'arrivée
     *
     * @param lieuArrivee Le lieu d'arrivée du départ
     * @return Les départs correspondants
     */
    public static List<Depart> findByArrivee(String lieuArrivee) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Depart e where upper(e.lieuArrivee) like upper(:lieuArrivee)");
        q.setParameter("lieuArrivee", lieuArrivee + "%");
        return q.getResultList();
    }

    /**
     * Retourne les départs par leur lieu de départ et lieu d'arrivée
     *
     * @param lieuDepart Le lieu de départ
     * @param lieuArrivee Le lieu d'arrivée
     * @return Les départs correspondants
     */
    public static List<Depart> findByDA(String lieuDepart, String lieuArrivee) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Depart e where upper(e.lieuDepart) like upper(:lieuDepart) and upper(e.lieuArrivee) like upper(:lieuArrivee)");
        q.setParameter("lieuDepart", lieuDepart + "%");
        q.setParameter("lieuArrivee", lieuArrivee + "%");
        return q.getResultList();
    }

    /**
     * Retourne les départs par leur moyen de transport
     *
     * @param moyenTransport Le moyen de transport
     * @return Les départs correspondants
     */
    public static List<Depart> findByMoyenTransport(String moyenTransport) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Depart e where upper(e.moyenTransport) like upper(:moyenTransport)");
        q.setParameter("moyenTransport", moyenTransport + "%");
        return q.getResultList();
    }

}
