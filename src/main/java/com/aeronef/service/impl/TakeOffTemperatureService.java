package com.aeronef.service.impl;

import com.aeronef.data.domain.TemperatureDeviationEntity;
import com.aeronef.data.mapper.TemperatureDeviationMapper;
import com.aeronef.data.repository.TemperatureDeviationRepository;
import com.aeronef.dto.TempDevResult;
import com.aeronef.enums.AirCraftDataType;
import com.aeronef.service.TemperatureService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aeronef.tools.Utils.calculTemperature;

@Service
@Log4j2
public class TakeOffTemperatureService implements TemperatureService {
    @Autowired
    private TemperatureDeviationRepository temperatureDeviationRepository;

    @Override
    public TempDevResult getTemperatureDeviation(String acModel, String altitude, String aeroPhase) {
        List<TemperatureDeviationEntity> temperatureDeviationEntityTmaxG = temperatureDeviationRepository
                .findByAircraftIdAndAirCraftType (acModel, AirCraftDataType.TMAX_G.getValue ());

        List<TemperatureDeviationEntity> temperatureDeviationEntityTminG = temperatureDeviationRepository
                .findByAircraftIdAndAirCraftType (acModel, AirCraftDataType.TMIN_G.getValue ());

        TempDevResult result = new TempDevResult ();

        if(!temperatureDeviationEntityTmaxG.isEmpty ()){
            result.setTMaxK (calculTemperature(temperatureDeviationEntityTmaxG, altitude));
        }

        if(!temperatureDeviationEntityTminG.isEmpty ()){
            result.setTMinK (calculTemperature(temperatureDeviationEntityTminG, altitude));
        }

        return result;
    }

}
