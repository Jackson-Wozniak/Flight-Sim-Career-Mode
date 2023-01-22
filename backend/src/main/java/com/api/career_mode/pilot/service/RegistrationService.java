package com.api.career_mode.pilot.service;

import com.api.career_mode.pilot.entity.ConfirmationToken;
import com.api.career_mode.pilot.entity.Pilot;
import com.api.career_mode.pilot.exception.PilotCreationException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    @Autowired
    private final PilotService pilotService;
    @Autowired
    private final ConfirmationTokenService confirmationTokenService;

    public String register(String username, String password) {
        if(username.isEmpty() || password.isEmpty()){
            throw new PilotCreationException("Registration fields must contain valid characters");
        }
        return pilotService.signUpPilot(
                new Pilot(
                        username,
                        password
                )
        );
    }

    @Transactional
    public Pilot confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

//        if (confirmationToken.getConfirmedAt() != null) {
//            throw new IllegalStateException("email already confirmed");
//        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        pilotService.enablePilot(
                confirmationToken.getPilot().getUsername());
        return confirmationToken.getPilot();
    }
}
