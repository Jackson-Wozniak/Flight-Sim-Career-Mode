package com.api.career_mode.pilot.payload;

public record PilotCreatorRequest(String username, String password, String pilotName,
                                  String homeCountry) {
}
