package com.api.career_mode.flight_components.utils;

import java.util.HashMap;
import java.util.Map;

public class ContinentUtils {

    public static String getContinentByCode(String code){
        return switch (code.toUpperCase()){
            case "NA" -> "North America";
            case "SA" -> "South America";
            case "OC" -> "Oceania";
            case "AF" -> "Africa";
            case "AS" -> "Asia";
            case "EU" -> "Europe";
            default -> code;
        };
    }
}
