package com.api.career_mode.career_paths.private_pilot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FlightCreationException extends RuntimeException{
    public FlightCreationException(String message){
        super(message);
    }
}
