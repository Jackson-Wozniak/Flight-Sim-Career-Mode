package com.api.career_mode.flight_components.dto;

import com.api.career_mode.flight_components.dto.AirportDto;
import com.api.career_mode.flight_components.dto.PlaneDto;
import com.api.career_mode.flight_components.entity.Route;
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
