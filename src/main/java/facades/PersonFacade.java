package facades;

import dto.PersonDTO;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    public List<PersonDTO> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query =  em.createQuery("SELECT p FROM Persons p",Person.class);
        List<Person> persons = query.getResultList();
        List<PersonDTO> personsDTOs = new ArrayList();
        persons.forEach((Person person) -> {
            personsDTOs.add(new PersonDTO(person));
        });
        return personsDTOs;     
    }
    

            
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        
        Person p1 = new Person("someemail","inferno","mirage");
        Address a1 = new Address("PriestStreet", "2. TV");       
        Hobby h1 = new Hobby("csgo","wikicsgo","gaming","spil");
        Phone ph1 = new Phone(25252525,"yes");
        CityInfo c1 = new CityInfo("3660", "Stenløse");
        
        
        a1.setCityInfo(c1);
        p1.setAddress(a1);
        p1.addPhone(ph1);
        p1.addHobby(h1);
        

        try {
            em.getTransaction().begin();
            em.persist(p1);            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
        
    }


