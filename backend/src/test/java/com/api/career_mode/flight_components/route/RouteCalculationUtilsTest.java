package com.api.career_mode.flight_components.route;

import com.api.career_mode.flight_components.airport.Airport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteCalculationUtilsTest {

    private static final Airport firstTestAirport = new Airport(
            "KJFK",
            "JFK Airport",
            "Large",
            40.6413,
            73.7781,
            "US",
            "NA");
    private static final Airport secondTestAirport = new Airport(
            "KBOS",
            "Logan International Airport",
            "Large",
            42.3656,
            71.0096,
            "US",
            "NA");

    @Test
    void routeDistanceCalculatesCorrectly(){
        //used https://www.calculator.net/distance-calculator.html to test
        assertEquals(186, (int) RouteCalculationUtils.calculateRouteDistanceInMiles(
                firstTestAirport, secondTestAirport));
    }

    @Test
    void routeDurationCalculatesCorrectly(){
        double flightDuration = RouteCalculationUtils.calculateRouteDistanceInMiles(
                firstTestAirport, secondTestAirport);
        int planeSpeedInKnots = 100;
        //used https://www.calculatorsoup.com/calculators/math/speed-distance-time-calculator.php to test
        assertEquals(1.62, RouteCalculationUtils.calculateFlightHours(planeSpeedInKnots, flightDuration));
    }
}