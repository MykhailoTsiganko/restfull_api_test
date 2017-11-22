package com.datamodels.infrastructure;

import com.jayway.restassured.response.Response;

public class ResponseWithData<T> {
    private Response fullResponse;
    private T responseEntity;

    public ResponseWithData(Response response) {
        this.fullResponse = response;
    }

    public ResponseWithData(Response response,Class<T> clazz){
        this(response);
        this.responseEntity = response.as(clazz);
    }

    public Response getFullResponse() {
        return fullResponse;
    }

    public void setFullResponse(Response fullResponse) {
        this.fullResponse = fullResponse;
    }

    public T getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(T responseEntity) {
        this.responseEntity = responseEntity;
    }
}
