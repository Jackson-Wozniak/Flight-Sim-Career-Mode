package com.api.career_mode.flight_components.plane;

import java.util.List;
import java.util.stream.Collectors;

public class PlaneCsvMapper {

    public static List<Plane> mapAllLinesToPlanes(List<String> lines){
        return lines.stream()
                .map(PlaneCsvMapper::planeLineMapper)
                .collect(Collectors.toList());
    }

    private static Plane planeLineMapper(String line){
        String[] lineComponents = line.replace("\"", "").split(",");
        return new Plane(
                lineComponents[0],
                Integer.parseInt(lineComponents[1]),
                Integer.parseInt(lineComponents[2]),
                //if no plane type is found, maps to DEFAULT type
                PlaneType.mapStringToPlaneType(lineComponents[3])
        );
    }
}
