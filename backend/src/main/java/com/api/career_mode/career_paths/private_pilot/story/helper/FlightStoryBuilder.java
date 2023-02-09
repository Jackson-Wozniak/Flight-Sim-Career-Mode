package com.api.career_mode.career_paths.private_pilot.story.helper;

import com.api.career_mode.career_paths.private_pilot.story.entity.Cargo;
import com.api.career_mode.career_paths.private_pilot.story.entity.FlightStory;
import com.api.career_mode.career_paths.private_pilot.story.entity.Narrative;
import com.api.career_mode.career_paths.private_pilot.story.utils.FlightStoryCalculator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class FlightStoryBuilder {

    @Autowired
    private final NarrativeBuilder narrativeBuilder;
    @Autowired
    private final CargoSelection cargoSelection;
    private static final Random random = new Random();

    public FlightStory buildStory(double flightDistance){
        Cargo randomCargo = cargoSelection.findRandomCargo();
        Narrative narrative = narrativeBuilder.createNewNarrative(randomCargo);
        int cargoCapacity = random.nextInt(1000);
        return new FlightStory(
                narrative,
                randomCargo,
                cargoCapacity,
                FlightStoryCalculator.calculateFlightPayout(randomCargo, cargoCapacity, flightDistance)
        );
    }
}
