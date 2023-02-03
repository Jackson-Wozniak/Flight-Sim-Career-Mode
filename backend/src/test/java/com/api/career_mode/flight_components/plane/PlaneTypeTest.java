package com.api.career_mode.flight_components.plane;

import com.api.career_mode.flight_components.enums.PlaneType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTypeTest {

    @Test
    void planeTypeMapperValidation(){
        assertEquals(PlaneType.PROPELLER, PlaneType.mapStringToPlaneType("Propeller"));
        assertEquals(PlaneType.AIRLINER, PlaneType.mapStringToPlaneType("Airliner"));
        assertEquals(PlaneType.TURBOPROP, PlaneType.mapStringToPlaneType("Turboprop"));
        assertEquals(PlaneType.JET, PlaneType.mapStringToPlaneType("Jet"));
        assertEquals(PlaneType.HELICOPTER, PlaneType.mapStringToPlaneType("Helicopter"));
        assertEquals(PlaneType.GLIDER, PlaneType.mapStringToPlaneType("Glider"));
    }

    @Test
    void invalidPlaneTypeReturnsDefault(){
        assertEquals(PlaneType.DEFAULT, PlaneType.mapStringToPlaneType(""));
        assertEquals(PlaneType.DEFAULT, PlaneType.mapStringToPlaneType("Test"));
    }
}