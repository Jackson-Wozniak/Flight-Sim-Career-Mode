package com.api.career_mode.career_paths.private_pilot.story.helper;

import com.api.career_mode.career_paths.private_pilot.story.entity.Cargo;
import com.api.career_mode.career_paths.private_pilot.story.properties.DefaultCargo;
import com.api.career_mode.career_paths.private_pilot.story.service.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/*
Class to randomly choose cargo for story. Generates a random number and selects the cargo
    based on % chance
 */
@Component
@AllArgsConstructor
public class CargoSelection {

    @Autowired
    private final CargoService cargoService;
    private static final Random random = new Random();

    public Cargo findRandomCargo(){
        int randomNumber = random.nextInt(1, 100);
        return findDefaultCargoByPercentChance(randomNumber);
    }

    private Cargo findDefaultCargoByPercentChance(int randomNumber){
        if(randomNumber > 0 && randomNumber <=2){
            return DefaultCargo.getDefaultCargoByName("gold");
        }
        if(randomNumber <= 10){
            return DefaultCargo.getDefaultCargoByName("Automotive Parts");
        }
        if(randomNumber <= 40){
            return DefaultCargo.getDefaultCargoByName("CDs");
        }
        if(randomNumber <= 70){
            return DefaultCargo.getDefaultCargoByName("Lumber");
        }
        if(randomNumber <= 100){
            return DefaultCargo.getDefaultCargoByName("Steel");
        }
        //returns default cargo if random number is not matched
        return DefaultCargo.getDefaultCargoByName("");
    }


    private Cargo findCargoByPercentChance(int randomNumber){
        if(randomNumber > 0 && randomNumber <=2){
            return cargoService.findCargoByName("gold");
        }
        if(randomNumber <= 10){
            return cargoService.findCargoByName("Automotive Parts");
        }
        if(randomNumber <= 40){
            return cargoService.findCargoByName("CDs");
        }
        if(randomNumber <= 70){
            return cargoService.findCargoByName("Lumber");
        }
        if(randomNumber <= 100){
            return cargoService.findCargoByName("Steel");
        }
        //returns default cargo if random number is not matched
        return cargoService.findCargoByName("");
    }
}
