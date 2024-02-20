package com.aeronef.data.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name= "TEMPERATURE_DEVIATION")
public class TemperatureDeviationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="AIRCRAFT_ID")
    private String aircraftId;
    private String altitude;
    private String temperature;
    @Column(name="AIRCRAFT_TYPE")
    private String airCraftType;

    public TemperatureDeviationEntity() {
    }

    public TemperatureDeviationEntity(long id, String aircraftId, String altitude, String temperature, String airCraftType) {
        this.id = id;
        this.aircraftId = aircraftId;
        this.altitude = altitude;
        this.temperature = temperature;
        this.airCraftType = airCraftType;
    }
}
