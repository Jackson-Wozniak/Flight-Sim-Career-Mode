package com.api.career_mode.career_paths.private_pilot.story;

import java.util.List;

public class DefaultCargo {

    public static List<Cargo> getAllDefaultCargo(){
        return List.of(
                new Cargo("Gold", 1.5, 0L),
                new Cargo("CDs", 1.05, 0L),
                new Cargo("Lumber", 1.1, 0L),
                new Cargo("Steel", 1.2, 0L),
                new Cargo("Automotive Parts", 1.35, 0L)
        );
    }
}
