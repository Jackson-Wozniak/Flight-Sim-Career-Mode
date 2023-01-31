package com.api.career_mode.career_paths.private_pilot.story;

public class FlightStoryCalculator {

    public static double calculateFlightPayout(Cargo cargo, double weightOfCargo, double flightDistance){
        return (cargo.getPayoutMultiplier() * weightOfCargo) + (flightDistance / 100);
    }
}
