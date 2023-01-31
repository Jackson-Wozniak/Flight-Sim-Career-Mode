package com.api.career_mode.career_paths.private_pilot.story;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CargoService {

    @Autowired
    private final CargoRepository cargoRepository;


    public long findCargoRowCount(){
        return cargoRepository.count();
    }
}
