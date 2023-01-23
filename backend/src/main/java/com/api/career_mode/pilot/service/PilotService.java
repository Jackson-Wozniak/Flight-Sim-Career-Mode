package com.api.career_mode.pilot.service;

import com.api.career_mode.pilot.entity.ConfirmationToken;
import com.api.career_mode.pilot.entity.Pilot;
import com.api.career_mode.pilot.repository.PilotRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PilotService implements UserDetailsService {

    @Autowired
    private final PilotRepository pilotRepository;
    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return pilotRepository.findById(username).orElseThrow(
                () -> new RuntimeException("Cannot find pilot!"));
    }

    public String signUpPilot(Pilot pilot) {
        boolean pilotExists = pilotRepository
                .findById(pilot.getUsername())
                .isPresent();
        if (pilotExists) {
            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(pilot.getPassword());

        pilot.setPassword(encodedPassword);
        pilotRepository.save(pilot);

        ConfirmationToken confirmationToken = confirmationTokenService.createConfirmationToken(pilot);

        confirmationTokenService.saveConfirmationToken(
                confirmationToken);

        return confirmationToken.getToken();
    }

    public void enablePilot(String username) {
        pilotRepository.enablePilot(username);
    }

    public long findPilotCount(){
        return pilotRepository.count();
    }
}
