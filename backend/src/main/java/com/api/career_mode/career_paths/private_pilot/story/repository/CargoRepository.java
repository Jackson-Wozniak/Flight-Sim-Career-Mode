package com.api.career_mode.career_paths.private_pilot.story.repository;

import com.api.career_mode.career_paths.private_pilot.story.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, String> {
}
