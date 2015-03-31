/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifroutard.dao.jpa;

import ifroutard.model.Client;
import java.util.List;

/**
 *
 * @author aaccardo
 * @param <Entity>
 */
public interface TemplateDao<Entity> {

    /**
     * Sauvegarde une entite e
     *
     * @param e
     */
    public void create(Entity e);

    /**
     * Met à jour un entite e
     *
     * @param e_new nouvelles valeurs de l'entite
     * @param e_old ancien valeur de l'entite
     */
    public void update( Entity e_new, Entity e_old);

    /**
     * Supprime une entite e
     *
     * @param e
     */
    public void delete(Entity e);

    /**
     * @return toutes les entités sauvegardées.
     */
    public List<Entity> findAll();

    /**
     * @param id
     * @return l'entité d'id: id
     */
    public List<Client> findById(String id);
}
