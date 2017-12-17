package com.servicestests;

import com.TestBase;
import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.models.Order;
import com.services.StoreService;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.loader.LoaderType;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
@DataLoader(filePaths = {"src/test/java/com/testdata/CreateOrder.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Display(fields = "description")
@DisplayName("Create order test")
//@Parallel(threads = 10)
public class OrderCreateTest extends TestBase {
    @Description("Valid data")
    @Test
    public void createOrderValidData(Order order) {
        someAtt();

        StoreService storeService = new StoreService();

        ResponseWithData responseWithData = storeService.createOrder(order,Order.class);

        Order entity = (Order)responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(),200);

        assertEquals(entity,order);
    }
    @Description("Invalid data")
    public void createOrderInvalidData(Order order) {
        someAtt();

        StoreService storeService = new StoreService();

        ResponseWithData responseWithData = storeService.createOrder(order,Order.class);

        Order entity = (Order)responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(),400);

    }

    @Attachment("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    public static String someAtt(){
        return "petro-------------------------------------------------------------------------------------------------";
    }


    @After
    public void finish(){
        someAtt();
    }

}
