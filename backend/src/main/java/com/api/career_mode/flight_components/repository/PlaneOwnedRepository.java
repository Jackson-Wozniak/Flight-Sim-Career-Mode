package com.api.career_mode.flight_components.repository;

import com.api.career_mode.flight_components.entity.PlaneOwned;
import com.api.career_mode.flight_components.entity.PlaneOwnedId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneOwnedRepository extends JpaRepository<PlaneOwned, PlaneOwnedId> {
}
