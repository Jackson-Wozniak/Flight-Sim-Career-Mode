package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.FlightStory;
import com.api.career_mode.flight_components.route.Route;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PrivatePilotFlightDto {

    private Integer flightIndex;
    private Boolean isCurrentFlight;
    private Route route;
    private FlightStory flightStory;
}
