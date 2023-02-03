package com.api.career_mode.career_paths.private_pilot;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractedFlightService {

    @Autowired
    private final ContractedFlightRepository contractedFlightRepository;
    @Autowired
    private final PrivatePilotService privatePilotService;

    public ContractedFlight findFlightByPilotAndIndex(long flightIndex, PrivatePilot pilot){
        return contractedFlightRepository.findAllFlightsByPilot(pilot.getUsername()).stream()
                .filter(flight -> flight.getId().getFlightIndex() == flightIndex)
                .findFirst()
                .orElseThrow(() -> new FlightQueryException("Pilot " + pilot.getUsername() +
                        " does not have flight with index " + flightIndex));
    }

    public void assignActiveFlightToPilot(PrivatePilot pilot, long flightIndex){
        if(isPilotFlightActive(pilot)){
            throw new FlightQueryException("Cannot assign active flight to user when" +
                    "the pilot already has an active flight");
        }
        ContractedFlight flight = contractedFlightRepository.findPilotsFlightByIndex(
                pilot.getUsername(), flightIndex).orElseThrow(
                        () -> new FlightQueryException("Cannot find flight with given index"));
        flight.setIsCurrentFlight(true);
        contractedFlightRepository.save(flight);
        pilot.setCurrentFlightActivated(true);
        privatePilotService.updatePilot(pilot);
    }

    @Transactional
    public void deletePrivatePilotFlight(ContractedFlight flight){
        contractedFlightRepository.delete(flight);
    }

    public ContractedFlight findActivePrivateFlight(PrivatePilot pilot){
        return contractedFlightRepository.findAllFlightsByPilot(pilot.getUsername()).stream()
                .filter(ContractedFlight::getIsCurrentFlight)
                .findFirst()
                .orElseThrow(() -> new FlightQueryException("No active flight for pilot"));
    }

    public boolean isPilotFlightActive(PrivatePilot pilot){
        return contractedFlightRepository.findAllFlightsByPilot(pilot.getUsername()).stream()
                .anyMatch(ContractedFlight::getIsCurrentFlight);
    }

    public List<ContractedFlight> findAllFlightsByPilot(PrivatePilot privatePilot){
        return contractedFlightRepository.findAllFlightsByPilot(privatePilot.getUsername());
    }

    public void savePrivatePilotFlight(ContractedFlight flight){
        contractedFlightRepository.save(flight);
    }
}
