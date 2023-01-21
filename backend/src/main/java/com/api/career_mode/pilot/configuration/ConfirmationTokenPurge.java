package com.api.career_mode.pilot.configuration;

/*
Purge all tokens in the database at 12:00est
Ensures that only valid tokens are saved each day
 */
import com.api.career_mode.pilot.service.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class ConfirmationTokenPurge {

    @Autowired
    private final ConfirmationTokenService confirmationTokenService;

    private static final String midnightScheduledFormat = "0 0 0 * * *";

    @Scheduled(cron = midnightScheduledFormat)
    public void purgeExpiredTokensDaily(){
        confirmationTokenService.deleteExpiredTokens();
    }
}
