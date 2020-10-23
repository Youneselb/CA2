package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PersonDTO;
import exceptions.MissingInputException;
import exceptions.PersonNotFoundException;
import facades.PersonFacade;
import java.util.List;
import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    private static final PersonFacade PERSONFACADE =  PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String serverIsUp() {
        return "{\"msg\":\"API is running\"}";
    }
    @Path("/hobby/{hobby}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPersonsByHobby(@PathParam("hobby") String hobby) throws EntityNotFoundException{
        List<PersonDTO> personList = PERSONFACADE.getPersonsByHobby(hobby);

        if(personList.isEmpty()){
            throw new EntityNotFoundException("Hobby does not excist");
        }

        return Response.ok()
                .entity(GSON.toJson(personList))
                .build();

    }
    
    @Path("/{city}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPersonsByCity(@PathParam("city") String city) throws EntityNotFoundException{
        List<PersonDTO> personList = PERSONFACADE.getPersonsByCity(city);

        if(personList.isEmpty()){
            throw new EntityNotFoundException("Hobby does not excist");
        }

        return Response.ok()
                .entity(GSON.toJson(personList))
                .build();

    }

    
    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
       return Response.ok().entity(GSON.toJson(PERSONFACADE.getAllPersons())).build();
    }
    
    @Path("/ziplist")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllZips() {
       return Response.ok().entity(GSON.toJson(PERSONFACADE.getAllZipCodes())).build();
    }
    
    @Path("/hobby")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHobbies(){
        return Response.ok().entity(GSON.toJson(PERSONFACADE.getHobbies())).build();
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addPerson(String person) throws MissingInputException {
        PersonDTO p = GSON.fromJson(person, PersonDTO.class);
        PersonDTO pNew = PERSONFACADE.addPerson(p.getfName(), p.getlName(), p.getEmail());
        return GSON.toJson(pNew);
    }
    
    @PUT
    @Path("edit/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String editPerson(@PathParam("id") long id, String person) throws MissingInputException, PersonNotFoundException {
        PersonDTO pDTO = GSON.fromJson(person, PersonDTO.class);
        pDTO.setId((int) id);
        PersonDTO pNew = PERSONFACADE.editPerson(pDTO);
        return GSON.toJson(pNew);
    }

}


    
    
     
    
    


