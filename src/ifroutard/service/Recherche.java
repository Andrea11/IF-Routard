/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.service;

import ifroutard.dao.ClientDaoJpa;
import ifroutard.dao.jpa.ClientDao;
import ifroutard.model.Client;
import java.util.List;

/**
 *
 * @author aaccardo
 */
public class Recherche {

    private ClientDao clientDao = new ClientDaoJpa();

    /**
     * @param nomComplet
     * @return Une liste avec tous les clients selectionés par nom et prenom
     */
    public List<Client> getClient(String[] nomComplet) {
        String nom, prenom;
        if (nomComplet[0] == null) {
            nom = "";
        } else {
            nom = nomComplet[0];
        }
        if (nomComplet[1] == null) {
            prenom = "";
        } else {
            prenom = nomComplet[1];
        }
        
        return clientDao.findClientsByName(nom, prenom);
    }

    /**
     * @param telephone
     * @return Une liste avec tous les clients selectionés par telephone
     */
    public List<Client> getClientTel(String telephone) {
        return clientDao.findClientsByTelephone(telephone);
    }

    /**
     * @param email
     * @return Une liste avec tous les clients selectionés par email
     */
    public List<Client> getClientEmail(String email) {
        return clientDao.findClientsByEmail(email);
    }

}
