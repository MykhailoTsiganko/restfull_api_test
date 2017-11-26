package com.services;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.ApiResponse;
import com.datamodels.services.Order;

public class StoreService extends BaseService {
    public StoreService() {
        super();
        this.serviceUrl = "/order";
    }

    public ResponseWithData<Order> createOrder(Order order){
        return new ResponseWithData<Order>(restClient.post(serviceUrl,order));
    }

    public ResponseWithData<Order> getOrderById(long id){
        return new ResponseWithData<Order>(restClient.get(String.format("%s/%d",serviceUrl,id)));
    }

    public ResponseWithData deleteOrderById(long id){
        return new ResponseWithData(restClient.delete(String.format("%s/%d",serviceUrl,id),null));
    }
}
