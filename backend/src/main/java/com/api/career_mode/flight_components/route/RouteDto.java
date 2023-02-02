package com.api.career_mode.flight_components.route;

import com.api.career_mode.flight_components.airport.AirportDto;
import com.api.career_mode.flight_components.plane.PlaneDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteDto {

    private PlaneDto plane;
    private AirportDto departure;
    private AirportDto destination;
    private double distanceInMiles;
    private double durationInHours;

    public RouteDto(Route route){
        this.plane = new PlaneDto(route.getPlane());
        this.departure = new AirportDto(route.getDepartureAirport());
        this.destination = new AirportDto(route.getDestinationAirport());
        this.distanceInMiles = route.getRouteDistanceInMiles();
        this.durationInHours = route.getRouteDurationInHours();
    }
}
