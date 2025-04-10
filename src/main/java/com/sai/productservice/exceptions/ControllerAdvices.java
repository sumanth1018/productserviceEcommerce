package com.sai.productservice.exceptions;

import com.sai.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// This can be also in controller but moved to separate class because if other controller wants use same exception the code duplication will happen, so, we make this exception as global one by creating exceptionAdvices
@ControllerAdvice  // Acts as
public class ControllerAdvices {
/**
 * @ExceptionHandler(NotFoundException.class)  // says - This Method will automatically called when this (NotFoundException) exception occurs
    private ResponseEntity<ExceptionDto> handleFoundException(NotFoundException notFoundException) {
        System.out.println("Not found exception happened");
        return new ResponseEntity<>(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
 */
}

