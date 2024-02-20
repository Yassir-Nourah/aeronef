package com.aeronef.service;

import com.aeronef.dto.TempDevResult;

public interface TemperatureService {
    TempDevResult getTemperatureDeviation (String acModel, String altitude, String aeroPhase);
}
