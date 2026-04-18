package com.example.marinemonitoring.service;

import com.example.marinemonitoring.model.SpeciesDistribution;
import com.example.marinemonitoring.repository.SpeciesDistributionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesDistributionService {

    private final SpeciesDistributionRepository repository;

    public SpeciesDistributionService(SpeciesDistributionRepository repository) {
        this.repository = repository;
    }

    public List<SpeciesDistribution> getAllSpeciesDistribution() {
        return repository.findAll();
    }
}
