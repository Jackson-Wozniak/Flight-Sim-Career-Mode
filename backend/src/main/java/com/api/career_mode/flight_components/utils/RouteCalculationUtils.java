package com.api.career_mode.flight_components.utils;

import com.api.career_mode.flight_components.entity.Airport;
import com.api.career_mode.flight_components.exception.RouteGeneratorException;

public class RouteCalculationUtils {

    //Haversine formula for finding distance w/- coordinates
    public static double calculateRouteDistanceInMiles(Airport departure, Airport destination){
        if(departure == null || destination == null){
            throw new RouteGeneratorException("flight time could not be calculated");
        }

        double latitude1 = Math.toRadians(departure.getLatitude());
        double longitude1 = Math.toRadians(departure.getLongitude());
        double latitude2 = Math.toRadians(destination.getLatitude());
        double longitude2 = Math.toRadians(destination.getLongitude());

        double differenceInLongitude = longitude2 - longitude1;
        double differenceInLatitude = latitude2 - latitude1;

        double a = Math.pow(Math.sin(differenceInLatitude / 2), 2)
                + Math.cos(latitude1) * Math.cos(latitude2)
                * Math.pow(Math.sin(differenceInLongitude / 2),2);

        return Math.round(((3956) * (2 * Math.asin(Math.sqrt(a)))) * 100.00) / 100.00;
    }

    public static double calculateFlightHours(int planeSpeedInKnots, double flightDistanceInMiles){
        double planeSpeedInMph = planeSpeedInKnots * 1.15077945;
        return Math.round((flightDistanceInMiles/planeSpeedInMph) * 100.00) / 100.00;
    }

    public static String convertHoursToHHmm(double flightHours) {
        double flightMinutes = flightHours * 60;
        double hours = flightMinutes / 60;
        double minutes = flightMinutes % 60;
        return String.format("%02d:%02d", (int) Math.floor(hours), Math.round(minutes));
    }
}
