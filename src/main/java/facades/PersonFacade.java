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
import javax.persistence.Query;
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
    
    public List<PersonDTO> getPersonsByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.hName=:hobby");
        query.setParameter("hobby", hobby);
        List<Person> personDetails = query.getResultList();
        List<PersonDTO> personDTOList = new ArrayList<>();
        personDetails.forEach((Person person) -> personDTOList.add(new PersonDTO(person)));
        return personDTOList;
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
        Phone ph1 = new Phone(25252525,"yes");
        Address a1 = new Address("groovestreet","yes", em.find(CityInfo.class, "0800"));
        
        
        p1.setAddress(a1);
        p1.addPhone(ph1);
        
 
        try {
            em.getTransaction().begin();
            em.persist(p1);            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
        
    }


