package com.api.career_mode.career_paths.private_pilot.story.service;

import com.api.career_mode.career_paths.private_pilot.story.properties.DefaultCargo;
import com.api.career_mode.career_paths.private_pilot.story.entity.Cargo;
import com.api.career_mode.career_paths.private_pilot.story.repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CargoService {

    @Autowired
    private final CargoRepository cargoRepository;

    public Cargo findCargoByName(String cargoName){
        return cargoRepository.findById(cargoName).orElse(DefaultCargo.getDefaultCargoByName(cargoName));
    }

    public List<Cargo> findAllCargo(){
        return cargoRepository.findAll();
    }

    public void saveAllDefaultCargo(){
        cargoRepository.saveAll(DefaultCargo.getAllDefaultCargo());
    }

    @Transactional
    public void deleteAllCargo(){
        cargoRepository.deleteAll();
    }

    public long findCargoRowCount(){
        return cargoRepository.count();
    }
}
