package com.api.career_mode.flight_components.service;

import com.api.career_mode.flight_components.entity.Plane;
import com.api.career_mode.flight_components.exception.PlaneNotFoundException;
import com.api.career_mode.flight_components.repository.PlaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaneService {

    @Autowired
    private final PlaneRepository planeRepository;

    public Plane findPlaneByName(String name){
        return planeRepository.findById(name).orElseThrow(
                () -> new PlaneNotFoundException("No Plane with name " + name));
    }

    public void savePlane(Plane plane){
        planeRepository.save(plane);
    }

    public void saveAllPlanes(List<Plane> planes){
        planeRepository.saveAll(planes);
    }

    @Transactional
    public void deleteAllPlanes(){

    }

    public long findPlaneRowCount(){
        return planeRepository.count();
    }
}
