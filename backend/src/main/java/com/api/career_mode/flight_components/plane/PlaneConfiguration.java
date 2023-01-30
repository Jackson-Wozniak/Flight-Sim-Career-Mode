package com.api.career_mode.flight_components.plane;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Service
@AllArgsConstructor
public class PlaneConfiguration {

    @Autowired
    private final PlaneService planeService;
    private static final Logger logger = LoggerFactory.getLogger(PlaneConfiguration.class);
    private static final File planeFile = new File("data/planes.csv");

    @PostConstruct
    public void savePlanesOnStartup() throws IOException {
        List<String> planeLines = Files.lines(planeFile.toPath()).toList();
        List<Plane> planes = PlaneCsvMapper.mapAllLinesToPlanes(planeLines);

        if(planes.size() != planeService.findPlaneRowCount()){
            /*
            Delete all planes in case there is mismatch with current DB planes
                and desired planes
             */
            planeService.deleteAllPlanes();
            logger.info("Saving " + (planes.size() - planeService.findPlaneRowCount()) + " Planes");
            planeService.saveAllPlanes(planes);
        }
        logger.info(planeService.findPlaneRowCount() + " Planes In Database");
    }
}
