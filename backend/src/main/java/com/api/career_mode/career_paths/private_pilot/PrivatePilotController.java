package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.Cargo;
import com.api.career_mode.career_paths.private_pilot.story.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/private-pilot")
@AllArgsConstructor
public class PrivatePilotController {

    @Autowired
    private final CargoService cargoService;

    @RequestMapping
    public List<Cargo> getAllCargo(){
        return cargoService.findAllCargo();
    }
}
