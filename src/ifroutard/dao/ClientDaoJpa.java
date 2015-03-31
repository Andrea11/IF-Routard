/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao;

import java.util.List;
import ifroutard.dao.jpa.ClientDao;
import ifroutard.model.Client;
import ifroutard.util.JpaUtil;

/**
 *
 * @author ccanete
 */
public class ClientDaoJpa implements ClientDao {

    @Override
    public List<Client> findClientsByName(String nom, String prenom) {

        return JpaUtil.getEntityManager().createQuery("SELECT c FROM Client c WHERE UPPER(c.nom) LIKE UPPER(:Name) AND UPPER(c.prenom) LIKE UPPER(:Prenom)").setParameter("Name", nom + "%").setParameter("Prenom", prenom + "%").getResultList();// " + nom + " AND c.PRENOM = " + prenom);

    }

    @Override
    public List<Client> findClientsByTelephone(String telephone) {
        return JpaUtil.getEntityManager().createQuery("SELECT c FROM Client c WHERE c.telephone LIKE :Telephone").setParameter("Telephone", telephone + "%").getResultList();
    }

    @Override
    public List<Client> findClientsByEmail(String email) {
        return JpaUtil.getEntityManager().createQuery("SELECT c FROM Client c WHERE UPPER(c.eMail) LIKE UPPER(:Email)").setParameter("Email", "%" + email + "%").getResultList();
    }

    @Override
    public void create(Client c) {

        try {

            JpaUtil.startTransiction();
            JpaUtil.getEntityManager().persist(c);
            JpaUtil.commitTransiction();

        } catch (Exception e) {

            JpaUtil.cancelTransiction();

        } finally {

            JpaUtil.close();

        }

    }

    @Override
    public void update(Client c_new, Client c_old) {

        c_old.update(c_new);

    }

    @Override
    public void delete(Client c) {

        JpaUtil.getEntityManager().remove(c);

    }

    @Override
    public List<Client> findAll() {

        return JpaUtil.getEntityManager().createQuery("SELECT c FROM Client c").getResultList();

    }

    @Override
    public List<Client> findById(String id) {

        return JpaUtil.getEntityManager().createQuery("SELECT c FROM Client c WHERE c.username LIKE :Username").setParameter("Username", "%" + id + "%").getResultList();

    }

}
