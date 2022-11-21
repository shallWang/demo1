package com.example.demo.utils;

import com.example.demo.constant.ErrorConstant;
import com.example.demo.constant.WebConstant;

public class ApiResponse<T> {
    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    private static final Integer CODE_SUCCESS = 1;

    private static final Integer CODE_FAIL = -1;

    private static final Integer CODE_NO_LOGIN = 0;
    private Integer code;
    private T data;
    private String msg;

    public ApiResponse() {

    }

    public ApiResponse(Integer code) {
        this.code = code;
    }

    public ApiResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ApiResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiResponse success() {
        return new ApiResponse(CODE_SUCCESS);
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(CODE_SUCCESS, data);
    }

    public static ApiResponse fail(String msg) {
        if(msg.equals(ErrorConstant.User.NOT_LOGIN)){
            return new ApiResponse(CODE_NO_LOGIN);
        }
        return new ApiResponse(CODE_FAIL,msg);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}