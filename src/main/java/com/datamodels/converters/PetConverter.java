package com.datamodels.converters;

import com.datamodels.models.Pet;
import com.google.gson.Gson;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class PetConverter extends AbstractConverter<Pet> {
    public Pet convert(Map<String, Object> convertFrom) {
        Pet pet = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            pet = gson.fromJson((String) convertFrom.get("request"), Pet.class);
        }

        return pet;
    }
}
