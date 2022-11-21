package com.example.demo.service;

import com.example.demo.constant.ErrorConstant;
import com.example.demo.entity.User;
import com.example.demo.dao.UserDao;
import com.example.demo.exception.BusinessException;
import com.example.demo.utils.UserUtils;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void register(User user){
        if(StringUtils.isNullOrEmpty(user.getUserName()) || StringUtils.isNullOrEmpty(user.getUserPassword())){
            throw new BusinessException(ErrorConstant.User.USERNAME_PASSWORD_IS_EMPTY);
        }
        User dbUser = userDao.find(user);
        if(dbUser == null){//不存在的用户
            userDao.insert(user);
        }else{//用户存在
            throw new BusinessException(ErrorConstant.User.USER_EXIST);
        }
    }

    public void login(HttpServletResponse response, User user){
        if(StringUtils.isNullOrEmpty(user.getUserName()) || StringUtils.isNullOrEmpty(user.getUserPassword())){
            throw new BusinessException(ErrorConstant.User.USERNAME_PASSWORD_IS_EMPTY);
        }
        User dbUser = userDao.find(user);
        if(dbUser == null){//不存在的用户
            throw new BusinessException(ErrorConstant.User.USERNAME_PASSWORD_ERROR);
        }else if(dbUser.getUserPassword().equals(user.getUserPassword())){//用户密码正确
            UserUtils.setUserName(response, dbUser.getUserName());
        }else{
            throw new BusinessException(ErrorConstant.User.USERNAME_PASSWORD_ERROR);
        }
    }

}
