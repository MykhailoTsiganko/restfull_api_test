package com.services;

import com.utills.RestClient;

public abstract class BaseService {
    public static final String OPENWEATHER_API_KEY = "33132812ca0f9e4b588b781107d511fe";
    public static final String BASE_URL = "http://api.openweathermap.org";

    RestClient restClient;

    protected BaseService(){
        restClient = new RestClient();
    }

}
