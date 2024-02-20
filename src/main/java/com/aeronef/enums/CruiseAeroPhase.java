package com.aeronef.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CruiseAeroPhase {

    CRUISE("CRUISE"),

    INITIAL_CLIMB ("INITIAL_CLIMB"),

    APPROACH ("APPROACH");

    /**
     * Enumeration value
     */
    private String value;
}
