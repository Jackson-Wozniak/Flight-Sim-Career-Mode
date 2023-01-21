package com.api.career_mode.pilot.repository;

import com.api.career_mode.pilot.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PilotRepository extends JpaRepository<Pilot, String> {

    @Transactional
    @Modifying
    @Query("UPDATE pilot p " +
            "SET p.enabled = TRUE WHERE p.username =:username")
    int enablePilot(String username);
}
