/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import static ifroutard.dao.DevisDao.all;
import static ifroutard.dao.Template.delete;
import ifroutard.model.Client;
import ifroutard.model.Conseiller;
import ifroutard.model.Devis;
import ifroutard.model.Devis;
import ifroutard.model.Voyage;
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
public class DevisDao extends Template {

    /**
     * Trouve le devis en fonction de son id
     *
     * @param id Id du devis
     * @return Le devis
     */
    public static Devis findById(long id) {
        return (Devis) Template.findById(Devis.class, id);
    }

    /**
     * Retrouve tous les deviss
     *
     * @return Toutes les entites de devis
     */
    public static List<Devis> all() {
        return all("Devis");
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
     * Retrouve les deviss par leur (voyage, conseiller, client et date de
     * départ)
     *
     * @param voyage Le voyage de référence du devis
     * @param conseiller Le conseiller chargé du devis
     * @param client Le client intéressé par le devis
     * @param dateDepart La date prévue de départ
     * @return Une liste de devis
     */
    public static List<Devis> find(Voyage voyage, Conseiller conseiller, Client client, Date dateDepart) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Devis e where e.voyage = :voyage and e.conseiller = :conseiller and e.client = :client and e.dateDepart = :dateDepart");
        q.setParameter("voyage", voyage);
        q.setParameter("conseiller", conseiller);
        q.setParameter("client", client);
        q.setParameter("dateDepart", dateDepart);
        return q.getResultList();
    }

    /**
     * Retrouve les deviss par leur conseiller
     *
     * @param conseiller Le conseiller chargé du devis
     * @return Une liste de devis
     */
    public static List<Devis> findByConseiller(Conseiller conseiller) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Devis e where e.conseiller = :conseiller");
        q.setParameter("conseiller", conseiller);
        return q.getResultList();
    }

    /**
     * Retrouve les deviss par leur (voyage, conseiller, client et date de
     * départ)
     *
     * @param client Le client intéressé par le devis
     * @return Une liste de devis
     */
    public static List<Devis> findByClient(Client client) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Devis e where e.client = :client");
        q.setParameter("client", client);
        return q.getResultList();
    }

}
