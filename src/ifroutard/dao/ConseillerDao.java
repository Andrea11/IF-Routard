/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import static ifroutard.dao.ClientDao.all;
import static ifroutard.dao.Template.delete;
import ifroutard.model.Conseiller;
import ifroutard.util.jpaUtil;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author aaccardo
 */
public class ConseillerDao extends Template {

    /**
     * Trouve le conseiller en fonction de son id
     *
     * @param id Id du conseiller
     * @return Le conseiller
     */
    public static Conseiller findById(long id) {
        return (Conseiller) findById(Conseiller.class, id);
    }

    /**
     * Retrouve tous les conseillers
     *
     * @return Toutes les entites de conseiller
     */
    public static List<Conseiller> all() {
        return all("Conseiller");
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
     * Retrouve les conseillers par leur nom et leur prenom
     *
     * @param nom Leur nom
     * @param prenom Leur prenom
     * @return Le conseiller
     */
    public static List<Conseiller> findByFullName(String nom, String prenom) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Conseiller e where upper(e.nom) like upper(:nom) and upper(e.prenom) like upper(:prenom)");
        q.setParameter("nom", nom + "%");
        q.setParameter("prenom", prenom + "%");
        return q.getResultList();
    }

    /**
     * Retourne les conseillers par leur mail
     *
     * @param email L'adresse mail du conseiller
     * @return Le conseiller
     */
    public static List<Conseiller> findByEmail(String email) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Conseiller e where upper(e.email) like upper(:email)");
        q.setParameter("email", "%" + email + "%");
        return q.getResultList();
    }

    /**
     * Retourne les conseillers par leur usernames
     *
     * @param username Le username du conseiller
     * @return Le conseiller
     */
    public static List<Conseiller> findByUser(String username) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Conseiller e where upper(e.username) like upper(:username)");
        q.setParameter("username", username + "%");
        return q.getResultList();
    }

}
