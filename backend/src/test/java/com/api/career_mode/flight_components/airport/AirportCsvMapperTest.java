package com.api.career_mode.flight_components.airport;

import com.api.career_mode.flight_components.entity.Airport;
import com.api.career_mode.flight_components.utils.AirportCsvMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirportCsvMapperTest {

    private static final File airportFile = new File("data/airports.csv");

    @Test
    void airportMapperReturnsCorrectSize() {
        assertDoesNotThrow(() -> {
            List<String> airportLines = getListOfAirportCsvLinesForTesting();
            List<Airport> airports = AirportCsvMapper.mapAllLinesToAirports(airportLines);
            assertEquals(44304, airports.size());
        });
    }

    @Test
    void airportMapsCorrectly(){
        String testAirportLine = "TEST,Test Size,Test Name,0.0,1.0,Test Country,Test Continent";
        Airport airport = AirportCsvMapper.mapAllLinesToAirports(List.of(testAirportLine)).get(0);
        //test all 7 fields
        assertEquals("TEST", airport.getIcaoCode());
        assertEquals("Test Size", airport.getAirportSize());
        assertEquals("Test Name", airport.getAirportName());
        assertEquals(0.0, airport.getLatitude());
        assertEquals(1.0, airport.getLongitude());
        assertEquals("TEST COUNTRY", airport.getCountry());
        assertEquals("Test Continent", airport.getContinent());
    }

    @Test
    void airportLocationMapsCorrectly(){
        String testAirportLine = "TEST,Test Size,Test Name,0.0,1.0,US,NA";
        String testAirportLine2 = "TEST,Test Size,Test Name,0.0,1.0,GB,EU";
        List<Airport> airports = AirportCsvMapper.mapAllLinesToAirports(
                List.of(testAirportLine, testAirportLine2));
        assertEquals("United States", airports.get(0).getCountry());
        assertEquals("North America", airports.get(0).getContinent());
        assertEquals("United Kingdom", airports.get(1).getCountry());
        assertEquals("Europe", airports.get(1).getContinent());
    }

    private static List<String> getListOfAirportCsvLinesForTesting() throws IOException {
        return Files.lines(airportFile.toPath()).toList();
    }

}