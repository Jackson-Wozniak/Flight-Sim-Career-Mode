package com.api.career_mode.career_paths.private_pilot.enums;

import com.api.career_mode.career_paths.private_pilot.exception.FlightQueryException;

public enum FlightOutcomes {
    COMPLETED,
    CRASHED,
    INCOMPLETE;

    public static FlightOutcomes mapStringToOutcome(String outcome){
        return switch (outcome.toUpperCase()){
            case "COMPLETED" -> COMPLETED;
            case "CRASHED" -> CRASHED;
            case "INCOMPLETE" -> INCOMPLETE;
            default -> throw new FlightQueryException("Flight has have a valid outcome");
        };
    }
}
