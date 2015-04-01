/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import ifroutard.model.Client;
import ifroutard.service.Recherche;
import ifroutard.util.jpaUtil;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ccanete
 */
public class ClientDao extends Template {

    /**
     * Trouve le client en fonction de son id
     *
     * @param id Id du client
     * @return Le client
     */
    public static Client findById(long id) {
        return (Client) Template.findById(Client.class, id);
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
     * Retrouve tous les clients
     *
     * @return Toutes les entites de client
     */
    public static List<Client> all() {
        return all("Client");
    }

    /**
     * Retrouve les clients par leur nom et leur prenom
     *
     * @param nom Leur nom
     * @param prenom Leur prenom
     * @return Le client
     */
    public static List<Client> findByFullName(String nom, String prenom) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Client e where upper(e.nom) like upper(:nom) and upper(e.prenom) like upper(:prenom)");
        q.setParameter("nom", nom + "%");
        q.setParameter("prenom", prenom + "%");
        return q.getResultList();
    }

    /**
     * Retourne les clients par leur mail
     *
     * @param email L'adresse mail du client
     * @return Le client
     */
    public static List<Client> findByEmail(String email) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Client e where upper(e.email) like upper(:email)");
        q.setParameter("email", email + "%");
        return q.getResultList();
    }

    /**
     * Retourne les clients par leur téléphone
     *
     * @param telephone Le numéro du téléphone du client
     * @return Le client
     */
    public static List<Client> findByTel(String telephone) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Client e where e.telephone like :telephone");
        q.setParameter("telephone", telephone + "%");
        return q.getResultList();
    }

    /**
     * Retourne les clients par leur username
     *
     * @param username Le username du client
     * @return Le client
     */
    public static List<Client> findByUser(String username) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from Client e where upper(e.username) like upper(:username)");
        q.setParameter("username", username);
        return q.getResultList();
    }

}
