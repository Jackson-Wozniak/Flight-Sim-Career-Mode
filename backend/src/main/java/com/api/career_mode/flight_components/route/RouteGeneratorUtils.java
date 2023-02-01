package com.api.career_mode.flight_components.route;

import com.api.career_mode.flight_components.airport.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RouteGeneratorUtils {

    @Autowired
    private final AirportService airportService;
}
