package com.api.career_mode.flight_components.enums;

public enum PlaneType {
    PROPELLER,
    AIRLINER,
    TURBOPROP,
    JET,
    HELICOPTER,
    GLIDER,
    DEFAULT;

    public static PlaneType mapStringToPlaneType(String planeType){
        return switch(planeType.toUpperCase()){
            case "PROPELLER" -> PROPELLER;
            case "AIRLINER" -> AIRLINER;
            case "TURBOPROP" -> TURBOPROP;
            case "JET" -> JET;
            case "HELICOPTER" -> HELICOPTER;
            case "GLIDER" -> GLIDER;
            default -> DEFAULT;
        };
    }
}
