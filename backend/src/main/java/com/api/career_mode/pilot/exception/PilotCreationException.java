package com.api.career_mode.pilot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PilotCreationException extends RuntimeException{
    public PilotCreationException(String message){
        super(message);
    }
}
