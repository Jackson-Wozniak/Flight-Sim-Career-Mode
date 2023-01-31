package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.pilot.entity.Pilot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
public class PrivatePilotId implements Serializable {

    private String pilotUsername;

    @Column(name = "flight_index")
    private Integer flightIndex;
}
