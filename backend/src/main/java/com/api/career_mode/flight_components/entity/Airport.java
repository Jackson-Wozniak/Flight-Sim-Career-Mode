package com.api.career_mode.flight_components.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "airport")
@Table(name = "airports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Airport {

    @Id
    @Column(name = "icao_code", nullable = false)
    private String icaoCode;

    @Column(name = "airport_size", nullable = false)
    private String airportSize;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "continent", nullable = false)
    private String continent;
}
