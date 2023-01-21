package com.api.career_mode.pilot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PilotNotFoundException extends RuntimeException{

    public PilotNotFoundException(String message){
        super(message);
    }
}
