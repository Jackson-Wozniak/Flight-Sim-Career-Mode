package com.api.career_mode.flight_components.plane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaneDto {

    private String name;
    private int cruisingSpeedInKnots;
    private int rangeInMiles;
    private String type;

    public PlaneDto(Plane plane){
        this.name = plane.getPlaneName();
        this.cruisingSpeedInKnots = plane.getCruisingSpeedInKnots();
        this.rangeInMiles = plane.getRangeInMiles();
        this.type = plane.getPlaneType().toString();
    }
}
