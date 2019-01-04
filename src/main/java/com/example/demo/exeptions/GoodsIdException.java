package com.example.demo.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GoodsIdException extends RuntimeException {

    public GoodsIdException(String message){
        super(message);
    }
}
