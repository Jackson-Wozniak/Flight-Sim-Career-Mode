package com.api.career_mode.flight_components.route;

import com.api.career_mode.flight_components.airport.AirportDto;
import com.api.career_mode.flight_components.plane.PlaneDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteDto {

    private PlaneDto plane;
    private AirportDto departureAirport;
    private AirportDto destinationAirport;
    private double routeDistanceInMiles;
    private double routeDurationInHours;

    public RouteDto(Route route){
        this.plane = new PlaneDto(route.getPlane());
        this.departureAirport = new AirportDto(route.getDepartureAirport());
        this.destinationAirport = new AirportDto(route.getDestinationAirport());
        this.routeDistanceInMiles = route.getRouteDistanceInMiles();
        this.routeDurationInHours = route.getRouteDurationInHours();
    }
}
