package com.api.career_mode.flight_components.service;

import com.api.career_mode.flight_components.entity.PlaneOwned;
import com.api.career_mode.flight_components.repository.PlaneOwnedRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaneOwnedService {

    @Autowired
    private final PlaneOwnedRepository planeOwnedRepository;

    public PlaneOwned savePlaneOwned(PlaneOwned planeOwned){
        /*
        TODO:
            Add prices to planes.csv and validate that the user has the balance to afford the plane.
            Take money from balance when buying plane
         */
        return planeOwnedRepository.save(planeOwned);
    }
}
