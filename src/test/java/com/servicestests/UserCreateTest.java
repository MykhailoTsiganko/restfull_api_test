package com.servicestests;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.User;
import com.services.UserService;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Parallel;
import org.easetech.easytest.loader.LoaderType;
import org.junit.Test;

@DataLoader(filePaths = {"src/test/java/com/testdata/CreateUser.xls"}, loaderType = LoaderType.EXCEL, writeData = false)
@Parallel(threads = 10)
public class UserCreateTest extends TestBase {
    @Test
    public void createUserValidData(User user) {

        UserService userService = new UserService();

        ResponseWithData responseWithData = userService.createUser(user);

        User entity = (User)responseWithData.getResponseEntity();

        System.out.println(entity);

        System.out.println(responseWithData.getFullResponse().statusCode());
    }
}
