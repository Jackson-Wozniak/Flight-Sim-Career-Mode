package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.FlightStory;
import com.api.career_mode.flight_components.route.Route;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "privatePilotFlight")
@Table(name = "private_pilot_flights")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PrivatePilotFlight {

    @EmbeddedId
    private PrivatePilotId id;

    @MapsId(value = "pilotUsername")
    @ManyToOne(cascade = CascadeType.ALL)
    private PrivatePilot privatePilot;

    @Embedded
    private Route route;

    @Embedded
    private FlightStory flightStory;
}
