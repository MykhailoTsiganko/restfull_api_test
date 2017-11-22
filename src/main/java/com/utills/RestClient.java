package com.utills;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class RestClient {
    public static String enviropment = "";
    public static final ContentType defaultContentType = ContentType.JSON;
    public static Headers headers;

    static {
        Header[] headersArray = {
                new Header("accept", "application/json"),
                new Header("Origin", "http://petstore.swagger.io"),
                new Header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36"),
                new Header("Content-Type", "application/json"),
                new Header("Referer", "http://petstore.swagger.io/?_ga=2.75930581.1772535647.1510920983-62658431.1510920983"),
                new Header("Accept-Encoding", "gzip, deflate"),
                new Header("Accept-Language", "uk-UA,uk;q=0.9,ru;q=0.8,en-US;q=0.7,en;q=0.6")
        };
        headers = new Headers(headersArray);
    }

    private RequestSpecification requestSpecification;
    private Response response;

    public RestClient() {
        this(defaultContentType);
    }

    public RestClient(ContentType contentType) {
        requestSpecification = given().contentType(contentType).headers(headers);
    }

    public Response get(String url) {
        return requestSpecification.when().get(url)
                .then()
                .extract().response();

    }

    public Response post(String url, Object body) {
        return requestSpecification.body(body)
                .when().post(url)
                .then()
                .extract().response();


    }

    public Response put(String url, Object body) {
        return requestSpecification.body(body)
                .when().put(url)
                .then()
                .extract().response();
    }

    public Response delete(String url, Object body) {
        return requestSpecification.body(body)
                .when().delete(url)
                .then()
                .extract().response();
    }
}
