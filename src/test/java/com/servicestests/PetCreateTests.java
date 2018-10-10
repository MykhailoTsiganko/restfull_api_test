package com.servicestests;

import com.TestBase;
import com.datamodels.models.Category;
import com.datamodels.models.Order;
import com.datamodels.models.Pet;
import com.datamodels.models.Tag;
import com.services.facades.PetServiceFacade;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class PetCreateTests {

    private PetServiceFacade petServiceFacade;

    @Before
    public void setUp() {
        petServiceFacade = new PetServiceFacade();
    }

    @Test
    public void createPetValidData() {
        String[] photoUrls = {"url", "url"};
        Tag[] tags = {new Tag(23434l, "tag1")};
        Pet pet = new Pet(123424342l, new Category(3434l, "blackPets"), "Rex", photoUrls, tags, "born");
        Response response = petServiceFacade.createPet(pet);

        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

        Pet pet1 = petServiceFacade.createPetAndGet(pet);

        assertNotNull(pet1);


    }
}
