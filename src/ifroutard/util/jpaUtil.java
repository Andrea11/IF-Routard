package ifroutard.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaUtil {

	private static final String PERSISTENCE_UNIT_NAME = "IF-Routard-B3230PU";

	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory factory;

	private jpaUtil() {
	}

	public static boolean isEntityManagerOpen(){
		return jpaUtil.manager.get() != null && jpaUtil.manager.get().isOpen();
	}
	
	public static EntityManager getEntityManager() {
		if (jpaUtil.factory == null) {
			jpaUtil.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager em = jpaUtil.manager.get();
		if (em == null || !em.isOpen()) {
			em = jpaUtil.factory.createEntityManager();
			jpaUtil.manager.set(em);
		}
		return em;
	}
        
        public static void startTransiction() {
            getEntityManager().getTransaction().begin();
        }
        
        public static void commitTransiction() {
            getEntityManager().getTransaction().commit();
        }
        
        public static void cancelTransiction() {
            getEntityManager().getTransaction().rollback();
        }
        
        public static void close() {
            getEntityManager().close();
        }

	public static void closeEntityManager() {
		EntityManager em = jpaUtil.manager.get();
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) { 
				tx.commit();
			}
			em.close();
			jpaUtil.manager.set(null);
		}
	}
	
	public static void closeEntityManagerFactory(){
		closeEntityManager();
		jpaUtil.factory.close();
	}
}
