package com.example.marinemonitoring.service;

import com.example.marinemonitoring.model.Station;
import com.example.marinemonitoring.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    // This method fetches all stations from DB
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }
}
