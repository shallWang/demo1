package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MvcController {

    @Autowired
    private UserDao userDao;

    private boolean isLogIn(HttpServletRequest request){
        String userName = UserUtils.getUserName(request);
        User user = new User();
        user.setUserName(userName);
        User dbUser = userDao.find(user);
        return dbUser != null;
    }
    @RequestMapping("/")
    public String index(HttpServletRequest request){
        if(!isLogIn(request)) return "/index.html";
        return "/html/select.html";
    }

    @RequestMapping("/select")
    public String select(HttpServletRequest request){
        if(!isLogIn(request)) return "/index.html";
        return "/html/select.html";
    }
}
