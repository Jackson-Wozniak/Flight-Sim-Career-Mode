package com.api.career_mode.career_paths.private_pilot.story;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "narrative")
@Table(name = "narratives")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Narrative {

    @Id
    private String narrative;

    @Column(name = "related_cargo")
    private String relatedCargoName;
}
