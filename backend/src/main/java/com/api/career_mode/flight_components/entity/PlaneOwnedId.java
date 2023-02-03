package com.api.career_mode.flight_components.entity;

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
