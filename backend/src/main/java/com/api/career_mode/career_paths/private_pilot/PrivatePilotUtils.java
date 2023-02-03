package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.FlightStory;

public class PrivatePilotUtils {

    public static int calculateReputationEarned(FlightStory story){
        return (int) (story.getFlightPayoutInUSD() / 20);
    }

    public static Integer findReputationToNextLevel(int currentLevel){
        if(currentLevel <= 5) {
            return 100;
        }
        if(currentLevel <= 20){
            return 500;
        }
        if(currentLevel <= 50){
            return 1000;
        }
        return 2000;
    }
}
