package com.example.marinemonitoring.repository;

import com.example.marinemonitoring.model.WaterQualityRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterQualityRecordRepository extends JpaRepository<WaterQualityRecord, Long> {

    List<WaterQualityRecord> findByStationId(Integer stationId);

}
