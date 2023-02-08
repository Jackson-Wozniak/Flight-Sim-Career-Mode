package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.FlightStoryDto;
import com.api.career_mode.flight_components.dto.RouteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ContractedFlightDTO implements Serializable {

    private long flightIndex;
    private boolean isCurrentFlight;
    private RouteDto route;
    private FlightStoryDto flightStory;

    public ContractedFlightDTO(ContractedFlight flight){
        this.flightIndex = flight.getId().getFlightIndex();
        this.isCurrentFlight = flight.getIsCurrentFlight();
        this.route = new RouteDto(flight.getRoute());
        this.flightStory = new FlightStoryDto(flight.getFlightStory(), flight);
    }
}