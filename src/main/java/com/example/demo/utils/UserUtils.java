package com.example.demo.utils;

import com.example.demo.constant.WebConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUtils {
    public static String getUserName(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies == null) return null;
        for(Cookie c : cookies){
            if(c.getName().equals(WebConstant.USER_IN_COOKIE)) return c.getValue();
        }
        return null;
    }

    public static void setUserName(HttpServletResponse response, String userName){
        Cookie cookie = new Cookie(WebConstant.USER_IN_COOKIE, userName);
        cookie.setPath("/");
        cookie.setSecure(WebConstant.SSL);
        cookie.setMaxAge(WebConstant.COOKIE_MAX_AGE);
        response.addCookie(cookie);
    }
}
