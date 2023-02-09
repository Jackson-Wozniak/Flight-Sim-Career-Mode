package com.api.career_mode.career_paths.private_pilot.story.dto;

import com.api.career_mode.career_paths.private_pilot.entity.ContractedFlight;
import com.api.career_mode.career_paths.private_pilot.story.utils.NarrativeDtoMapper;
import com.api.career_mode.career_paths.private_pilot.story.entity.FlightStory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightStoryDto {

    private String narrative;
    private String cargo;
    private double cargoWeightInPounds;
    private double payoutInUSD;

    public FlightStoryDto(FlightStory flightStory, ContractedFlight flight){
        this.narrative = NarrativeDtoMapper.mapNarrative(flightStory.getNarrative(), flight);
        this.cargo = flightStory.getCargo().getCargoName();
        this.cargoWeightInPounds = flightStory.getWeightOfCargoInPounds();
        this.payoutInUSD = flightStory.getFlightPayoutInUSD();
    }
}
