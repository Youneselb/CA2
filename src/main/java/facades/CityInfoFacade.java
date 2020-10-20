package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CityInfoFacade {

    private static CityInfoFacade instance;
    private static EntityManagerFactory emf;

    public static CityInfoFacade getCityInfoFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CityInfoFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    }
