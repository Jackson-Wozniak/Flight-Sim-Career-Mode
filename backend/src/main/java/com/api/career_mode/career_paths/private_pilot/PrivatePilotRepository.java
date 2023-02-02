package com.api.career_mode.career_paths.private_pilot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import jakarta.transaction.Transactional;

public interface PrivatePilotRepository extends JpaRepository<PrivatePilot, String> {

    @Transactional
    @Modifying
    @Query("UPDATE privatePilot p " +
            "SET p.flightsAssigned= ?1 " +
            "WHERE username= ?2")
    void updateFlightsAssigned(long flightsAssigned, String username);
}
