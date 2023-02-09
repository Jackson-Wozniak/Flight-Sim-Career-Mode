package com.api.career_mode.career_paths.private_pilot.story.configuration;

import com.api.career_mode.career_paths.private_pilot.story.service.CargoService;
import com.api.career_mode.career_paths.private_pilot.story.properties.DefaultCargo;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CargoConfiguration {

    @Autowired
    private final CargoService cargoService;
    private static final Logger logger = LoggerFactory.getLogger(CargoConfiguration.class);

    @PostConstruct
    public void saveAllDefaultCargoOnStartup(){
        if(DefaultCargo.getAllDefaultCargo().size() != cargoService.findCargoRowCount()){
            logger.info("Saving Cargo");
            cargoService.deleteAllCargo();
            cargoService.saveAllDefaultCargo();
        }
        logger.info(cargoService.findCargoRowCount() + " Cargo In Database");
    }
}
