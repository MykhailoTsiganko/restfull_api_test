package com.services;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.ApiResponse;
import com.datamodels.services.Pet;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;

import java.awt.*;
import java.util.HashMap;

public class PetService extends BaseService {
    public PetService() {
        super();
        this.serviceUrl = "/pet";
    }

    public ResponseWithData<Pet> createPet(Pet pet) {
        return new ResponseWithData<Pet>(restClient.post(serviceUrl, pet),Pet.class);
    }

    public ResponseWithData<Pet> updatePet(Pet pet) {
        return new ResponseWithData<Pet>(restClient.put(serviceUrl, pet),Pet.class);
    }

    public ResponseWithData<Pet[]> getPetsByStatus(String status) {
        return new ResponseWithData<Pet[]>(restClient.get(serviceUrl + "/findByStatus?status=" + status),Pet[].class);
    }

    public ResponseWithData<Pet> getPetById(long id){
        return new ResponseWithData<Pet>(restClient.get(serviceUrl + String.format("/%d",id)),Pet.class);
    }

    public ResponseWithData updatePetByID(long id, HashMap<String,Object> body){
        return new ResponseWithData(restClient.post(serviceUrl,body,ContentType.URLENC));
    }

    public ResponseWithData deletePetById(long id, String apiKey){
        return new ResponseWithData(restClient.delete(String.format("%s/%d",serviceUrl,id),
                                                    null,new Header("api_key",apiKey)));
    }

    public ResponseWithData<ApiResponse> uploadPetImageById(long id, String metaData, Image image){
        return new ResponseWithData<ApiResponse>(restClient.post(String.format("%s/%d/uploadImage",serviceUrl,id),image,ContentType.BINARY));
    }
}
