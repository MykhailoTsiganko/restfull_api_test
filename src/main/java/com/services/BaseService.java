package com.services;

import com.utills.RestClient;

public abstract class BaseService {

    protected String serviceUrl;
    protected RestClient restClient;

    protected BaseService(){
        restClient = new RestClient();
    }

}
