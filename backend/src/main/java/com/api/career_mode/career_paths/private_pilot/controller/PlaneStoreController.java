package com.api.career_mode.career_paths.private_pilot.controller;

import com.api.career_mode.career_paths.private_pilot.entity.PrivatePilot;
import com.api.career_mode.flight_components.entity.Plane;
import com.api.career_mode.flight_components.entity.PlaneOwned;
import com.api.career_mode.flight_components.service.PlaneOwnedService;
import com.api.career_mode.flight_components.service.PlaneService;
import com.api.career_mode.pilot.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/pilot/private/plane/store")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class PlaneStoreController {

    @Autowired
    private final PlaneService planeService;
    @Autowired
    private final PlaneOwnedService planeOwnedService;
    @Autowired
    private final RegistrationService registrationService;

    @PostMapping(value = "/{planeToBuy}")
    public ResponseEntity<?> buyPlane(@PathVariable("planeToBuy") String planeToBuy,
                                   @RequestParam("token") String token){
        try{
            PrivatePilot pilot = registrationService.confirmToken(token).getPrivatePilot();
            Plane plane = planeService.findPlaneByName(planeToBuy.replace("_", " "));
            return ResponseEntity.ok(planeOwnedService.savePlaneOwned(new PlaneOwned(pilot, plane)));
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
