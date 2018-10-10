package com.services.cxf.api;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.models.Pet;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@InInterceptors
@OutInterceptors
public interface PetService {

    @POST
    Response createPet(Pet pet);

    @PUT
    Response updatePet(Pet pet);

    @GET
    @Path("/findByStatus")
    Response getPetsByStatus(@QueryParam("status") String status);

    @GET
    @Path("/{id}")
    Response getPetById(@PathParam("id") long id);

    @DELETE
    @Path("/{id}")
    ResponseWithData deletePetById(@PathParam("id") long id, @HeaderParam("api_key") String apiKey);
}
