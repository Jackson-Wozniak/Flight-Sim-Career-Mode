package com.api.career_mode.flight_components.plane;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class PlaneOwnedId implements Serializable {

    private String username;
    private String planeName;
}
