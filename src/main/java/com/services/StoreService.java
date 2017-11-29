package com.services;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.ApiResponse;
import com.datamodels.services.Order;

public class StoreService extends BaseService {
    public StoreService() {
        super();
        this.serviceUrl = "/order";
    }

    public ResponseWithData createOrder(Order order){
        return new ResponseWithData(restClient.post(serviceUrl,order));
    }

    public ResponseWithData getOrderById(long id, Class clazz){
        return new ResponseWithData(restClient.get(String.format("%s/%d",serviceUrl,id)),clazz);
    }

    public ResponseWithData deleteOrderById(long id){
        return new ResponseWithData(restClient.delete(String.format("%s/%d",serviceUrl,id),null));
    }
}
