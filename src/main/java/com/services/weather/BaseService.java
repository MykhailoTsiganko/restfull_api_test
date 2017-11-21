package com.services.weather;

import com.jayway.restassured.response.Header;
import com.utils.RestClient;

import java.util.Arrays;
import java.util.List;

public abstract class BaseService {
    public static final String OPENWEATHER_API_KEY = "33132812ca0f9e4b588b781107d511fe";
    public static final String BASE_URL = "http://api.openweathermap.org";

    RestClient restClient;

    protected BaseService(){
        restClient = new RestClient();
    }

    protected List<Header> buildHeadersWithAccessToken(String accessToken, List<Header> headers) {
        Header[] headersArray = {new Header("Authorization", accessToken),
                new Header("Content-type", "application/json")};

        headers.addAll(Arrays.asList(headersArray));
        return headers;
    }
}
