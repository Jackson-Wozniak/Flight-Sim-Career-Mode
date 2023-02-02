package com.api.career_mode.career_paths.private_pilot.story;

public class FlightStoryCalculator {

    public static double calculateFlightPayout(Cargo cargo, double weightOfCargo, double flightDistance){
        return Math.round(((cargo.getPayoutMultiplier() * weightOfCargo) + (flightDistance / 100)) * 100.00) / 100.00;
    }
}
