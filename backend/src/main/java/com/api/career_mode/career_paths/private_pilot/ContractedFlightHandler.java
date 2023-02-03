package com.api.career_mode.career_paths.private_pilot;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
Helper class that will handle completed flights, allocating payout, reputation etc for pilot
 */
@Component
@AllArgsConstructor
public class ContractedFlightHandler {

    @Autowired
    private final PrivatePilotService privatePilotService;
    @Autowired
    private final ContractedFlightService contractedFlightService;

    public void handleFlight(PrivatePilot pilot, long flightIndex, FlightOutcomes outcome){
        ContractedFlight flight = contractedFlightService.findFlightByPilotAndIndex(
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

    private void handleCompletedFlight(ContractedFlight flight, PrivatePilot pilot){
        pilot.addToBalance(flight.getFlightStory().getFlightPayoutInUSD());
        pilot.increaseReputation(PrivatePilotUtils.calculateReputationEarned(flight.getFlightStory()));
        privatePilotService.updatePilot(pilot);
        contractedFlightService.deletePrivatePilotFlight(flight);
    }

    private void handleCrashedFlight(ContractedFlight flight, PrivatePilot pilot){

    }

    private void handleIncompleteFlight(ContractedFlight flight, PrivatePilot pilot){

    }
}
