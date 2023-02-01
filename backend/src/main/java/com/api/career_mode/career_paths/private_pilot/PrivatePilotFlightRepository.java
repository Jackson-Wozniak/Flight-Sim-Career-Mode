package com.api.career_mode.career_paths.private_pilot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrivatePilotFlightRepository extends JpaRepository<PrivatePilotFlight, PrivatePilotFlightId> {

    @Query(value = "SELECT * FROM private_pilot_flights p " +
            "WHERE p.private_pilot_username=:username", nativeQuery = true)
    List<PrivatePilotFlight> findAllFlightsByPilot(String username);
}
