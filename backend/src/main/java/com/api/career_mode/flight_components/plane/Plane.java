package com.api.career_mode.flight_components.plane;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "plane")
@Table(name = "planes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plane {

    @Id
    @Column(name = "plane_name")
    private String planeName;

    @Column(name = "cruising_speed_knots")
    private Integer cruisingSpeedInKnots;

    @Column(name = "range_miles")
    private Integer rangeInMiles;

    @Enumerated(EnumType.STRING)
    @Column(name = "plane_type")
    private PlaneType planeType;
}
