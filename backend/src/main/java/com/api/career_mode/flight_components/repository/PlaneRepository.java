package com.api.career_mode.flight_components.repository;

import com.api.career_mode.flight_components.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, String> {
}
