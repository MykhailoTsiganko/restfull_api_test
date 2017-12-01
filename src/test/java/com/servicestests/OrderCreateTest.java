package com.servicestests;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.Order;
import com.services.StoreService;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
@DataLoader(filePaths = {"src/test/java/com/testdata/CreateOrder.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Parallel(threads = 1)
public class OrderCreateTest extends TestBase {
    @Test
    public void createOrderValidData(Order order) {

        StoreService storeService = new StoreService();

        ResponseWithData responseWithData = storeService.createOrder(order,Order.class);

        Order entity = (Order)responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(),200);

        assertEquals(entity,order);
    }

    public void createOrderInvalidData(Order order) {

        StoreService storeService = new StoreService();

        ResponseWithData responseWithData = storeService.createOrder(order,Order.class);

        Order entity = (Order)responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(),400);
    }

}
