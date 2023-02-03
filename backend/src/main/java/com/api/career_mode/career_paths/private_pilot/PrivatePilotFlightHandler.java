package com.api.career_mode.career_paths.private_pilot;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
Helper class that will handle completed flights, allocating payout, reputation etc for pilot
 */
@Component
@AllArgsConstructor
public class PrivatePilotFlightHandler {

    @Autowired
    private final PrivatePilotService privatePilotService;
    @Autowired
    private final PrivatePilotFlightService privatePilotFlightService;

    public void handleFlight(PrivatePilot pilot, long flightIndex, FlightOutcomes outcome){
        PrivatePilotFlight flight = privatePilotFlightService.findFlightByPilotAndIndex(
                flightIndex, pilot);
        if(!flight.getIsCurrentFlight()){
            throw new FlightQueryException("Only active flights can be completed");
        }
        switch (outcome){
            case COMPLETED -> handleCompletedFlight(flight,pilot);
            case INCOMPLETE -> handleIncompleteFlight(flight, pilot);
            case CRASHED -> handleCrashedFlight(flight, pilot);
        }
    }

    private void handleCompletedFlight(PrivatePilotFlight flight, PrivatePilot pilot){
        pilot.addToBalance(flight.getFlightStory().getFlightPayoutInUSD());
        pilot.increaseReputation(PrivatePilotUtils.calculateReputationEarned(flight.getFlightStory()));
        privatePilotService.updatePilot(pilot);
        privatePilotFlightService.deletePrivatePilotFlight(flight);
    }

    private void handleCrashedFlight(PrivatePilotFlight flight, PrivatePilot pilot){

    }

    private void handleIncompleteFlight(PrivatePilotFlight flight, PrivatePilot pilot){

    }
}
