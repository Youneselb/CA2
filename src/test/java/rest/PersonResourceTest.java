//package rest;
//
//import entities.Person;
//import utils.EMF_Creator;
//import io.restassured.RestAssured;
//import static io.restassured.RestAssured.given;
//import io.restassured.http.ContentType;
//import io.restassured.parsing.Parser;
//import java.io.IOException;
//import java.net.URI;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.ws.rs.core.UriBuilder;
//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.grizzly.http.util.HttpStatus;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.server.ResourceConfig;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.hasItems;
//import static org.hamcrest.Matchers.*;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
////@Disabled
//public class PersonResourceTest {
//
//    private static final int SERVER_PORT = 7777;
//    private static final String SERVER_URL = "http://localhost/api";
//    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
//    private static HttpServer httpServer;
//    private static EntityManagerFactory emf;
//
//    private Person p1;
//    private Person p2;
//    private Person p3;
//
//    static HttpServer startServer() {
//        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
//        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//       // First Drop and Rebuild the test database 
//        emf = EMF_Creator.createEntityManagerFactoryForTest();
//
//        //Set System property so the project executed by the Grizly-server wil use this same database
//        EMF_Creator.startREST_TestWithDB();
//
//        httpServer = startServer();
//
//        //Setup RestAssured
//        RestAssured.baseURI = SERVER_URL;
//        RestAssured.port = SERVER_PORT;
//
//        RestAssured.defaultParser = Parser.JSON;
//    }
//
//    @AfterAll
//    public static void closeTestServer() {
//
//        // System.in.read();
//        httpServer.shutdownNow();
//        //Don't forget this, if you called its counterpart in @BeforeAll
//        EMF_Creator.endREST_TestWithDB();
//    }
//
//     //Setup the DataBase (used by the test-server and this test) in a known state BEFORE EACH TEST
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//   //   p1 = (new Person(""));
//     //     p2 = (new Person(""));
//      //    p3 = (new Person(""));
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
//    @Test
//    public void serverIsRunning() {
//        System.out.println("Testing is server UP");
//       // Gherkin Syntax
//        given().when().get("/").then().statusCode(200);
//       // Hamcrest matcher
//        given().when().get("/").then().assertThat().statusCode(200);
//    }
//
//    @Test
//    public void contentType() {
//        //Gherkin Syntax
//        given().when().get("/").then().contentType(ContentType.JSON);
//       // Hamcrest matcher
//        given().when().get("/").then().assertThat().contentType(ContentType.JSON);
//    }
//
//    @Test
//    public void demonStrateLogging() {
//
//        given().log().all().when().get("/").then().log().body();
//
//    }
//
//   
//    @Test
//    public void testGetAll() {
//        given()
//                .get("")
//                .then()
//                .assertThat()
//                .body("size()", equalTo(3))
//                .body("name", hasItems(""));
//    }
//
//    @Test
//    public void testFindByname() {
//        given()
//                .get("")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.OK_200.getStatusCode());
//    }
//
//    @Test
//    public void testFindByNameNotFound() {
//        given()
//                .get("")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.NOT_FOUND_404.getStatusCode());
//    }
//
//    @Test
//    public void testFindById() {
//        given()
//                .contentType("application/json")
//                .get("/").then()
//                .assertThat()
//                .statusCode(HttpStatus.OK_200.getStatusCode())
//                .body("[0].id", equalTo(p1.getId().intValue()));
//    }
//}