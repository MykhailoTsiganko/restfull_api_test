package com.utills;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.util.*;

import static com.jayway.restassured.RestAssured.given;

public class RestClient {
    private Logger logger = Logger.getLogger(RestClient.class);
    public static String enviropment = "http://petstore.swagger.io";
    public static ContentType defaultContentType = ContentType.JSON;
    public static Headers defaultHeaders = null;

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
        defaultHeaders = new Headers(headersArray);
    }

    private RequestSpecification requestSpecification;
    private Response response;

    public RestClient() {
        this(defaultContentType);
    }

    public RestClient(ContentType contentType) {
        requestSpecification = given().headers(defaultHeaders);
    }


    public Response post(String url, Object body, ContentType contentType) {
        return requestSpecification.contentType(contentType).body(body)
                .when().post(url)
                .then()
                .extract().response();


    }

    public Response put(String url, Object body, ContentType contentType) {
        return requestSpecification.contentType(contentType).body(body)
                .when().put(url)
                .then()
                .extract().response();
    }

    public Response delete(String url, Object body, ContentType contentType) {
        return requestSpecification.contentType(contentType).body(body)
                .when().delete(url)
                .then()
                .extract().response();
    }

    public Response get(String url) {
        return requestSpecification.contentType(defaultContentType).when().get(url)
                .then()
                .extract().response();

    }

    public Response post(String url, Object body) {
        return requestSpecification.contentType(defaultContentType).body(body)
                .when().post(url)
                .then()
                .extract().response();


    }

    public Response put(String url, Object body) {
        return requestSpecification.contentType(defaultContentType).body(body)
                .when().put(url)
                .then()
                .extract().response();
    }

    public Response delete(String url, Object body) {
        return requestSpecification.contentType(defaultContentType).body(body)
                .when().delete(url)
                .then()
                .extract().response();
    }

    public Response delete(String url, Object body, Header... headers) {
        Collection<Header> collection = new ArrayList<Header>(Arrays.asList(headers));
        collection.addAll(defaultHeaders.asList());
        Header[] requestHeaders = collection.toArray(new Header[]{});

        return requestSpecification.contentType(defaultContentType).headers(new Headers(requestHeaders)).body(body)
                .when().delete(url)
                .then()
                .extract().response();
    }


    public static ContentType getDefaultContentType() {
        return defaultContentType;
    }

    public Headers getDefaultHeaders() {
        return defaultHeaders;
    }

    public void setDefaultHeaders(Headers defaultHeaders) {
        this.defaultHeaders = defaultHeaders;
    }
}
