package com.api.career_mode.career_paths.private_pilot.story;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "cargo")
@Table(name = "cargo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cargo {

    @Id
    private String cargoName;

    @Column(name = "payout_multiplier")
    private Double payoutMultiplier;

    @Column(name = "text_file_lines", columnDefinition = "bigint default 0")
    private Long textFileLines;
}
