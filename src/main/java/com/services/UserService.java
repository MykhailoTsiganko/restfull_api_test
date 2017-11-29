package com.services;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.ApiResponse;
import com.datamodels.services.User;
import com.sun.org.apache.regexp.internal.RE;

public class UserService extends BaseService {
    public UserService() {
        super();
        this.serviceUrl = "/user";
    }

    public ResponseWithData createUser(User user) {
        return new ResponseWithData(restClient.post(serviceUrl, user));
    }

    public ResponseWithData createUsers(User[] users) {
        return new ResponseWithData(restClient.post(serviceUrl, users));
    }

    public ResponseWithData login(String login, String password) {
        return new ResponseWithData(restClient.get(String.format("%s/login?username=%s&password=some%s",serviceUrl,login
                                                                                                       ,password)));
    }

    public ResponseWithData logout(){
        return new ResponseWithData(restClient.get(String.format("%s/logout",serviceUrl)));
    }

    public ResponseWithData getUserByUserName(String username){
        return  new ResponseWithData(restClient.get(String.format("%s/%s",serviceUrl,username)));
    }

    public ResponseWithData updateUser(String username,User user) {
        return new ResponseWithData(restClient.put(String.format("%s/%s",serviceUrl,username),user));
    }

    public ResponseWithData deleteUserByUsername(String username){
        return new ResponseWithData(restClient.delete(String.format("%s/%s",serviceUrl,username),null));
    }
}
