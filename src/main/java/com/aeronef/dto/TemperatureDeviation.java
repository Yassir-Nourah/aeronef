package com.aeronef.dto;

import lombok.Data;

@Data
public class TemperatureDeviation {
    private long id;
    private String aircraftId;
    private String altitude;
    private String temperature;
    private String airCraftType;
}
