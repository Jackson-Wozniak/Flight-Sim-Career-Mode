package com.api.career_mode.career_paths.private_pilot.story;

import com.api.career_mode.career_paths.private_pilot.PrivatePilotFlight;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class NarrativeDtoMapper {

    //This is not the final default narrative
    private static final String defaultNarrative = """
            You have been chosen to fly from {departureAirport}.
    """;

    public static String mapNarrative(Narrative narrative, PrivatePilotFlight flight){
        String generatedNarrative;
        try{
            generatedNarrative = Files.lines(convertCargoNameToFile(
                    narrative.getRelatedCargoName()).toPath())
                    .skip(narrative.getLineNumberInFile())
                    .findFirst().orElse(defaultNarrative);
        }catch (IOException ex){
            generatedNarrative = defaultNarrative;
        }
        return replaceFieldVariables(generatedNarrative, flight);
    }

    public static String replaceFieldVariables(String defaultNarrative, PrivatePilotFlight flight){
        return defaultNarrative
                .replace("{departureAirport}" , flight.getRoute().getDepartureAirport().getAirportName())
                .replace("{destinationAirport}" , flight.getRoute().getDestinationAirport().getAirportName())
                .replace("{planeName}" , flight.getRoute().getPlane().getPlaneName())
                .replace("{flightDistance}" , flight.getRoute().getRouteDistanceInMiles().toString());
    }

    public static File convertCargoNameToFile(String cargoName){
        return new File("data/stories/" + cargoName.toLowerCase() + "-story.txt");
    }
}
