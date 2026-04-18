package com.example.marinemonitoring.controller;

import com.example.marinemonitoring.model.Station;
import com.example.marinemonitoring.repository.StationRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
@CrossOrigin(origins = "*") // allow frontend to access it
public class StationController {

    private final StationRepository repository;

    public StationController(StationRepository repository) {
        this.repository = repository;
    }

    // Get all stations (basic info)
    @GetMapping
    public List<Station> getAllStations() {
        return repository.findAll();
    }

    // Get detailed data for a specific station by ID
    @GetMapping("/{id}/data")
    public Station getStationData(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Station not found"));
    }
}


