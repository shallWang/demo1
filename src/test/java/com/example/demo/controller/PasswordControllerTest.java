package com.example.demo.controller;

import com.example.demo.constant.WebConstant;
import com.example.demo.entity.Password;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.http.Cookie;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PasswordControllerTest {

    @Autowired
    PasswordController passwordController;
    @Test
    public void getPassword() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Cookie cookie = new Cookie(WebConstant.USER_IN_COOKIE, "123");
        request.setCookies(cookie);
        Password password = new Password();
        password.setWebsite("index");
        System.out.println(passwordController.getPassword(request, password));
    }

    @Test
    public void addPassword() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Cookie cookie = new Cookie(WebConstant.USER_IN_COOKIE, "123");
        request.setCookies(cookie);
        Password password = new Password();
        password.setWebsite("http://10.89.100.37/");
        password.setAccount("180405219");
        password.setAccountPassword("wsy2000");
        passwordController.addPassword(request, password);
    }

    @Test
    public void update() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Cookie cookie = new Cookie(WebConstant.USER_IN_COOKIE, "123");
        request.setCookies(cookie);
        Password password = new Password();
        password.setWebsite("index");
        password = passwordController.getPassword(request, password).getData().get(0);
        password.setAccountPassword("测试测试");
        System.out.println(passwordController.update(request, password));
    }
}