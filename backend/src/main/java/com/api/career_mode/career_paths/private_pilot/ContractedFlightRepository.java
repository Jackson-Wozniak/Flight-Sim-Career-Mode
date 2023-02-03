package com.api.career_mode.career_paths.private_pilot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContractedFlightRepository extends JpaRepository<ContractedFlight, ContractedFlightID> {

    @Query(value = "SELECT * FROM contracted_flights p " +
            "WHERE p.private_pilot_username=:username", nativeQuery = true)
    List<ContractedFlight> findAllFlightsByPilot(String username);

    @Query(value = "SELECT * FROM contracted_flights p " +
            "WHERE p.private_pilot_username=:username " +
            "AND p.flight_index=:flightIndex", nativeQuery = true)
    Optional<ContractedFlight> findPilotsFlightByIndex(String username, long flightIndex);
}
