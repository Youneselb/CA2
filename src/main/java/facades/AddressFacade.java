package facades;

import dto.AddressDTO;
import entities.Address;
import exceptions.AddressNotFound;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AddressFacade {

    private static AddressFacade instance;
    private static EntityManagerFactory emf;

    public static AddressFacade getAddressFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AddressFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public AddressDTO getAddress(String street) throws AddressNotFound {
        EntityManager em = getEntityManager();
        try {
            Address address = em.find(Address.class, street);
            if (address == null) {
                throw new AddressNotFound(String.format("address: (%s) not found", street));
            } else {
                return new AddressDTO(address);
            }
        } finally {
            em.close();
        }

    }
    
}
