package com.api.career_mode.flight_components.plane;

import com.api.career_mode.career_paths.private_pilot.PrivatePilot;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "planeOwned")
@Table(name = "plane_owned")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PlaneOwnedId.class)
public class PlaneOwned {

    @Id
    @JsonIgnore
    private String username;

    @Id
    @JsonIgnore
    private String planeName;

    @MapsId(value = "username")
    @OneToOne
    @JoinColumn(name = "username")
    @JsonBackReference
    private PrivatePilot privatePilot;

    @MapsId(value = "planeName")
    @OneToOne
    @JoinColumn(name = "planeName")
    private Plane plane;

    public PlaneOwned(PrivatePilot privatePilot, Plane plane){
        this.privatePilot = privatePilot;
        this.plane = plane;
        this.planeName = plane.getPlaneName();
        this.username = privatePilot.getUsername();
    }
}
