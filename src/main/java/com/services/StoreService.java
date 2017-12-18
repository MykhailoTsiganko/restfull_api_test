package com.services;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.models.Order;

public class StoreService extends BaseService {
    public StoreService() {
        super();
        this.serviceUrl = "/store/order";
    }

    public ResponseWithData createOrder(Order order,Class clazz){
        return new ResponseWithData(restClient.post(serviceUrl,order),clazz);
    }

    public ResponseWithData getOrderById(long id, Class clazz){
        return new ResponseWithData(restClient.get(String.format("%s/%d",serviceUrl,id)),clazz);
    }

    public ResponseWithData deleteOrderById(long id){
        return new ResponseWithData(restClient.delete(String.format("%s/%d",serviceUrl,id),null));
    }
}
