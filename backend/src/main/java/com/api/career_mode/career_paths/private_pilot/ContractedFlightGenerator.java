package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.career_paths.private_pilot.story.FlightStory;
import com.api.career_mode.career_paths.private_pilot.story.FlightStoryBuilder;
import com.api.career_mode.flight_components.entity.Airport;
import com.api.career_mode.flight_components.entity.Plane;
import com.api.career_mode.flight_components.entity.Route;
import com.api.career_mode.flight_components.helper.RouteGenerator;
import com.api.career_mode.flight_components.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class ContractedFlightGenerator {

    @Autowired
    private final RouteGenerator routeGenerator;
    @Autowired
    private final FlightStoryBuilder flightStoryBuilder;
    @Autowired
    private final PrivatePilotService privatePilotService;
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
    public ContractedFlight generateFlight(PrivatePilot pilot){
        testPilotValidation(pilot);

        ContractedFlightID id = new ContractedFlightID(pilot.getUsername(), pilot.getFlightsAssigned());

        Plane chosenPlane = pilot.getPlanesOwned().get(random.nextInt(pilot.getPlanesOwned().size())).getPlane();
        Route route = routeGenerator.generateRoute(chosenPlane);
        FlightStory flightStory = flightStoryBuilder.buildStory(route.getRouteDistanceInMiles());

        pilot.incrementFlightAssigned();
        privatePilotService.updatePilot(pilot);

        return new ContractedFlight(
                id,
                false,
                pilot,
                route,
                flightStory
        );
    }

    public List<ContractedFlight> generateMultipleFlights(PrivatePilot pilot,
                                                          int flightsToCreate){
        testPilotValidation(pilot, flightsToCreate);
        List<ContractedFlight> createdFlights = new ArrayList<>();
        List<Airport> airports = airportService.findAllAirports();
        for(int i = 0; i < flightsToCreate; i++){
            ContractedFlightID id = new ContractedFlightID(pilot.getUsername(), pilot.getFlightsAssigned());

            Plane chosenPlane = pilot.getPlanesOwned().get(random.nextInt(pilot.getPlanesOwned().size())).getPlane();
            Route route = routeGenerator.generateRoute(airports, chosenPlane);
            FlightStory flightStory = flightStoryBuilder.buildStory(route.getRouteDistanceInMiles());

            pilot.incrementFlightAssigned();
            createdFlights.add(new ContractedFlight(
                    id,
                    false,
                    pilot,
                    route,
                    flightStory
            ));
        }
        privatePilotService.updatePilot(pilot);
        return createdFlights;
    }

    //this method is created so that I can easily add other validation fields if needed in the future
    private static void testPilotValidation(PrivatePilot privatePilot){
        if(privatePilot.getPlanesOwned().size() < 1){
            throw new PrivatePilotException("Invalid Flight: Not Enough Planes owned");
        }
        if(privatePilot.getFlights().size() >= 10){
            throw new FlightCreationException("Cannot create flight: maximum flights offered");
        }
    }

    private static void testPilotValidation(PrivatePilot privatePilot, int flightsToCreate){
        if(privatePilot.getPlanesOwned().size() < 1){
            throw new PrivatePilotException("Invalid Flight: Not Enough Planes owned");
        }
        if(privatePilot.getFlights().size() + flightsToCreate > 10){
            throw new FlightCreationException("Cannot create flight: maximum flights offered");
        }
    }
}
