package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.FlightStory;
import com.api.career_mode.flight_components.entity.Plane;
import com.api.career_mode.flight_components.entity.Route;
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
    private PrivatePilotFlightId id;

    //keep track of what flight is active, and allow for that one to be displayed to user seperately
    //from available flights
    @Column(name = "is_current_flight")
    private Boolean isCurrentFlight;

    @MapsId(value = "pilotUsername")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private PrivatePilot privatePilot;

    @Embedded
    private Route route;

    @Embedded
    private FlightStory flightStory;

    public void chooseNewPlane(Plane plane){
        if(plane.getRangeInMiles() < route.getRouteDistanceInMiles()){
            throw new FlightCreationException(
                    "Cannot alter flight: Route distance cannot be " +
                    "larger value than plane range");
        }
        this.route.setPlane(plane);
    }
}
