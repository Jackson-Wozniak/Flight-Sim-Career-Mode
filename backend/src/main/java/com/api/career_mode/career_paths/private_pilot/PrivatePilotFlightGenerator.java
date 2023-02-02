package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.FlightStory;
import com.api.career_mode.career_paths.private_pilot.story.FlightStoryBuilder;
import com.api.career_mode.career_paths.private_pilot.story.NarrativeBuilder;
import com.api.career_mode.flight_components.airport.Airport;
import com.api.career_mode.flight_components.airport.AirportService;
import com.api.career_mode.flight_components.plane.Plane;
import com.api.career_mode.flight_components.route.Route;
import com.api.career_mode.flight_components.route.RouteGenerator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class PrivatePilotFlightGenerator {

    @Autowired
    private final RouteGenerator routeGenerator;
    @Autowired
    private final FlightStoryBuilder flightStoryBuilder;
    @Autowired
    private final PrivatePilotRepository privatePilotRepository;
    @Autowired
    private final AirportService airportService;

    private static final Random random = new Random();

    /*TODO:
        When creating more than 1 flight at a time, get all the airports/cargo etc. first, and pass
            the lists as params that will be reused for each flight creation, as opposed to
            fetching for the list each time, reducing SQL query time
        Also save pilot to DB after all flights are created, instead of saving it each time
            the flightsAssigned is incremented
     */
    public PrivatePilotFlight generateFlight(PrivatePilot pilot){
        if(!isPilotValid(pilot)) throw new FlightCreationException("Cannot create flight: invalid Pilot");

        PrivatePilotFlightId id = new PrivatePilotFlightId(pilot.getUsername(), pilot.getFlightsAssigned());

        Plane chosenPlane = pilot.getPlanesOwned().get(random.nextInt(pilot.getPlanesOwned().size())).getPlane();
        Route route = routeGenerator.generateRoute(chosenPlane);
        FlightStory flightStory = flightStoryBuilder.buildStory(route.getRouteDistanceInMiles());

        pilot.incrementFlightAssigned();
        privatePilotRepository.save(pilot);

        return new PrivatePilotFlight(
                id,
                false,
                pilot,
                route,
                flightStory
        );
    }

    //this method is created so that I can easily add other validation fields if needed in the future
    private boolean isPilotValid(PrivatePilot privatePilot){
        return privatePilot.getPlanesOwned().size() >= 1;
    }
}
