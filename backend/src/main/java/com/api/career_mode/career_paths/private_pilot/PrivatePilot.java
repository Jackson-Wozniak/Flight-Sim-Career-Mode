package com.api.career_mode.career_paths.private_pilot;

import com.api.career_mode.flight_components.plane.Plane;
import com.api.career_mode.flight_components.plane.PlaneOwned;
import com.api.career_mode.pilot.entity.Pilot;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
Entity that tracks progress for private pilot path. Includes XP, Flights, Stats/Achievements etc
 */
@Entity(name = "privatePilot")
@Table(name = "private_pilot")
@Getter
@Setter
@NoArgsConstructor
public class PrivatePilot {

    @Id
    private String username;

    @MapsId
    @OneToOne
    @JoinColumn(name = "username")
    @JsonBackReference
    private Pilot pilot;

    @Column(name = "level", columnDefinition = "integer default 1")
    private Integer level;

    @Column(name = "rep_to_next_level", columnDefinition = "integer default 100")
    private Integer reputationToNextLevel;

    @Column(name = "balance", columnDefinition = "double default 0.0")
    private Double balance;

    @OneToMany(mappedBy = "privatePilot")
    private List<PrivatePilotFlight> flights;

    @Column(name = "current_flight_activated")
    private Boolean currentFlightActivated;

    @OneToMany(mappedBy = "privatePilot")
    private List<PlaneOwned> planesOwned;

    public PrivatePilot(Pilot pilot) {
        this.pilot = pilot;
        this.level = 1;
        this.reputationToNextLevel = 100;
        this.balance = 0.0;
        this.currentFlightActivated = false;
    }

    //Level up pilot and update the new reputation tracker to next level
    public void levelUpPilot(){
        this.level += 1;
        this.reputationToNextLevel = PrivatePilotUtils.findReputationToNextLevel(this.level);
    }

    public void updateBalance(double addedPayout){
        this.balance += addedPayout;
    }
}
