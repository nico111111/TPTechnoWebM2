package com.TechnoWeb.SerieTemp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SerieNotFoundAdvice {
    
    @ResponseBody
    @ExceptionHandler(SerieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(SerieNotFoundException ex) {
        return ex.getMessage();
    }
}
