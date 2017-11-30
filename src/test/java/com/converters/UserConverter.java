package com.converters;

import com.datamodels.services.User;
import com.google.gson.Gson;
import org.easetech.easytest.converter.AbstractConverter;

import java.util.Map;

public class UserConverter extends AbstractConverter<User> {
    public User convert(Map<String, Object> convertFrom) {
        User user = null;

        if (convertFrom != null) {
            Gson gson = new Gson();
            user = gson.fromJson((String) convertFrom.get("request"), User.class);
        }

        return user;
    }
}
