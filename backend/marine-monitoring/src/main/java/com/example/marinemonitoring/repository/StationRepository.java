package com.example.marinemonitoring.repository;

import com.example.marinemonitoring.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
