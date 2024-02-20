package com.aeronef.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TakeOffAeroPhase {

    TAKEOFF("TAKEOFF"),

    LANDING ("LANDING");

    /**
     * Enumeration value
     */
    private String value;
}
