package com.api.career_mode.career_paths.private_pilot.story.utils;

import com.api.career_mode.career_paths.private_pilot.story.entity.Cargo;

public class FlightStoryCalculator {

    public static double calculateFlightPayout(Cargo cargo, double weightOfCargo, double flightDistance){
        return Math.round(((cargo.getPayoutMultiplier() * weightOfCargo) + (flightDistance / 100)) * 100.00) / 100.00;
    }
}
