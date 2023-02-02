package com.api.career_mode.flight_components.airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, String> {

    @Query(value = "SELECT * FROM airports a " +
            "WHERE a.country=:country", nativeQuery = true)
    List<Airport> findAllAirportsByCountry();
}
