package com.api.career_mode.pilot.service;

import com.api.career_mode.pilot.entity.ConfirmationToken;
import com.api.career_mode.pilot.entity.Pilot;
import com.api.career_mode.pilot.exception.PilotCreationException;
import com.api.career_mode.pilot.payload.PilotCreatorRequest;
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

    public String register(PilotCreatorRequest request) {
        if(request.username().isEmpty() || request.password().isEmpty()){
            throw new PilotCreationException("Registration fields must contain valid characters");
        }
        return pilotService.signUpPilot(
                new Pilot(
                        request.username(),
                        request.password(),
                        request.pilotName(),
                        request.homeCountry()
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
