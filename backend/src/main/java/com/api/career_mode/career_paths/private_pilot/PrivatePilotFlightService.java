package com.api.career_mode.career_paths.private_pilot;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrivatePilotFlightService {

    @Autowired
    private final PrivatePilotFlightRepository privatePilotFlightRepository;

    public PrivatePilotFlight findFlightByPilotAndIndex(long flightIndex, PrivatePilot pilot){
        return privatePilotFlightRepository.findAllFlightsByPilot(pilot.getUsername()).stream()
                .filter(flight -> flight.getId().getFlightIndex() == flightIndex)
                .findFirst()
                .orElseThrow(() -> new FlightQueryException("Pilot " + pilot.getUsername() +
                        " does not have flight with index " + flightIndex));
    }

    public PrivatePilotFlight findActivePrivateFlight(PrivatePilot pilot){
        return privatePilotFlightRepository.findAllFlightsByPilot(pilot.getUsername()).stream()
                .filter(PrivatePilotFlight::getIsCurrentFlight)
                .findFirst()
                .orElseThrow(() -> new FlightQueryException("No active flight for pilot"));
    }

    public boolean isPilotFlightActive(PrivatePilot pilot){
        return privatePilotFlightRepository.findAllFlightsByPilot(pilot.getUsername()).stream()
                .anyMatch(PrivatePilotFlight::getIsCurrentFlight);
    }

    public List<PrivatePilotFlight> findAllFlightsByPilot(PrivatePilot privatePilot){
        return privatePilotFlightRepository.findAllFlightsByPilot(privatePilot.getUsername());
    }

    public void savePrivatePilotFlight(PrivatePilotFlight flight){
        privatePilotFlightRepository.save(flight);
    }
}
