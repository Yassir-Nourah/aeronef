package com.aeronef.service;

import com.aeronef.data.domain.TemperatureDeviationEntity;
import com.aeronef.data.repository.TemperatureDeviationRepository;
import com.aeronef.dto.TempDevResult;
import com.aeronef.service.impl.TakeOffTemperatureService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.aeronef.tools.TestUtil.mockTemperatureDeviationEntityListMaxG;
import static com.aeronef.tools.TestUtil.mockTemperatureDeviationEntityListMinG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TakeOffTemperatureServiceUTest {
    @InjectMocks
    private TakeOffTemperatureService takeOffTemperatureService;
    @Mock
    private TemperatureDeviationRepository temperatureDeviationRepository;

    @Test
    void getTemperatureDeviationTest(){
        TempDevResult resultMock = TempDevResult.builder ().tMinK (Float.valueOf ("-43.0")).tMaxK (Float.valueOf ("39.4"))
                .build ();
        List<TemperatureDeviationEntity> deviationEntityListMaxG = mockTemperatureDeviationEntityListMaxG();
        List<TemperatureDeviationEntity> deviationEntityListMinG = mockTemperatureDeviationEntityListMinG();

        when(temperatureDeviationRepository.findByAircraftIdAndAirCraftType ("B772LRR", "TMAX_G"))
                .thenReturn (deviationEntityListMaxG);

        when(temperatureDeviationRepository.findByAircraftIdAndAirCraftType ("B772LRR", "TMIN_G"))
                .thenReturn (deviationEntityListMinG);

        TempDevResult result = takeOffTemperatureService.getTemperatureDeviation ("B772LRR", "8500", "TAKEOFF");

        assertEquals(result.getTMaxK (), resultMock.getTMaxK ());
    }
}
