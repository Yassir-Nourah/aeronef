package com.aeronef.service.impl;

import com.aeronef.data.domain.TemperatureDeviationEntity;
import com.aeronef.data.mapper.TemperatureDeviationMapper;
import com.aeronef.data.repository.TemperatureDeviationRepository;
import com.aeronef.dto.TempDevResult;
import com.aeronef.enums.AirCraftDataType;
import com.aeronef.service.TemperatureService;
import com.aeronef.tools.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.aeronef.tools.Utils.calculTemperature;

@Service
@Log4j2
public class CruiseTemperatureService implements TemperatureService {
    @Autowired
    private TemperatureDeviationRepository temperatureDeviationRepository;
    @Override
    public TempDevResult getTemperatureDeviation(String acModel, String altitude, String aeroPhase) {

        List<TemperatureDeviationEntity> temperatureDeviationEntityTmaxF = temperatureDeviationRepository
                .findByAircraftIdAndAirCraftType (acModel, AirCraftDataType.TMAX_F.getValue ());

        List<TemperatureDeviationEntity> temperatureDeviationEntityTminF = temperatureDeviationRepository
                .findByAircraftIdAndAirCraftType (acModel, AirCraftDataType.TMIN_F.getValue ());

        TempDevResult result = new TempDevResult ();

        if(!temperatureDeviationEntityTmaxF.isEmpty ()){
            result.setTMaxK (calculTemperature(temperatureDeviationEntityTmaxF, altitude));
        }

        if(!temperatureDeviationEntityTminF.isEmpty ()){
            result.setTMinK (calculTemperature(temperatureDeviationEntityTminF, altitude));
        }

        return result;
    }

}
