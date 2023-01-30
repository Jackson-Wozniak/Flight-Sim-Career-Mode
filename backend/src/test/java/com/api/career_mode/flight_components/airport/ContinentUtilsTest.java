package com.api.career_mode.flight_components.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContinentUtilsTest {

    @Test
    void continentMapperValidations(){
        assertEquals("North America", ContinentUtils.getContinentByCode("NA"));
        assertEquals("South America", ContinentUtils.getContinentByCode("SA"));
        assertEquals("Europe", ContinentUtils.getContinentByCode("EU"));
        assertEquals("Africa", ContinentUtils.getContinentByCode("AF"));
        assertEquals("Asia", ContinentUtils.getContinentByCode("AS"));
        assertEquals("Oceania", ContinentUtils.getContinentByCode("OC"));
    }

    @Test
    void incorrectContinentCodesReturnItself(){
        assertEquals("", ContinentUtils.getContinentByCode(""));
        assertEquals("Test", ContinentUtils.getContinentByCode("Test"));
    }
}