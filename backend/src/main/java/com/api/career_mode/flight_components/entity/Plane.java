package com.api.career_mode.flight_components.entity;

import com.api.career_mode.flight_components.enums.PlaneType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity(name = "plane")
@Table(name = "planes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plane implements Serializable {

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
