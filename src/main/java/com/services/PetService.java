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

    public ResponseWithData createPet(Pet pet, Class clazz) {
        return new ResponseWithData(restClient.post(serviceUrl, pet), clazz);
    }

    public ResponseWithData updatePet(Pet pet, Class clazz) {
        return new ResponseWithData(restClient.put(serviceUrl, pet), clazz);
    }

    public ResponseWithData getPetsByStatus(String status, Class clazz) {
        return new ResponseWithData(restClient.get(serviceUrl + "/findByStatus?status=" + status), clazz);
    }

    public ResponseWithData getPetById(long id, Class clazz) {
        return new ResponseWithData(restClient.get(serviceUrl + String.format("/%d", id)), clazz);
    }

    public ResponseWithData updatePetByID(long id, HashMap<String, Object> body) {
        return new ResponseWithData(restClient.post(serviceUrl, body, ContentType.URLENC));
    }

    public ResponseWithData deletePetById(long id, String apiKey) {
        return new ResponseWithData(restClient.delete(String.format("%s/%d", serviceUrl, id),
                null, new Header("api_key", apiKey)));
    }

    public ResponseWithData uploadPetImageById(long id, String metaData, Image image) {
        return new ResponseWithData(restClient.post(String.format("%s/%d/uploadImage", serviceUrl, id), image, ContentType.BINARY));
    }
}
