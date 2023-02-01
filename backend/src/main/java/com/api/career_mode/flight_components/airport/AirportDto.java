package com.api.career_mode.flight_components.airport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportDto {

    private String icaoCode;
    private String airportSize;
    private String airportName;
    private double latitude;
    private double longitude;
    private String country;
    private String continent;

    public AirportDto(Airport airport){
        this.icaoCode = airport.getIcaoCode();
        this.airportSize = airport.getAirportSize();
        this.airportName = airport.getAirportName();
        this.latitude = airport.getLatitude();
        this.longitude = airport.getLongitude();
        this.country = airport.getCountry();
        this.continent = airport.getContinent();
    }
}
