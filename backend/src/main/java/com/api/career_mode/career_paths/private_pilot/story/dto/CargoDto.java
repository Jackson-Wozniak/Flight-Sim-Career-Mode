package com.api.career_mode.career_paths.private_pilot.story.dto;

import com.api.career_mode.career_paths.private_pilot.story.entity.Cargo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoDto {

    private String cargoName;
    private double payoutMultiplier;

    public CargoDto(Cargo cargo){
        this.cargoName = cargo.getCargoName();
        this.payoutMultiplier = cargo.getPayoutMultiplier();
    }
}
