package com.services.weather;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GlobalWeatherServiceEndpoints extends BaseService {
    private static final String  COUNTRY_SERVICE_URL = "data/2.5/weather/";

    public Response getWeatherByCityName(String cityName) {
        String requestURL = BASE_URL + COUNTRY_SERVICE_URL + "?q=" + cityName + "&units=metric" + "&lang=ua" + "&appid=" + OPENWEATHER_API_KEY;
        return restClient.get(requestURL, ContentType.JSON, null);
    }

    public static void main(String[] args) {
        GlobalWeatherServiceEndpoints globalWeatherServiceEndpoints = new GlobalWeatherServiceEndpoints();
        Response response = globalWeatherServiceEndpoints.getWeatherByCityName("lviv");
        System.out.println(response.body().prettyPrint());
    }
}
