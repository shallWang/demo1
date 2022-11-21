package com.example.demo.service;

import com.example.demo.constant.ErrorConstant;
import com.example.demo.dao.PasswordDao;
import com.example.demo.entity.Password;
import com.example.demo.exception.BusinessException;
import com.example.demo.utils.UserUtils;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PasswordService {
    @Autowired
    private PasswordDao passwordDao;

    public void addPassword(HttpServletRequest request, Password password){
        if(StringUtils.isNullOrEmpty(password.getWebsite()) &&
            StringUtils.isNullOrEmpty(password.getApplication())){
            throw new BusinessException(ErrorConstant.Password.WEBSITE_APPLICATION_IS_EMPTY);
        }
        if(StringUtils.isNullOrEmpty(password.getAccount())){
            throw new BusinessException(ErrorConstant.Password.ACCOUNT_IS_EMPTY);
        }
        if(StringUtils.isNullOrEmpty(password.getAccountPassword())){
            throw new BusinessException(ErrorConstant.Password.PASSWORD_IS_EMPTY);
        }
        String owner = UserUtils.getUserName(request);
        if(StringUtils.isNullOrEmpty(owner)){
            throw new BusinessException(ErrorConstant.User.NOT_LOGIN);
        }
        password.setOwner(owner);
        passwordDao.insert(password);
    }
    public List<Password> getPassword(HttpServletRequest request, Password password){
        if(StringUtils.isNullOrEmpty(password.getWebsite()) &&
                StringUtils.isNullOrEmpty(password.getApplication())){
            throw new BusinessException(ErrorConstant.Password.WEBSITE_APPLICATION_IS_EMPTY);
        }
        String owner = UserUtils.getUserName(request);
        if(StringUtils.isNullOrEmpty(owner)){
            throw new BusinessException(ErrorConstant.User.NOT_LOGIN);
        }
        password.setOwner(owner);
        if(!StringUtils.isNullOrEmpty(password.getWebsite())){
            password.setWebsite("%"+password.getWebsite()+"%");
        }else{
            password.setWebsite(null);
        }
        if(!StringUtils.isNullOrEmpty(password.getApplication())){
            password.setWebsite("%"+password.getApplication()+"%");
        }else{
            password.setApplication(null);
        }
        return passwordDao.find(password);
    }

    public void update(HttpServletRequest request, Password password){
        if(StringUtils.isNullOrEmpty(password.getWebsite()) &&
                StringUtils.isNullOrEmpty(password.getApplication())){
            throw new BusinessException(ErrorConstant.Password.WEBSITE_APPLICATION_IS_EMPTY);
        }
        if(StringUtils.isNullOrEmpty(password.getAccount())){
            throw new BusinessException(ErrorConstant.Password.ACCOUNT_IS_EMPTY);
        }
        if(StringUtils.isNullOrEmpty(password.getAccountPassword())){
            throw new BusinessException(ErrorConstant.Password.PASSWORD_IS_EMPTY);
        }
        String owner = UserUtils.getUserName(request);
        if(StringUtils.isNullOrEmpty(owner)){
            throw new BusinessException(ErrorConstant.User.NOT_LOGIN);
        }
        password.setOwner(owner);
        List<Password> dbPasswords = passwordDao.find(password);
        if(dbPasswords == null){
            throw new BusinessException(ErrorConstant.Password.NOT_EXIST);
        }
        for(Password dbPassword : dbPasswords){
            if(dbPassword.equals(password)){
                passwordDao.update(password);
                return;
            }
        }
        throw new BusinessException(ErrorConstant.Password.NOT_EXIST);
    }
}
