package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.utils.ApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@SpringBootTest
class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    public void login(){
        MockHttpServletResponse response = new MockHttpServletResponse();
        User user = new User();
        user.setUserName("123");
        user.setUserPassword("123");
        ApiResponse apiResponse = userController.login(response, user);

    }

    @Test
    public void register() {
        User user = new User();
        user.setUserName("123");
        user.setUserPassword("123");
        ApiResponse apiResponse = userController.register(user);

    }
}