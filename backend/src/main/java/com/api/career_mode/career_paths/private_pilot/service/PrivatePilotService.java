package com.api.career_mode.career_paths.private_pilot.service;

import com.api.career_mode.career_paths.private_pilot.entity.PrivatePilot;
import com.api.career_mode.career_paths.private_pilot.exception.PrivatePilotException;
import com.api.career_mode.career_paths.private_pilot.repository.PrivatePilotRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrivatePilotService {

    @Autowired
    private final PrivatePilotRepository privatePilotRepository;

    public void updatePilot(PrivatePilot pilot){
        if(privatePilotRepository.findById(pilot.getUsername()).isEmpty()){
            throw new PrivatePilotException(("No pilot with the given username exists"));
        }
        privatePilotRepository.save(pilot);
    }
}
