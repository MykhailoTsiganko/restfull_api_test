package com.servicestests;

import com.TestBase;
import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.models.Order;
import com.services.StoreService;
import io.qameta.allure.junit4.DisplayName;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@DataLoader(filePaths = {"src/test/java/com/testdata/CreateOrder.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Display(fields = "description")
@DisplayName("Create order test")
@Parallel(threads = 6)
public class OrderCreateTest extends TestBase {

    @Test
    public void createOrderValidData(Order order) {

        StoreService storeService = new StoreService();

        ResponseWithData responseWithData = storeService.createOrder(order, Order.class);

        Order entity = (Order) responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(), 200);

        assertThat(entity).isEqualToIgnoringGivenFields(order, "status", "shipDate");

    }

    public void createOrderInvalidData(Order order) {

        StoreService storeService = new StoreService();

        ResponseWithData responseWithData = storeService.createOrder(order, Order.class);

        Order entity = (Order) responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(), 400);
    }
}
