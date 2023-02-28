package com.api.career_mode.career_paths.private_pilot.controller;

import com.api.career_mode.career_paths.private_pilot.dto.PrivatePilotDTO;
import com.api.career_mode.career_paths.private_pilot.dto.ContractedFlightDTO;
import com.api.career_mode.career_paths.private_pilot.entity.ContractedFlight;
import com.api.career_mode.career_paths.private_pilot.entity.PrivatePilot;
import com.api.career_mode.career_paths.private_pilot.enums.FlightOutcomes;
import com.api.career_mode.career_paths.private_pilot.helper.ContractedFlightGenerator;
import com.api.career_mode.career_paths.private_pilot.helper.ContractedFlightHandler;
import com.api.career_mode.career_paths.private_pilot.service.ContractedFlightService;
import com.api.career_mode.pilot.entity.Pilot;
import com.api.career_mode.pilot.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/pilot/private")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class PrivatePilotController {

    @Autowired
    private final RegistrationService registrationService;
    @Autowired
    private final ContractedFlightService contractedFlightService;
    @Autowired
    private final ContractedFlightGenerator contractedFlightGenerator;
    @Autowired
    private final ContractedFlightHandler contractedFlightHandler;

    @RequestMapping
    public ResponseEntity<?> getPilotByToken(@RequestParam("token") String token){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            PrivatePilotDTO privatePilot = new PrivatePilotDTO(pilot.getPrivatePilot());
            return ResponseEntity.ok(privatePilot);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/flights")
    public ResponseEntity<?> getAllFlightsByPilot(@RequestParam("token") String token){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            List<ContractedFlightDTO> flightDTOs = contractedFlightService.findAllFlightsByPilot(
                            pilot.getPrivatePilot()).stream()
                    .map(ContractedFlightDTO::new).toList();
            return ResponseEntity.ok(flightDTOs);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/flights/active")
    public ResponseEntity<?> getActiveFlightsByPilot(@RequestParam("token") String token){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            return ResponseEntity.ok(new ContractedFlightDTO(
                    contractedFlightService.findActivePrivateFlight(pilot.getPrivatePilot())
            ));
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/flights/active")
    public void assignActiveFlight(@RequestParam("token") String token,
                                   @RequestParam("flightIndex") long flightIndex){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            contractedFlightService.assignActiveFlightToPilot(pilot.getPrivatePilot(), flightIndex);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @PutMapping(value = "/flights/complete")
    public void completeFlight(@RequestParam("token") String token,
                               @RequestParam("flightIndex") long flightIndex,
                               @RequestParam("outcome") String outcome){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            contractedFlightHandler.handleFlight(
                    pilot.getPrivatePilot(),
                    flightIndex,
                    FlightOutcomes.mapStringToOutcome(outcome));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @PostMapping(value = "/flights")
    public ResponseEntity<?> addToNewFlight(@RequestParam("token") String token){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            contractedFlightService.savePrivatePilotFlight(
                    contractedFlightGenerator.generateFlight(pilot.getPrivatePilot())
            );
            return ResponseEntity.ok("Flight Created");
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/flights/{flightsToCreate}")
    public ResponseEntity<?> addMultipleFlights(@RequestParam("token") String token, @PathVariable("flightsToCreate") String flightsToCreate){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            contractedFlightService.savePrivatePilotFlights(
                    contractedFlightGenerator.generateMultipleFlights(
                            pilot.getPrivatePilot(),
                            Integer.parseInt(flightsToCreate)));
            return ResponseEntity.ok("Flights Created");
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
