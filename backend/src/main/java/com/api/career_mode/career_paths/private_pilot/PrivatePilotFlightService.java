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

    public List<PrivatePilotFlight> findAllFlightsByPilot(PrivatePilot privatePilot){
        return privatePilotFlightRepository.findAllFlightsByPilot(privatePilot.getUsername());
    }

    public List<PrivatePilotFlightDto> findAllFlightDTOByPilot(PrivatePilot privatePilot){
        return privatePilotFlightRepository.findAllFlightsByPilot(privatePilot.getUsername()).stream()
                .map(PrivatePilotFlightDto::new)
                .collect(Collectors.toList());
    }

    public void savePrivatePilotFlight(PrivatePilotFlight flight){
        privatePilotFlightRepository.save(flight);
    }
}
