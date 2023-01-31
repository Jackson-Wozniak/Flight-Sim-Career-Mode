package com.api.career_mode.career_paths.private_pilot.story;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class FlightStory {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "narrative")
    private Narrative narrative;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_type")
    private Cargo cargo;

    @Column(name = "weight_of_cargo_pounds")
    private Double weightOfCargoInPounds;
}
