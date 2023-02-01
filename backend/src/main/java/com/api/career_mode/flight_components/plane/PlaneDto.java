package com.api.career_mode.flight_components.plane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaneDto {

    private String planeName;
    private int cruisingSpeedInKnots;
    private int rangeInMiles;
    private PlaneType planeType;

    public PlaneDto(Plane plane){
        this.planeName = plane.getPlaneName();
        this.cruisingSpeedInKnots = plane.getCruisingSpeedInKnots();
        this.rangeInMiles = plane.getRangeInMiles();
        this.planeType = plane.getPlaneType();
    }
}
