package com.example.marinemonitoring.config;

import com.example.marinemonitoring.model.Station;
import com.example.marinemonitoring.repository.StationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final StationRepository stationRepository;

    public DataInitializer(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @PostConstruct
    public void init() {
        if (stationRepository.count() == 0) {
            stationRepository.save(new Station("RD1", 32.6889869, 121.9991178));
            stationRepository.save(new Station("RD2", 32.7354689, 122.0765947));
            stationRepository.save(new Station("RD3", 32.7633608, 122.1230558));
            stationRepository.save(new Station("RD4", 32.6236038, 121.9818289));
        }
    }
}
