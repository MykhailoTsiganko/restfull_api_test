package com.utils;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class RestClient {
    private Response response;

    public Response get(String url, ContentType contentType, List<Header> headers){
        RequestSpecification requestSpecification = given().contentType(contentType);

        response = requestSpecification.when().get(url)
                                        .then()
                                        .extract().response();

        return response;
    }

    public Response post(String url, ContentType contentType, List<Header> headers,Object body){
        RequestSpecification requestSpecification = given().contentType(contentType);

        response = requestSpecification.body(body)
                                        .when().post(url)
                                        .then()
                                        .extract().response();

        return response;
    }

    public Response put(String url, ContentType contentType, List<Header> headers,Object body){
        RequestSpecification requestSpecification = given().contentType(contentType);

        response = requestSpecification.body(body)
                .when().put(url)
                .then()
                .extract().response();

        return response;
    }

    public Response delete(String url, ContentType contentType, List<Header> headers,Object body){
        RequestSpecification requestSpecification = given().contentType(contentType);

        response = requestSpecification.body(body)
                .when().delete(url)
                .then()
                .extract().response();

        return response;
    }


}
