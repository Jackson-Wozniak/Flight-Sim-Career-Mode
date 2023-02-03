package com.api.career_mode.flight_components.entity;

import com.api.career_mode.flight_components.utils.RouteCalculationUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Route implements Serializable {

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "plane_name")
    private Plane plane;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "departure_airport")
    private Airport departureAirport;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "destination_airport")
    private Airport destinationAirport;

    @Column(name = "route_duration_hours")
    private Double routeDurationInHours;

    @Column(name = "route_distance_miles")
    private Double routeDistanceInMiles;

    public Route(Plane plane, Airport departureAirport, Airport destinationAirport){
        this.plane = plane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
        this.routeDistanceInMiles = RouteCalculationUtils.calculateRouteDistanceInMiles(
                departureAirport, destinationAirport);
        this.routeDurationInHours = RouteCalculationUtils.calculateFlightHours(
                this.plane.getCruisingSpeedInKnots(), this.routeDistanceInMiles);
    }
}
