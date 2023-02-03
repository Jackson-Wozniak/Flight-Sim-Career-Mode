package com.api.career_mode.flight_components.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RouteGeneratorException extends RuntimeException{

    public RouteGeneratorException(String message){
        super(message);
    }
}
