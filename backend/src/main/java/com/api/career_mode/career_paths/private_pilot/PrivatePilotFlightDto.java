package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.FlightStory;
import com.api.career_mode.career_paths.private_pilot.story.FlightStoryDto;
import com.api.career_mode.flight_components.route.Route;
import com.api.career_mode.flight_components.route.RouteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class PrivatePilotFlightDto implements Serializable {

    private int flightIndex;
    private boolean isCurrentFlight;
    private RouteDto route;
    private FlightStoryDto flightStory;

    public PrivatePilotFlightDto(PrivatePilotFlight flight){
        this.flightIndex = flight.getId().getFlightIndex();
        this.isCurrentFlight = flight.getIsCurrentFlight();
        this.route = new RouteDto(flight.getRoute());
        this.flightStory = new FlightStoryDto(flight.getFlightStory(), flight);
    }
}
