package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Nestor2
 */
public class JpaUtil {
    
    private static final EntityManagerFactory emFactory;
    
    static{
        emFactory= Persistence.createEntityManagerFactory("Proyecto_fase2PU");
    }
    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }
}
