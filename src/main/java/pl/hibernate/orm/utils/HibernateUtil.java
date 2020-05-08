package pl.hibernate.orm.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit-h2");

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if(entityManager==null) {
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static void closeEntityManager(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
