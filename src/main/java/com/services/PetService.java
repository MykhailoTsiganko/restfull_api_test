package com.services;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.petservice.Pet;

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

    public ResponseWithData updatePetByID(long id, ){
        return new ResponseWithData(restClient.post(serviceUrl));
    }
}
