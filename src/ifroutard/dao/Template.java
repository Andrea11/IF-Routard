package ifroutard.dao;

import ifroutard.util.jpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

/**
 * DAO generale
 * @author aaccardo
 */
public abstract class Template {
    
    /**
     * Persiste un modèle dans la base de donnees
     * @param entity L'entite JPA à sauvegarder
     * @return Verifie bien que l'entité a bien été persistée
     */
    public static boolean persiste(Object entity) {
        jpaUtil.startTransiction();
        EntityManager em = jpaUtil.getEntityManager();
        em.persist(entity);
        jpaUtil.commitTransiction();
        return true;
    }

    /**
     * Met à jour un modèle dans la base de donnees
     * @param entity L'entite JPA a mettre à jour
     * @return Verifie bien que l'entité a bien été persistée
     */
    public static boolean update(Object entity) {
        EntityManager em = jpaUtil.getEntityManager();
        em.merge(entity);
        return true;
    }
    
    /**
     * Retrouve un element stocké a partir de sa cle primaire
     * @param type Le type d'objet qu'on recherche
     * @param id La cle primaire de l'element
     * @return L'element stocke a la cle primaire
     */
    protected static Object findById(Class type, long id) {
        EntityManager em = jpaUtil.getEntityManager();
        return em.find(type, id);
    }
    
    /**
     * Supprime un objet de la base
     * @param o L'objet a supprimer
     */
    public static void delete(Object o) {
        EntityManager em = jpaUtil.getEntityManager();
        em.remove(o);
    }

    /**
     * Affiche la liste complète de tout l'entités
     * @param entityName le type d'entité qu'on veut afficher
     * @return Une liste contenent tous les entités entityName
     */
    
    protected static List all(String entityName) {
        EntityManager em = jpaUtil.getEntityManager();
        Query q = em.createQuery("select e from " + entityName + " e");
        return q.getResultList();
    }
}
