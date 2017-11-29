package Services;

import com.datamodels.infrastructure.ResponseWithData;
import com.datamodels.services.User;
import com.services.UserService;
import org.junit.Test;

public class UserCreateTest {
    @Test
    public void createUserValidData() {
        User user = new User(123, "name", "first", "last", "email", "password",
                "phone", 1);

        UserService userService = new UserService();

        ResponseWithData responseWithData = userService.createUser(user,User.class);

        User entity = (User)responseWithData.getResponseEntity();

        System.out.println(entity);

        System.out.println(responseWithData.getFullResponse().statusCode());




    }
}
