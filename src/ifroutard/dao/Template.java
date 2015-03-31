package ifroutard.dao;

import ifroutard.util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

/**
 * DAO generale
 * @author Maria Baboulall & Robin Ricard
 */
public abstract class Template {
    
    /**
     * Persiste un modele dans la base de donnees
     * @param entity L'entite JPA a enregistrer
     */
    public static boolean persiste(Object entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.persist(entity);
        return true;
    }

    /**
     * Persiste une mise a jour de modele dans la base de donnees
     * @param entity L'entite JPA a mettre a jour
     */
    public static boolean miseAJour(Object entity) {
        EntityManager em = JpaUtil.getEntityManager();
        em.merge(entity);
        return true;
    }
    
    /**
     * Retrouve un element stocke a partir de sa cle primaire
     * @param id La cle primaire de l'element
     * @return L'element stocke a la cle primaire
     */
    protected static Object trouveId(Class type, long id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(type, id);
    }
    
    /**
     * Supprime un objet de la base
     * @param o L'objet a supprimer
     */
    public static void supprime(Object o) {
        EntityManager em = JpaUtil.getEntityManager();
        em.remove(o);
    }

    protected static List tous(String entityName) {
        EntityManager em = JpaUtil.getEntityManager();
        Query q = em.createQuery("select e from " + entityName + " e");
        return q.getResultList();
    }
}
