package com.api.career_mode.flight_components.plane;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaneService {

    @Autowired
    private final PlaneRepository planeRepository;

    public void saveAllPlanes(List<Plane> planes){
        planeRepository.saveAll(planes);
    }

    public long findPlaneRowCount(){
        return planeRepository.count();
    }
}
