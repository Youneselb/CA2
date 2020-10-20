package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.CityInfoFacade;
import facades.HobbyFacade;
import facades.PersonFacade;
import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    private static final CityInfoFacade CITYINFOFACADE =  CityInfoFacade.getCityInfoFacade(EMF);
    private static final HobbyFacade HOBBYFACADE =  HobbyFacade.getHobbyFacade(EMF);
    private static final PersonFacade PERSONFACADE =  PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Get test\"}";
    }

}
