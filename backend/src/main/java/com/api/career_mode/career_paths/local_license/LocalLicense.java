package com.api.career_mode.career_paths.local_license;

import com.api.career_mode.pilot.entity.Pilot;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "localLicense")
@Table(name = "local_license")
@Getter
@Setter
@NoArgsConstructor
public class LocalLicense {

    @Id
    private String username;

    @MapsId
    @OneToOne
    @JoinColumn(name = "username")
    @JsonBackReference
    private Pilot pilot;

    public LocalLicense(Pilot pilot) {
        this.pilot = pilot;
    }
}
