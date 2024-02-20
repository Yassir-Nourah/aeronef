package com.aeronef.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AirCraftDataType {
    /**
     * maximum_temperature_deviation_in_flight
     */
    TMAX_F("TMAX_F"),
    /**
     * minimum_temperature_deviation_in_flight
     */
    TMIN_F ("TMIN_F"),
    /**
     * maximum_temperature_deviation_in_TOLD
     */
    TMAX_G ("TMAX_G"),
    /**
     * minimum_temperature_deviation_in_TOLD
     */
    TMIN_G ("TMIN_G");

    /**
     * Enumeration value
     */
    private String value;
}
