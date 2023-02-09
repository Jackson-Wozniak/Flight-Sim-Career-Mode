package com.api.career_mode.career_paths.private_pilot.story.entity;

import com.api.career_mode.career_paths.private_pilot.story.cargo.CargoType;
import com.api.career_mode.career_paths.private_pilot.story.utils.FlightStoryCalculator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class FlightStory {

    @Embedded
    private Narrative narrative;

    @Enumerated(EnumType.STRING)
    private CargoType cargoType;

    @Column(name = "weight_of_cargo_pounds")
    private Double weightOfCargoInPounds;
    
    @Column(name = "flight_payout_usd")
    private Double flightPayoutInUSD;
    
    public FlightStory(Narrative narrative, Cargo cargo, double cargoWeight, double flightDistance){
        this.narrative = narrative;
        this.cargoType = CargoType.mapCargoToType(cargo);
        this.weightOfCargoInPounds = cargoWeight;
        this.flightPayoutInUSD = FlightStoryCalculator.calculateFlightPayout(
                cargo, cargoWeight, flightDistance);
    }
}
