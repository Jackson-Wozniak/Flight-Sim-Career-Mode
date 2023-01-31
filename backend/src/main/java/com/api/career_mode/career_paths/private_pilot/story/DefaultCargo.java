package com.api.career_mode.career_paths.private_pilot.story;

import java.util.List;

public class DefaultCargo {

    private static List<Cargo> getAllDefaultCargo(){
        return List.of(
                new Cargo("Gold", 1.5),
                new Cargo("CDs", 1.05),
                new Cargo("Lumber", 1.1),
                new Cargo("Steel", 1.2),
                new Cargo("Automotive Parts", 1.35)
        );
    }
}
