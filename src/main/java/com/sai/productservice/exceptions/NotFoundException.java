package com.sai.productservice.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)   // It is simple way to send simple exception messge, when ever this exception found it throws the NOT FOUND messege
public class NotFoundException extends  Exception{
    public NotFoundException(String message){
        super(message);
    }

}
