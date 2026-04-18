package com.example.marinemonitoring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.example.marinemonitoring.model.SpeciesDistribution;
import com.example.marinemonitoring.service.SpeciesDistributionService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")  // Add your frontend URL here
public class SpeciesController {

    private final SpeciesDistributionService speciesService;

    public SpeciesController(SpeciesDistributionService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping("/species-distribution")
    public List<SpeciesDistribution> getSpeciesDistribution() {
        return speciesService.getAllSpeciesDistribution();
    }
}

