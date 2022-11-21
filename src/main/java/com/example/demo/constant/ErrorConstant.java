package com.example.demo.constant;

public interface ErrorConstant {
    interface User{
        String USERNAME_PASSWORD_IS_EMPTY = "用户名和密码不可为空";
        String USERNAME_PASSWORD_ERROR = "用户名不存在或密码错误";
        String NOT_LOGIN = "用户未登录";
        String USER_EXIST = "用户已存在";
    }

    interface Password{
        String WEBSITE_APPLICATION_IS_EMPTY  ="网站和应用不可同时为空";
        String ACCOUNT_IS_EMPTY = "账户为空";
        String PASSWORD_IS_EMPTY = "密码为空";

        String NOT_EXIST = "不存在的记录";
    }
}
