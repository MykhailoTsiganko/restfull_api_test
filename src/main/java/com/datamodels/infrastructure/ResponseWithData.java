package com.datamodels.infrastructure;

import com.jayway.restassured.response.Response;

public class ResponseWithData {
    private Response fullResponse;
    private Object responseEntity;

    public ResponseWithData(Response response) {
        this.fullResponse = response;
    }

    public ResponseWithData(Response response,Class clazz){
        this(response);
        this.responseEntity = response.as(clazz);
    }

    public Response getFullResponse() {
        return fullResponse;
    }

    public void setFullResponse(Response fullResponse) {
        this.fullResponse = fullResponse;
    }

    public Object getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(Object responseEntity) {
        this.responseEntity = responseEntity;
    }
}
