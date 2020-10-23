//package facades;
//
//import utils.EMF_Creator;
//import entities.*;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.hamcrest.CoreMatchers.everyItem;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.arrayContaining;
//import static org.hamcrest.Matchers.hasProperty;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
////Uncomment the line below, to temporarily disable this test
////@Disabled
//public class PersonFacadeTest {
//    private static  EntityManagerFactory emf;
//    private static  PersonFacade facade;
//    
//    private Person p1;
//    private Person p2;
//    private Person p3;
//    
//    public PersonFacadeTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
//        facade = PersonFacade.getPersonFacade(emf);
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
////        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
//    }
//    
//    // Setup the DataBase in a known state BEFORE EACH TEST
//    //TODO -- Make sure to change the script below to use YOUR OWN entity class
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//          p1 = new Person("Mark","Sørensen","cph-ms84");
//          p2 = new Person("Yones", "El Bana","cph-ye7");
//          p3 = new Person("Henrik", "Lønquist Thomasen","cph-");
//
//        try {
//            em.getTransaction().begin();
//            em.createQuery("DELETE from Person").executeUpdate();
//            em.persist(p1);
//            em.persist(p2);
//            em.persist(p3);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    
//     
//    @Test
//    public void testGetAllPersons(){
//        //Tode
//    }
//
//    @Test
//    public void testGetPersonById(){
//        //Todo
//    }
//    
//    
//    @Test
//    public void getPersonByname(){
//        //Todo
//    }
//
//
//
//}
