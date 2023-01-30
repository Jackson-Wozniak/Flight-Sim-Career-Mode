package com.api.career_mode.flight_components.airport;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class AirportConfiguration {

    @Autowired
    private final AirportService airportService;
    private static final Logger logger = LoggerFactory.getLogger(AirportConfiguration.class);
    private static final File airportFile = new File("data/airports.csv");


    @PostConstruct
    public void saveAirportsOnStartup() throws IOException {
        List<String> airportLines = Files.lines(airportFile.toPath()).toList();
        List<Airport> airports = AirportCsvMapper.mapAllLinesToAirports(airportLines);

        if(airports.size() != airportService.findAirportRowCount()) {
            /*
            Delete all airports in case there is mismatch with current DB airports
                and desired airports
             */
            airportService.deleteAllAirports();
            logger.info("Saving " + (airports.size() - airportService.findAirportRowCount()) + " airports");
            airportService.saveAllAirports(airports);
        }
        logger.info(airportService.findAirportRowCount() + " Airports In Database");
    }
}
