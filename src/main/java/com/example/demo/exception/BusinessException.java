package com.example.demo.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private String errorMessage ;

    public BusinessException(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
