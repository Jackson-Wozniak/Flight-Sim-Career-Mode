package com.api.career_mode.flight_components.plane;

import com.api.career_mode.flight_components.entity.Plane;
import com.api.career_mode.flight_components.enums.PlaneType;
import com.api.career_mode.flight_components.utils.PlaneCsvMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaneCsvMapperTest {

    private static final File planeFile = new File("data/planes.csv");

    @Test
    void planeMapperReturnsCorrectSize() {
        assertDoesNotThrow(() -> {
            List<String> planeLines = getListOfPlaneCsvLinesForTesting();
            List<Plane> planes = PlaneCsvMapper.mapAllLinesToPlanes(planeLines);
            assertEquals(33, planes.size());
        });
    }

    @Test
    void planesMapsCorrectly(){
        String testPlaneLine = "TEST,1,0,Propeller";
        Plane plane = PlaneCsvMapper.mapAllLinesToPlanes(List.of(testPlaneLine)).get(0);
        //test all 7 fields
        assertEquals("TEST", plane.getPlaneName());
        assertEquals(1, plane.getCruisingSpeedInKnots());
        assertEquals(0, plane.getRangeInMiles());
        assertEquals(PlaneType.PROPELLER, plane.getPlaneType());
    }

    @Test
    void defaultPlaneTypeMapsCorrectly(){
        String testPlaneLine = "TEST,1,0,Test";
        Plane plane = PlaneCsvMapper.mapAllLinesToPlanes(List.of(testPlaneLine)).get(0);
        //test all 7 fields
        assertEquals("TEST", plane.getPlaneName());
        assertEquals(1, plane.getCruisingSpeedInKnots());
        assertEquals(0, plane.getRangeInMiles());
        assertEquals(PlaneType.DEFAULT, plane.getPlaneType());
    }

    private static List<String> getListOfPlaneCsvLinesForTesting() throws IOException {
        return Files.lines(planeFile.toPath()).toList();
    }
}