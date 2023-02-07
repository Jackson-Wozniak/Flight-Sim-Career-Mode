package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.flight_components.dto.PlaneDto;
import com.api.career_mode.flight_components.entity.PlaneOwned;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PrivatePilotDTO {

    private int level;
    private int reputationToNextLevel;
    private double balance;
    private List<ContractedFlightDTO> flights;
    private boolean currentFlightActivated;
    private List<PlaneDto> planesOwned;

    public PrivatePilotDTO(PrivatePilot pilot){
        this.level = pilot.getLevel();
        this.reputationToNextLevel = pilot.getReputationToNextLevel();
        this.balance = pilot.getBalance();
        this.flights = pilot.getFlights().stream().map(ContractedFlightDTO::new).collect(Collectors.toList());
        this.currentFlightActivated = pilot.getCurrentFlightActivated();
        this.planesOwned = pilot.getPlanesOwned().stream()
                .map(PlaneOwned::getPlane)
                .map(PlaneDto::new)
                .collect(Collectors.toList());
    }
}
