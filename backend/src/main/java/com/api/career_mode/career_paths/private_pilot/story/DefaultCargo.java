package com.api.career_mode.career_paths.private_pilot.story;

import java.util.List;

public class DefaultCargo {

    public static List<Cargo> getAllDefaultCargo(){
        return List.of(
                //2 in 100 chance
                new Cargo("Gold", 1.5, 0L),
                //30 in 100 chance
                new Cargo("CDs", 1.05, 0L),
                //30 in 100 chance
                new Cargo("Lumber", 1.1, 0L),
                //30 in 100 chance
                new Cargo("Steel", 1.2, 0L),
                //8 in 100 chance
                new Cargo("Automotive Parts", 1.35, 0L)
        );
    }

    public static Cargo getDefaultCargoByName(String cargoName){
        return switch (cargoName){
            case "Gold" -> new Cargo("Gold", 1.5, 0L);
            case "CDs" -> new Cargo("CDs", 1.05, 0L);
            case "Steel" -> new Cargo("Steel", 1.2, 0L);
            case "Automotive Parts" -> new Cargo("Automotive Parts", 1.35, 0L);
            default ->  new Cargo("Lumber", 1.1, 0L);
        };

    }
}
