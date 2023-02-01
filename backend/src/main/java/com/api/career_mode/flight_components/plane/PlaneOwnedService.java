package com.api.career_mode.flight_components.plane;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaneOwnedService {

    @Autowired
    private final PlaneOwnedRepository planeOwnedRepository;

    public void savePlaneOwned(PlaneOwned planeOwned){
        planeOwnedRepository.save(planeOwned);
    }
}
