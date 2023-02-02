package com.api.career_mode.career_paths.private_pilot.story;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/*
Class for building random narratives. Generates the chosen narrative randomly from text file
 */
@Service
@AllArgsConstructor
public class NarrativeBuilder {

    @Autowired
    private final CargoSelection cargoSelection;
    private static final Random random = new Random();

    public Narrative createNewNarrative(){
        Cargo randomCargo = cargoSelection.findRandomCargo();
        long randomLine = random.nextLong(randomCargo.getTextFileLines());
        return new Narrative(randomCargo.getCargoName(), randomLine);
    }

    public Narrative createNewNarrative(Cargo cargo){
        //Replace when stories are written
        long randomLine;
        if(cargo.getTextFileLines() < 1){
            randomLine = 1;
        }else{
            randomLine = random.nextLong(cargo.getTextFileLines());
        }
        return new Narrative(cargo.getCargoName(), randomLine);
    }
}
