/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.service;

import ifroutard.util.JpaUtil;
import ifroutard.dao.jpa.ClientDao;
import ifroutard.dao.ClientDaoJpa;
import ifroutard.model.Client;

/**
 *
 * @author ccanete
 */
public class Creer {

    public String creerClient(Client c) {

        ClientDao dao = new ClientDaoJpa();
        if (!dao.findById(c.getUsername()).isEmpty()) {

        } else if (!dao.findById(c.geteMail()).isEmpty()) {
            dao.create(c);
        }

        return "";

    }

    public String updateClient(Client c_new, Client c_old) {

        return "";
    }

    public String deleteClient(Client c) {
        ClientDao dao = new ClientDaoJpa();

        if (!dao.findById(c.getUsername()).isEmpty()) {
            dao.delete(c);
        }

        return "";

    }

}
