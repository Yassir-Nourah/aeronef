package com.aeronef.controller;

import com.aeronef.dto.TempDevResult;
import com.aeronef.enums.CruiseAeroPhase;
import com.aeronef.enums.TakeOffAeroPhase;
import com.aeronef.service.TemperatureService;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AeronefController {
    @Qualifier("cruiseTemperatureService")
    @Autowired
    private TemperatureService cruiseTemperatureService;

    @Qualifier("takeOffTemperatureService")
    @Autowired
    private TemperatureService takeOffTemperatureService;

    @GetMapping("/temperature")
    public ResponseEntity<TempDevResult> getTemperature(String acModel, String altitude, String aeroPhase){
        if(EnumUtils.isValidEnum (CruiseAeroPhase.class, aeroPhase))
            return ResponseEntity.ok (cruiseTemperatureService.getTemperatureDeviation (acModel, altitude, aeroPhase));
        else if(EnumUtils.isValidEnum (TakeOffAeroPhase.class, aeroPhase))
            return ResponseEntity.ok (takeOffTemperatureService.getTemperatureDeviation (acModel, altitude, aeroPhase));
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
