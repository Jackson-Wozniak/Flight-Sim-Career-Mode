package com.api.career_mode.career_paths.private_pilot.story;

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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cargo_type")
    private Cargo cargo;

    @Column(name = "weight_of_cargo_pounds")
    private Double weightOfCargoInPounds;
    
    @Column(name = "flight_payout_usd")
    private Double flightPayoutInUSD;
    
    public FlightStory(Narrative narrative, Cargo cargo, double cargoWeight, double flightDistance){
        this.narrative = narrative;
        this.cargo = cargo;
        this.weightOfCargoInPounds = cargoWeight;
        this.flightPayoutInUSD = FlightStoryCalculator.calculateFlightPayout(
                cargo, cargoWeight, flightDistance);
    }
}
