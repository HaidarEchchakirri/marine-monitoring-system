package com.example.marinemonitoring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "water_quality_data")
public class WaterQualityRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_id")
    private Integer stationId;

    private Integer year;
    private Integer month;
    private Integer day;

    private LocalDateTime time;
    private String season;

    @Column(name = "tide_status")
    private String tideStatus;

    private Float temp;
    private Float ph;
    private Float psu;

    @Column(name = "dissolved_oxygen")
    private Float dissolvedOxygen;

    private Float seston;
    private Float cod;

    @Column(name = "no_3")
    private Float no3;

    @Column(name = "no_2")
    private Float no2;

    @Column(name = "nh_3")
    private Float nh3;

    @Column(name = "po_4")
    private Float po4;

    private Float n;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTideStatus() {
        return tideStatus;
    }

    public void setTideStatus(String tideStatus) {
        this.tideStatus = tideStatus;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getPh() {
        return ph;
    }

    public void setPh(Float ph) {
        this.ph = ph;
    }

    public Float getPsu() {
        return psu;
    }

    public void setPsu(Float psu) {
        this.psu = psu;
    }

    public Float getDissolvedOxygen() {
        return dissolvedOxygen;
    }

    public void setDissolvedOxygen(Float dissolvedOxygen) {
        this.dissolvedOxygen = dissolvedOxygen;
    }

    public Float getSeston() {
        return seston;
    }

    public void setSeston(Float seston) {
        this.seston = seston;
    }

    public Float getCod() {
        return cod;
    }

    public void setCod(Float cod) {
        this.cod = cod;
    }

    public Float getNo3() {
        return no3;
    }

    public void setNo3(Float no3) {
        this.no3 = no3;
    }

    public Float getNo2() {
        return no2;
    }

    public void setNo2(Float no2) {
        this.no2 = no2;
    }

    public Float getNh3() {
        return nh3;
    }

    public void setNh3(Float nh3) {
        this.nh3 = nh3;
    }

    public Float getPo4() {
        return po4;
    }

    public void setPo4(Float po4) {
        this.po4 = po4;
    }

    public Float getN() {
        return n;
    }

    public void setN(Float n) {
        this.n = n;
    }
}
