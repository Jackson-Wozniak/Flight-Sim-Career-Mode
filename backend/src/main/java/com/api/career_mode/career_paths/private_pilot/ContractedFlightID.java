package com.api.career_mode.career_paths.private_pilot;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ContractedFlightID implements Serializable {

    private String pilotUsername;

    @Column(name = "flight_index")
    private Long flightIndex;
}
