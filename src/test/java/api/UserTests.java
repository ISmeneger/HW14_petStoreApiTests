package api;

import controller.UserController;
import io.restassured.response.Response;
import models.ApiResponse;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.CommonConstants.*;

class UserTests {

    @Test
    void createUserTest() {
        UserController userController = new UserController();

        Response response = userController.createUser(DEFAULT_USER);

        Assertions.assertEquals(200, response.getStatusCode());
        ApiResponse user = response.as(ApiResponse.class);
        Assertions.assertEquals(200, user.getCode());
        Assertions.assertEquals("unknown", user.getType());
        Assertions.assertTrue(Long.parseLong(user.getMessage()) > 9223372036854768055L);
    }

    @Test
    void updateUserTest() {
        String username = "string2";

        UserController userController = new UserController();

        Response response = userController.updateUser(UPDATE_USER, username);

        Assertions.assertEquals(200, response.getStatusCode());
        ApiResponse user = response.as(ApiResponse.class);
        Assertions.assertEquals(200, user.getCode());
        Assertions.assertEquals("unknown", user.getType());
        Assertions.assertEquals("1", user.getMessage());
    }


    @Test
    void getUserTest() {
        UserController userController = new UserController();

        Response response = userController.getUser("string");

        Assertions.assertEquals(200, response.getStatusCode());
        User user = response.as(User.class);
        Assertions.assertTrue(user.getId() > 9223372036854766000L);
        Assertions.assertEquals(expectedUser, user);
    }

    @Test
    void createUserWithSerializationTest() {
        UserController userController = new UserController();

        Response response = userController.createUser(DEFAULT_USER);

        Assertions.assertEquals(200, response.getStatusCode());
        ApiResponse user = response.as(ApiResponse.class);
        Assertions.assertEquals(200, user.getCode());
        Assertions.assertEquals("unknown", user.getType());
        Assertions.assertTrue(Long.parseLong(user.getMessage()) > 9223372036854768055L);
    }

    @Test
    void deleteUserTest() {
        UserController userController = new UserController();

        Response response = userController.deleteUserByUserName("string");

        Assertions.assertEquals(200, response.getStatusCode());
        ApiResponse user = response.as(ApiResponse.class);
        Assertions.assertEquals(200, user.getCode());
        Assertions.assertEquals("unknown", user.getType());
        Assertions.assertEquals("string", user.getMessage());
    }
}
