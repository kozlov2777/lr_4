package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaManager {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJPAUnit");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}

