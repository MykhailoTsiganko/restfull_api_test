package com.servicestests;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.User;
import com.services.UserService;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;
import static org.junit.Assert.*;
@DataLoader(filePaths = {"src/test/java/com/testdata/CreateUser.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Parallel(threads = 1)
public class UserCreateTest extends TestBase {
    @Test
    public void createUserValidData(User user) {

        UserService userService = new UserService();

        ResponseWithData responseWithData = userService.createUser(user);

        User entity = (User)responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(),200);
    }

    @Test
    public void createUserInvalidData(User user){
        UserService userService = new UserService();

        ResponseWithData responseWithData = userService.createUser(user);

        User entity = (User)responseWithData.getResponseEntity();

        assertEquals(responseWithData.getFullResponse().statusCode(),400);
    }
}
