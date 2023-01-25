package com.api.career_mode.pilot.controller;

import com.api.career_mode.pilot.entity.ConfirmationToken;
import com.api.career_mode.pilot.entity.Pilot;
import com.api.career_mode.pilot.payload.PilotCreatorRequest;
import com.api.career_mode.pilot.service.ConfirmationTokenService;
import com.api.career_mode.pilot.service.PilotService;
import com.api.career_mode.pilot.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/pilot")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class PilotController {

    @Autowired
    private final PilotService pilotService;
    @Autowired
    private final RegistrationService registrationService;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final ConfirmationTokenService confirmationTokenService;

    @GetMapping(value = "/count")
    public long getTotalAmountOfPilots(){
        return pilotService.findPilotCount();
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerNewPilot(@RequestBody PilotCreatorRequest pilotCreatorRequest){
        try{
            String jwtToken = registrationService.register(pilotCreatorRequest);
            return ResponseEntity.ok(jwtToken);
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/login")
    public ResponseEntity<?> loginAsUser(@RequestParam("username") String username,
                                         @RequestParam("password") String password){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username, password));

            ConfirmationToken confirmationToken = confirmationTokenService.createConfirmationToken(
                    (Pilot) pilotService.loadUserByUsername(authentication.getName()));

            confirmationTokenService.saveConfirmationToken(confirmationToken);

            return ResponseEntity.ok(confirmationToken.getToken());
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/confirm")
    public ResponseEntity<?> confirmUserToken(@RequestParam("token") String token){
        try{
            registrationService.confirmToken(token);
            return ResponseEntity.ok("Token Validated");
        }catch (Exception ex){
            return new ResponseEntity<>("Invalid Configuration Token: " +
                    ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
