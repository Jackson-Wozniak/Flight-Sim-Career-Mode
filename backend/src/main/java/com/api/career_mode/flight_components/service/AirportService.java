package com.api.career_mode.flight_components.service;

import com.api.career_mode.flight_components.entity.Airport;
import com.api.career_mode.flight_components.exception.AirportNotFoundException;
import com.api.career_mode.flight_components.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AirportService {

    @Autowired
    private final AirportRepository airportRepository;

    public void saveAllAirports(List<Airport> airports){
        airportRepository.saveAll(airports);
    }

    public Airport findAirportByIcao(String airportName){
        return airportRepository.findById(airportName).orElseThrow(
                () -> new AirportNotFoundException("No airport named " + airportName));
    }

    public List<Airport> findAllAirports(){
        return airportRepository.findAll();
    }

    public List<Airport> findAllAirportsByCountry(String country){
        return airportRepository.findAllAirportsByCountry();
    }

    @Transactional
    public void deleteAllAirports(){
        airportRepository.deleteAll();
    }

    public long findAirportRowCount(){
        return airportRepository.count();
    }
}
