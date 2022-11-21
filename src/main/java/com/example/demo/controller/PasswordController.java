package com.example.demo.controller;

import com.example.demo.entity.Password;
import com.example.demo.exception.BusinessException;
import com.example.demo.service.PasswordService;
import com.example.demo.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/password")
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @GetMapping("/get")
    @ResponseBody
    public ApiResponse<List<Password>> getPassword(HttpServletRequest request, Password password){
        List<Password> passwords = null;
        try{
            passwords = passwordService.getPassword(request ,password);
        }catch(BusinessException e){
            return ApiResponse.fail(e.getErrorMessage());
        }
        return ApiResponse.success(passwords);
    }

    @PostMapping("/add")
    @ResponseBody
    public ApiResponse<?> addPassword(HttpServletRequest request, Password password){
        try{
            passwordService.addPassword(request, password);
        }catch(BusinessException e){
            return ApiResponse.fail(e.getErrorMessage());
        }
        return ApiResponse.success();
    }

    @PostMapping("/update")
    @ResponseBody
    public ApiResponse<?> update(HttpServletRequest request, Password password){
        try{
            passwordService.update(request, password);
        }catch(BusinessException e){
            return ApiResponse.fail(e.getErrorMessage());
        }
        return ApiResponse.success();
    }

}
