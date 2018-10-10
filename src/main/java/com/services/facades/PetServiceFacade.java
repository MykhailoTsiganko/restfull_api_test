package com.services.facades;

import com.datamodels.models.Pet;
import com.services.cxf.api.PetService;
import com.utills.RestClient;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class PetServiceFacade {

    private PetService petService;

    public PetServiceFacade() {
        List providers = new ArrayList();
        JacksonJsonProvider jsonProvider = new JacksonJsonProvider();


        providers.add(jsonProvider);
        petService = JAXRSClientFactory.create("http://petstore.swagger.io/v2", PetService.class, providers, true);
    }

    public Response createPet(Pet pet) {
        return petService.createPet(pet);
    }

    public Pet createPetAndGet(Pet pet) {

        Response response = petService.createPet(pet);

        assertEquals(response.getStatus(),Response.Status.OK.getStatusCode());
        return response.readEntity(Pet.class);
    }

}
