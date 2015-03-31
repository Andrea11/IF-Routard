/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao.jpa;

import java.util.List;
import ifroutard.model.Client;

/**
 *
 * @author ccanete
 */
public interface ClientDao extends TemplateDao<Client> {

	/**
	 * @param nom
	 * @param prenom
	 * @return tous les clients de nom: nom et prenom
	 */
	public List<Client> findClientsByName (String nom, String prenom);

	/**
	 * @param telephone
	 * @return tous les clients de telephone telephone
	 */
	public List<Client> findClientsByTelephone (String telephone);
        
        /**
	 * @param email
	 * @return tous les clients de email
	 */
	
        public List<Client> findClientsByEmail (String email);
        
        /**
	 * @param client
	 * Ajout un client à la BD
	 */
	}
