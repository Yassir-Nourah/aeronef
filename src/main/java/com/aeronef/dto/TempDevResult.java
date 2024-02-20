package com.aeronef.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TempDevResult {
    private Float tMinK;
    private Float tMaxK;

    public TempDevResult() {
    }

    public TempDevResult(Float tMinK, Float tMaxK) {
        this.tMinK = tMinK;
        this.tMaxK = tMaxK;
    }
}
