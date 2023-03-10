package com.api.career_mode.career_paths.private_pilot.story.cargo;

import com.api.career_mode.career_paths.private_pilot.story.entity.Cargo;

/*
Cargo for flights is saved in the database as an Enum String.
When querying for the given flight, it uses the methods in this class to map to a default cargo object.
This approach makes it easier to update cargo values without to validate matching values
    such as multipliers and amount of text file lines
 */
public enum CargoType {
    GOLD,
    CDs,
    LUMBER,
    STEEL,
    AUTOMOTIVE_PARTS;

    public static Cargo mapCargoTypeToObject(CargoType cargoType){
        return switch (cargoType){
            case GOLD -> DefaultCargo.getDefaultCargoByName("Gold");
            case CDs -> DefaultCargo.getDefaultCargoByName("CDs");
            case STEEL -> DefaultCargo.getDefaultCargoByName("Steel");
            case LUMBER -> DefaultCargo.getDefaultCargoByName("Lumber");
            case AUTOMOTIVE_PARTS -> DefaultCargo.getDefaultCargoByName("Automotive Parts");
        };
    }

    public static CargoType mapCargoToType(Cargo cargo){
        return switch (cargo.getCargoName().toUpperCase()){
            case "GOLD" -> GOLD;
            case "CDS" -> CDs;
            case "STEEL" -> STEEL;
            case "AUTOMOTIVE PARTS" -> AUTOMOTIVE_PARTS;
            default -> LUMBER;
        };
    }
}
