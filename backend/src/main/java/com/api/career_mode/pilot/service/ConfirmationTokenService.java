package com.api.career_mode.pilot.service;

import com.api.career_mode.pilot.entity.ConfirmationToken;
import com.api.career_mode.pilot.entity.Pilot;
import com.api.career_mode.pilot.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final Logger logger = LoggerFactory.getLogger(ConfirmationTokenService.class);

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Transactional
    public void deleteExpiredTokens(){
        confirmationTokenRepository.deleteExpiredTokens(LocalDateTime.now());
        logger.info(confirmationTokenRepository.findDeletedRowCount() + " tokens purged");
    }

    public void setConfirmedAt(String token) {
        confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

    public ConfirmationToken createConfirmationToken(Pilot pilot){
        String token = UUID.randomUUID().toString();
        return new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(60),
                pilot
        );
    }
}
