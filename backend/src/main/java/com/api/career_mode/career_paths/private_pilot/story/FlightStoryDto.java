package com.api.career_mode.career_paths.private_pilot.story;

import com.api.career_mode.career_paths.private_pilot.PrivatePilotFlight;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightStoryDto {

    private String narrative;
    private CargoDto cargo;
    private double weightOfCargoInPounds;
    private double flightPayoutInUSD;

    public FlightStoryDto(FlightStory flightStory, PrivatePilotFlight flight){
        this.narrative = NarrativeDtoMapper.mapNarrative(flightStory.getNarrative(), flight);
        this.cargo = new CargoDto(flightStory.getCargo());
        this.weightOfCargoInPounds = flightStory.getWeightOfCargoInPounds();
        this.flightPayoutInUSD = flightStory.getFlightPayoutInUSD();
    }
}
