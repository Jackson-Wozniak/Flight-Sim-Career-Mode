package com.api.career_mode.pilot.service;

import com.api.career_mode.pilot.exception.PilotCreationException;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;

    @Test()
    void emptyFieldsThrowError(){
//        assertThrows(PilotCreationException.class,
//                () -> registrationService.register("Test", ""));
//        assertThrows(PilotCreationException.class,
//                () -> registrationService.register("", "Test"));
//        assertThrows(PilotCreationException.class,
//                () -> registrationService.register("", ""));

    }

}