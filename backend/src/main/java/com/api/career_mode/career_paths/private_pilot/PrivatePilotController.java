package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.Cargo;
import com.api.career_mode.career_paths.private_pilot.story.CargoService;
import com.api.career_mode.career_paths.private_pilot.story.FlightStory;
import com.api.career_mode.career_paths.private_pilot.story.Narrative;
import com.api.career_mode.flight_components.airport.Airport;
import com.api.career_mode.flight_components.airport.AirportService;
import com.api.career_mode.flight_components.plane.*;
import com.api.career_mode.flight_components.route.Route;
import com.api.career_mode.flight_components.route.RouteDto;
import com.api.career_mode.pilot.entity.Pilot;
import com.api.career_mode.pilot.repository.PilotRepository;
import com.api.career_mode.pilot.service.ConfirmationTokenService;
import com.api.career_mode.pilot.service.PilotService;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/pilot/private")
@AllArgsConstructor
public class PrivatePilotController {

    @Autowired
    private final RegistrationService registrationService;
    @Autowired
    private final PrivatePilotFlightService privatePilotFlightService;
    @Autowired
    private final PrivatePilotFlightGenerator privatePilotFlightGenerator;
    @Autowired
    private final PrivatePilotFlightHandler privatePilotFlightHandler;


    @RequestMapping(value = "/flights")
    public ResponseEntity<?> getAllFlightsByPilot(@RequestParam("token") String token){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            List<PrivatePilotFlightDto> flightDTOs = privatePilotFlightService.findAllFlightsByPilot(
                            pilot.getPrivatePilot()).stream()
                    .map(PrivatePilotFlightDto::new).toList();
            return ResponseEntity.ok(flightDTOs);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/flights/active")
    public ResponseEntity<?> getActiveFlightsByPilot(@RequestParam("token") String token){
        try{
            Pilot pilot = registrationService.confirmToken(token);
            return ResponseEntity.ok(new PrivatePilotFlightDto(
                    privatePilotFlightService.findActivePrivateFlight(pilot.getPrivatePilot())
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
            privatePilotFlightService.assignActiveFlightToPilot(pilot.getPrivatePilot(), flightIndex);
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
            privatePilotFlightHandler.handleFlight(
                    pilot.getPrivatePilot(),
                    flightIndex,
                    FlightOutcomes.mapStringToOutcome(outcome));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @PostMapping(value = "/flights")
    public void addToNewFlight(@RequestParam("token") String token){
        Pilot pilot = registrationService.confirmToken(token);
        privatePilotFlightService.savePrivatePilotFlight(
                privatePilotFlightGenerator.generateFlight(pilot.getPrivatePilot())
        );
    }

    //Method used to test the time of api requests for creating flights
    @RequestMapping(value = "test")
    public String test(@RequestParam("token") String token){
        PrivatePilot pilot = registrationService.confirmToken(token).getPrivatePilot();
        Instant start = Instant.now();
        List<PrivatePilotFlight> flights = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            flights.add(privatePilotFlightGenerator.generateFlight(pilot));
        }
        Instant end = Instant.now();
        List<PrivatePilotFlightDto> flightDtos = flights.stream().map(PrivatePilotFlightDto::new).toList();
        Instant finalTime = Instant.now();
        return "Start to finish: " + (Duration.between(start, finalTime).toMillis() / 1000.00) + ". " +
                "End to final : " + (Duration.between(end, finalTime).toMillis() / 1000.00);
    }
}
