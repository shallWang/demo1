package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.service.UserService;
import com.example.demo.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    @ResponseBody
    public ApiResponse<?> login(HttpServletResponse response, User user){
        try {
            userService.login(response, user);
        } catch (BusinessException e){
            return ApiResponse.fail(e.getErrorMessage());
        }
        return ApiResponse.success();
    }

    @PostMapping("/register")
    @ResponseBody
    public ApiResponse<?> register(User user){
        try {
            userService.register(user);
        }catch (BusinessException e){
            return ApiResponse.fail(e.getErrorMessage());
        }
        return ApiResponse.success();
    }
}
