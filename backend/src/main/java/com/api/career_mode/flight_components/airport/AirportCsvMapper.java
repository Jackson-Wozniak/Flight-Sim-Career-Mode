package com.api.career_mode.flight_components.airport;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AirportCsvMapper {

    private static final Locale locale = new Locale("US");

    public static List<Airport> mapAllLinesToAirports(List<String> lines) {
        return lines.stream()
                .map(AirportCsvMapper::airportLineMapper)
                .collect(Collectors.toList());
    }

    public static Airport airportLineMapper(String line){
        String[] lineComponents = line.replace("\"", "").split(",");
        return new Airport(
                lineComponents[0],
                lineComponents[1],
                lineComponents[2],
                Double.parseDouble(lineComponents[3]),
                Double.parseDouble(lineComponents[4]),
                new Locale("", lineComponents[5]).getDisplayCountry(),
                ContinentUtils.getContinentByCode(lineComponents[6])
        );
    }
}
