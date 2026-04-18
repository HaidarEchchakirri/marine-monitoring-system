package com.example.marinemonitoring.controller;

import com.example.marinemonitoring.model.WaterQualityRecord;
import com.example.marinemonitoring.repository.WaterQualityRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waterquality")
@CrossOrigin(origins = "*")
public class WaterQualityController {

    private final WaterQualityRecordRepository waterQualityRecordRepository;

    public WaterQualityController(WaterQualityRecordRepository waterQualityRecordRepository) {
        this.waterQualityRecordRepository = waterQualityRecordRepository;
    }

    @GetMapping
    public List<WaterQualityRecord> getAllWaterQualityRecords() {
        return waterQualityRecordRepository.findAll();
    }

    @GetMapping("/station/{stationId}")
    public List<WaterQualityRecord> getRecordsByStation(@PathVariable Integer stationId) {
        return waterQualityRecordRepository.findByStationId(stationId);
    }
}
