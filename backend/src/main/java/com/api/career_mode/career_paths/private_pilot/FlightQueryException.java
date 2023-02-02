package com.api.career_mode.career_paths.private_pilot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlightQueryException extends RuntimeException{
    public FlightQueryException(String message){
        super(message);
    }
}
