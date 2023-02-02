package com.api.career_mode.flight_components.route;

import com.api.career_mode.flight_components.airport.Airport;
import com.api.career_mode.flight_components.airport.AirportService;
import com.api.career_mode.flight_components.plane.Plane;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class RouteGenerator {

    @Autowired
    private final AirportService airportService;
    private final Random random = new Random();

    public Route generateRoute(Plane plane){
        List<Airport> airports = airportService.findAllAirports();
        if(airports.size() < 2){
            throw new RouteGeneratorException("Cannot generate route: Airport persistence error");
        }
        double maxMiles = plane.getRangeInMiles();
        Airport airport1;
        Airport airport2;
        while(true) {
            airport1 = airports.get(random.nextInt(airports.size()));
            airport2 = airports.get(random.nextInt(airports.size()));
            double flightDistanceInMiles = RouteCalculationUtils.calculateRouteDistanceInMiles(
                    airport1, airport2);
            if (flightDistanceInMiles < maxMiles) {
                double flightHours = RouteCalculationUtils.calculateFlightHours(
                        plane.getCruisingSpeedInKnots(), flightDistanceInMiles);
                return new Route(plane, airport1, airport2, flightHours, flightDistanceInMiles);
            }
        }
    }

    public Route generateRoute(List<Airport> airports, Plane plane){
        if(airports.size() < 2){
            throw new RouteGeneratorException("Cannot generate route: Airport persistence error");
        }
        double maxMiles = plane.getRangeInMiles();
        Airport airport1;
        Airport airport2;
        while(true) {
            airport1 = airports.get(random.nextInt(airports.size()));
            airport2 = airports.get(random.nextInt(airports.size()));
            double flightDistanceInMiles = RouteCalculationUtils.calculateRouteDistanceInMiles(
                    airport1, airport2);
            if (flightDistanceInMiles < maxMiles) {
                double flightHours = RouteCalculationUtils.calculateFlightHours(
                        plane.getCruisingSpeedInKnots(), flightDistanceInMiles);
                return new Route(plane, airport1, airport2, flightHours, flightDistanceInMiles);
            }
        }
    }

    public Route generateRouteByCountry(String country, Plane plane){
        List<Airport> airports = airportService.findAllAirportsByCountry(country);
        if(airports.size() < 2){
            throw new RouteGeneratorException(
                    "Cannot generate route: " + country + " does not have enough airports");
        }
        double maxMiles = plane.getRangeInMiles();
        Airport airport1;
        Airport airport2;
        while(true) {
            airport1 = airports.get(random.nextInt(airports.size()));
            airport2 = airports.get(random.nextInt(airports.size()));
            double flightDistanceInMiles = RouteCalculationUtils.calculateRouteDistanceInMiles(
                    airport1, airport2);
            if (flightDistanceInMiles < maxMiles) {
                double flightHours = RouteCalculationUtils.calculateFlightHours(
                        plane.getCruisingSpeedInKnots(), flightDistanceInMiles);
                return new Route(plane, airport1, airport2, flightHours, flightDistanceInMiles);
            }
       }
    }
}
