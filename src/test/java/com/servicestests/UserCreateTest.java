package com.servicestests;

import com.TestBase;
import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.models.User;
import com.services.UserService;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;
import static org.junit.Assert.*;
@DataLoader(filePaths = {"src/test/java/com/testdata/CreateOrder.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Parallel(threads = 1)
@Display(fields = "description")
@DisplayName("Create user test")
public class UserCreateTest extends TestBase {
    @Description("Valid Data")
    @Test
    public void createUserValidData(User user) {

        UserService userService = new UserService();

        ResponseWithData responseWithData = userService.createUser(user);

        User entity = (User)responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(),200);
    }

    @Description("Invalid Data")
    @Test
    public void createUserInvalidData(User user){
        UserService userService = new UserService();

        ResponseWithData responseWithData = userService.createUser(user);

        User entity = (User)responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(),400);
    }
}
